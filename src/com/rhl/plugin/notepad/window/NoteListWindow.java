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

    private void init(){
        contentTable.setModel(DataCenter.TABLE_MODEL);
        contentTable.setEnabled(true);
    }

    public NoteListWindow(Project project, ToolWindow toolWindow) {
        init();
        generateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        closeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public JPanel getContent() {
        return content;
    }
}