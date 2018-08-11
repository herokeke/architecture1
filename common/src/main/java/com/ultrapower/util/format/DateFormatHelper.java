package com.ultrapower.util.format;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by User on 2018/8/10.
 */
public class DateFormatHelper {

    private DateFormatHelper(){}

    private final static String FORMAT_STR = "yyyy-MM-dd HH:mm:ss";

    public static String long2str(long time){
        Date d = new Date(time);
        DateFormat df = new SimpleDateFormat(FORMAT_STR);
        return df.format(d);
    }
}
