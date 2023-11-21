package com.rhl.plugin.notepad.data;

import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: 你的昵称是抢我的
 * @Date: 2023/11/21 21:50
 * @Description: 存放数据 上下文
 */
public class DataCentrer {

    /**
     * 选择的文本
     */
    public static String SELECTED_TEXT = null;
    /**
     * 当前的文件名称
     */
    public static String CURRENT_FILE_NAME = null;
    /**
     *  当前的文件类型
     */
    public static String CURRENT_FILE_TYPE = null;
    /**
     * 笔记列表集合
     */
    public static List<NoteData> NOTE_LIST = new LinkedList<>();

}
