package com.rhl.plugin.notepad.window;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.rhl.plugin.notepad.data.DataCenter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JTextField textField1;
    private JTable contentTable;
    private JButton removeBtn;


    private void init(){
        contentTable.setModel(DataCenter.TABLE_MODEL);
        contentTable.setEnabled(true);
    }

    public NoteListWindow(Project project, ToolWindow toolWindow) {
        init();
        //生成MD文档
        generateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        //清空列表
        clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DataCenter.reset();
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

                //TODO 这里的话 要先提示

            }
        });
    }

    public JPanel getContent() {
        return content;
    }
}
