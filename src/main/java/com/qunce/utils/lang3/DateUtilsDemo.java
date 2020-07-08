/*
 * Copyright (c) 1995, 2100, QunCe and/or its affiliates. All rights reserved.
 * QUNCE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */

package com.qunce.utils.lang3;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @ClassName DateUtilsDemo
 * @Description TODO
 * @Author soul goodman
 * @email m18967896507_1@163.com
 * @Date 2020/7/2 9:58
 * @ModifyDate 2020/7/2 9:58
 * @Version 1.0
 */
public class DateUtilsDemo {

    public static void main(String[] args) throws ParseException {
        Date date = DateUtils.parseDate("2020-06-11 14:50:59", Locale.CHINA, "yyyy-MM-dd HH:mm:ss");
        System.out.println(Instant.ofEpochMilli(date.getTime()));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        TimeZone gmt = TimeZone.getTimeZone("GMT");//关键所在
        simpleDateFormat.setTimeZone(gmt);
        simpleDateFormat.setLenient(true);
        System.out.println(Instant.ofEpochMilli(simpleDateFormat.parse("2020-06-11 14:50:59").getTime()));
    }

}
