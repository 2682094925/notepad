package com.rhl.plugin.notepad.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import com.rhl.plugin.notepad.data.DataCenter;
import com.rhl.plugin.notepad.dialog.AddNoteDialog;

/**
 * @Auther: 你的昵称是抢我的
 * @Date: 2023/11/21 21:06
 * @Description:
 */
public class PopupAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        //获取当前编辑器对象
        Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
        //获取选择的数据模型
        SelectionModel selectionModel = editor.getSelectionModel();
        //获取当前选择的文本
        String selectedText = selectionModel.getSelectedText();

        //选择的内容
        DataCenter.SELECTED_TEXT = selectedText;
        //文件名称
        DataCenter.CURRENT_FILE_NAME = e.getRequiredData(CommonDataKeys.PSI_FILE).getViewProvider().getVirtualFile().getName();
        DataCenter.CURRENT_FILE_TYPE =DataCenter.CURRENT_FILE_NAME.substring(DataCenter.CURRENT_FILE_NAME.lastIndexOf(".")+1);


        //触发对话框
        AddNoteDialog dialog = new AddNoteDialog();
        dialog.show();
    }
}
