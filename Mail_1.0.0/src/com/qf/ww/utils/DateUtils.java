package com.qf.ww.utils;

import java.sql.Timestamp;
import java.util.Date;

public class DateUtils {

    public static Timestamp d2t(Date d) {
        if (null == d)
            return null;
        return new Timestamp(d.getTime());
    }
    public static Date t2d(Timestamp t) {
        if (null == t)
            return null;
        return new Date(t.getTime());
    }

/*    public static void main(String[] args) {
        Date date = new Date();
        long time = date.getTime();
        System.out.println(time);
    }*/
}
