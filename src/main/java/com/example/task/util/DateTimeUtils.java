package com.example.task.util;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author: Lin Zhongyu
 * @projectName: task
 * @packageName: com.example.task.util
 * @description:
 * @createTime: 2020-05-24 14:53
 */
public class DateTimeUtils {

    public static Date strToDate(String strDate, String pattern) {
        if (null == strDate) {
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        ParsePosition pos = new ParsePosition(0);
        Date strToDate = formatter.parse(strDate, pos);
        return strToDate;
    }

    public static List<String> getEveryDay(String dateStart, String dateEnd) {
        List<String> dateList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date datePre = sdf.parse(dateStart);
            Date datePost = sdf.parse(dateEnd);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(datePre);

            dateList.add(dateStart);
            while (calendar.getTime().before(datePost)) { //倒序时间,顺序after改before其他相应的改动。
                calendar.add(Calendar.DAY_OF_MONTH, 1);
                dateList.add(sdf.format(calendar.getTime()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateList;
    }
}
