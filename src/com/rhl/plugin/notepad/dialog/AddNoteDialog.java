package com.rhl.plugin.notepad.dialog;

import com.intellij.openapi.graph.layout.hierarchic.incremental.NodeData;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.ui.EditorTextField;
import com.rhl.plugin.notepad.data.DataCenter;
import com.rhl.plugin.notepad.data.NoteData;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;
import java.time.Instant;

public class AddNoteDialog extends DialogWrapper {
    /**
     * 标题输入框
     */
    private EditorTextField etfTitle;
    /**
     * 内容输入框
     */
    private EditorTextField etfMark;


    public AddNoteDialog() {
        super(true);
        init();
        setTitle("添加笔记注释");
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        etfTitle = new EditorTextField("笔记标题");
        etfMark = new EditorTextField("笔记内容");
        etfMark.setPreferredSize(new Dimension(200,100));
        panel.add(etfTitle, BorderLayout.NORTH);
        panel.add(etfMark, BorderLayout.CENTER);
        return panel;
    }

    @Override
    protected JComponent createSouthPanel() {
        JPanel panel = new JPanel(new FlowLayout());
        JButton btnAdd = new JButton("添加到笔记列表");
        //按钮点击事件处理
        btnAdd.addActionListener(e -> {
            //获取标题
            String title = etfTitle.getText();
            //获取内容
            String content = etfMark.getText();

            //获取后缀
            String fileType = DataCenter.CURRENT_FILE_NAME.substring(DataCenter.CURRENT_FILE_NAME.lastIndexOf(".") + 1);

            long id = Instant.now().toEpochMilli();

            NoteData noteData = new NoteData(id, title, content, DataCenter.SELECTED_TEXT, DataCenter.CURRENT_FILE_NAME, fileType);


            DataCenter.NOTE_LIST.add(noteData);
            DataCenter.TABLE_MODEL.addRow(noteData.toStringArray());


        });
        panel.add(btnAdd);
        return panel;
    }
}