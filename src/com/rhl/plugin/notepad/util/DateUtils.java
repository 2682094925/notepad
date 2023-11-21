package com.rhl.plugin.notepad.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: 你的昵称是抢我的
 * @Date: 2023/11/21 21:48
 * @Description:
 */
public class DateUtils {
    private static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static String format(Date date) {
        return format(date, DEFAULT_PATTERN);
    }

    public static String format(Date date, String pattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(date);
    }
}
