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
     * 当前的文件类型
     */
    public static String CURRENT_FILE_TYPE = null;
    /**
     * 笔记列表集合
     */
    public static List<NoteData> NOTE_LIST = new LinkedList<>();

    /**
     * 根据主键进行删除
     * @param id
     * @return
     */
    public static boolean remove(Long id) {
        //判断当前中心里有没有数据
        if (NOTE_LIST.isEmpty()) {
            return Boolean.FALSE;
        }
        //根据ID查找当前元素
        NoteData target = findById(id);

        //没有找到直接返回 false
        if (target == null){
            return Boolean.FALSE;
        }

        // 移除
        return NOTE_LIST.remove(target);
    }

    /**
     * 根据ID进行查找
     *
     * @param id
     * @return
     */
    private static NoteData findById(Long id) {
        NoteData target = null;
        for (NoteData note : NOTE_LIST) {
            if (note.getId().equals(id)) {
                target = note;
                break;
            }
        }
        return target;
    }

}
