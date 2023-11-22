package com.rhl.plugin.notepad.window;

import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.wm.ToolWindow;
import com.rhl.plugin.notepad.data.DataCenter;
import com.rhl.plugin.notepad.util.MDUtils;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Auther: 你的昵称是抢我的
 * @Date: 2023/11/21 22:41
 * @Description:
 */
public class NoteListWindow {
    private JPanel content;
    private JPanel underPanel;
    private JPanel topPanel;
    private JScrollPane centerPanel;
    private JButton generateBtn;
    private JButton clearBtn;
    private JButton closeBtn;
    private JTextField titleField;
    private JTable contentTable;
    private JButton removeBtn;


    private void init() {
        contentTable.setModel(DataCenter.TABLE_MODEL);
        contentTable.setEnabled(true);
    }

    public NoteListWindow(Project project, ToolWindow toolWindow) {
        init();
        //生成MD文档
        generateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String title = titleField.getText();
                if (StringUtils.isBlank(title)) {
                    /* MessageDialogBuilder.yesNo("操作结果","标题不能为空").();*/
//                    Messages.showYesNoDialog("标题不能为空", title, Messages.getQuestionIcon());
                    Messages.showErrorDialog("标题不能为空", title);
                    return;
                }

                String fileName = title + ".md";

                VirtualFile virtualFile = FileChooser.chooseFile(FileChooserDescriptorFactory.createSingleFolderDescriptor(), project, project.getBaseDir());
                if (virtualFile != null) {
                    String path = virtualFile.getPath();
                    String fileFullPath = path + "/" + fileName;
                    MDUtils.generateMarkdownDocument(title, fileFullPath, DataCenter.NOTE_LIST);
                }
            }
        });
        //清空列表
        clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int result = Messages.showYesNoDialog(String.format("确定要清空列表吗?"), "清空", Messages.getQuestionIcon());
                if (result == Messages.YES) {
                    DataCenter.reset();
                    Messages.showInfoMessage("清除成功", "操作结果");
                }
            }
        });
        //关闭
        closeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toolWindow.hide(null);
            }
        });
        //移除已选择
        removeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //这里拿到的是索引 假如存在分页情况的下 会导致数据不正确
                int[] selectedRows = contentTable.getSelectedRows();
                if (selectedRows.length <= 0){
                    Messages.showErrorDialog("未选择任何数据","操作结果");
                    return;
                }
                int result = Messages.showYesNoDialog(String.format("确定要删除选中的数据吗?"), "删除", Messages.getQuestionIcon());
                if (result == Messages.YES) {
                    List<Integer> indexs = new ArrayList<>(selectedRows.length);
                    for (int selectedRow : selectedRows) {
                        indexs.add(selectedRow);
                    }

                    //这里要是用倒叙删除 否则 会下标越界异常
                    Collections.sort(indexs, Collections.reverseOrder());
                    for (Integer selectedRow : indexs) {
                        DataCenter.TABLE_MODEL.removeRow(selectedRow);
                    }

                    DataCenter.removeAll(indexs);
                    Messages.showInfoMessage("删除成功", "操作结果");
                }
            }
        });
    }

    public JPanel getContent() {
        return content;
    }
}
