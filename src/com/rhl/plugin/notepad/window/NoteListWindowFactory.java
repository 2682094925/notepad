package com.rhl.plugin.notepad.window;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

/**
 * @Auther: 你的昵称是抢我的
 * @Date: 2023/11/21 22:58
 * @Description:
 */
public class NoteListWindowFactory  implements ToolWindowFactory {

    private static  ToolWindow toolWindow = null;

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        //创建出NoteListWindow对象
        NoteListWindow noteListWindow = new NoteListWindow(project, toolWindow);
        //获取内容工厂的实例
        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
        //获取用于toolWindow显示的内容
        Content content = contentFactory.createContent(noteListWindow.getContent(), "", false);
        //给toolWindow设置内容
        toolWindow.getContentManager().addContent(content);
        NoteListWindowFactory.toolWindow = toolWindow;
    }

    /**
     * 打开
     */
    public static void show(){
        if (toolWindow != null){
            toolWindow.show(null);
        }
    }

    /**
     * 隐藏
     */
    public static void hide(){
        if (toolWindow != null){
            toolWindow.hide(null);
        }
    }

}
