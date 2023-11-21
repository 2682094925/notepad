package com.rhl.plugin.notepad.data;

import com.rhl.plugin.notepad.util.DateUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: 你的昵称是抢我的
 * @Date: 2023/11/21 21:48
 * @Description: 数据 实体类
 */
public class NoteData implements Serializable {

      /**
       * 唯一主键
       */
      private Long id;

      /**
       * 笔记标题
       */
      private String title;
      /**
       * 笔记内容
       */
      private String mark;
      /**
       * 标记的源码
       */
      private String content;
      /**
       * 源码所在的文件名
       */
      private String fileName;
      /**
       * 源码所在的文件类型
       */
      private String fileType;

      /**
       * 添加时间
       */
      private String addTime = DateUtils.format(new Date());

      public NoteData(Long id, String title, String mark, String content, String fileName, String fileType) {
            this.id = id;
            this.title = title;
            this.mark = mark;
            this.content = content;
            this.fileName = fileName;
            this.fileType = fileType;
      }

      public Long getId() {
            return id;
      }

      public void setId(Long id) {
            this.id = id;
      }

      public String getTitle() {
            return title;
      }

      public void setTitle(String title) {
            this.title = title;
      }

      public String getMark() {
            return mark;
      }

      public void setMark(String mark) {
            this.mark = mark;
      }

      public String getContent() {
            return content;
      }

      public void setContent(String content) {
            this.content = content;
      }

      public String getFileName() {
            return fileName;
      }

      public void setFileName(String fileName) {
            this.fileName = fileName;
      }

      public String getFileType() {
            return fileType;
      }

      public void setFileType(String fileType) {
            this.fileType = fileType;
      }

      public String getAddTime() {
            return addTime;
      }

      public void setAddTime(String addTime) {
            this.addTime = addTime;
      }

      public String[] toStringArray() {
            return new String[]{String.valueOf(this.id),this.title,this.mark,this.fileName,this.content,this.addTime};
      }
}
