package com.rhl.plugin.notepad.util;

import com.intellij.openapi.ui.MessageDialogBuilder;
import com.intellij.openapi.ui.Messages;
import com.rhl.plugin.notepad.data.NoteData;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @Auther: 你的昵称是抢我的
 * @Date: 2023/11/22 13:28
 * @Description:
 */
public class MDUtils {


    /**
     * 生成md文档
     * @param title 文档标题
     * @param filePath 文档路径
     * @param noteList 列表集合
     */
   public static void  generateMarkdownDocument(String title,String filePath, List<NoteData> noteList){
       String topic = String.format("## %s\n[TOC]\n", title);
       String template =
              "### %s\n" +
              "#### 笔记内容\n" +
              "` %s `\n" +
              "#### 文件名称\n" +
              "` %s `\n" +
              "``` %s\n" +
              "%s\n" +
              "```";

       String markdownContent = topic;

       for (NoteData noteData : noteList) {
           markdownContent += "\n" + String.format(template,
                   noteData.getTitle(),
                   format(noteData.getMark(),66),
                   noteData.getFileName(),
                   noteData.getFileType(),
                   noteData.getContent()
           );
       }
       try (FileWriter writer = new FileWriter(filePath)) {
           writer.write(markdownContent);
           Messages.showInfoMessage("成功", "操作结果");
           // 打开文件所在目录
           File file = new File(filePath);
           File parentDir = file.getParentFile();
           if (parentDir != null && Desktop.isDesktopSupported()) {
               Desktop.getDesktop().open(parentDir);
           }
       } catch (IOException e) {
           Messages.showErrorDialog("生成文档出错: "+e.getMessage(), title);
       }

   }

    /**
     * 格式化字符串
     * @param source
     * @param length
     * @return
     */
   public static String format(String source,int length){
       if (length <= 0) {
           throw new IllegalArgumentException("Length must be greater than 0");
       }

       source = source.replaceAll("(\\n{2,})", "\n");
       StringBuilder result = new StringBuilder();
       StringBuilder line = new StringBuilder();
       int index = 0;
       while (index < source.length()) {
           char currentChar = source.charAt(index);
           line.append(currentChar);
           if (currentChar == ' ' || currentChar == ',' || currentChar == '.' || currentChar == ';' || currentChar == ':') {
               // 如果当前字符是空格或标点符号，尝试将下一个字符也放在当前行
               if (index < source.length() - 1) {
                   char nextChar = source.charAt(index + 1);
                   if (nextChar != ' ' && nextChar != ',' && nextChar != '.' && nextChar != ';' && nextChar != ':') {
                       line.append(nextChar);
                       index++;
                   }
               }
           }

           if (line.length() >= length || index == source.length() - 1) {
               // 当行长度达到指定长度，或已遍历到字符串末尾时，将当前行添加到结果中，并重置当前行
               result.append(line).append("\n");
               line.setLength(0);
           }

           index++;
       }

       return result.toString();
   }
}
