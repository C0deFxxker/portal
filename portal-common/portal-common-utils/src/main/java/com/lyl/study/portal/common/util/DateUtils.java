package com.lyl.study.portal.common.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 日期工具类
 *
 * @author 黎毅麟
 */
public class DateUtils {
    public static final long ONE_HOUR_OF_MILISECOND = 60000L;
    public static final long ONE_DAY_OF_MILISECOND = 86400000L;
    // 以周一作为一周开始
    public static final int FIRST_DAY_OF_WEEK = Calendar.MONDAY;

    public static Date getZeroClockOfDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.setFirstDayOfWeek(FIRST_DAY_OF_WEEK);

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Date getLastMillisOfDate(Date date) {
        Date zeroClockOfDate = getZeroClockOfDate(date);
        return new Date(zeroClockOfDate.getTime() + ONE_DAY_OF_MILISECOND - 1);
    }

    public static Date getMondayOfThatWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(FIRST_DAY_OF_WEEK);

        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        int day = calendar.get(Calendar.DAY_OF_WEEK);

        // 获取这周一时间
        calendar.add(Calendar.DATE, calendar.getFirstDayOfWeek() - day);

        return calendar.getTime();
    }

    public static Date getFirstDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(FIRST_DAY_OF_WEEK);

        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        return calendar.getTime();
    }

    public static Date getFirstDayOfYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(FIRST_DAY_OF_WEEK);

        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.DAY_OF_YEAR, 1);

        return calendar.getTime();
    }

    public static boolean isSameWeek(Date date, Date anotherDate) {
        Date mondayOfDate = getMondayOfThatWeek(date);
        Date mondayOfAnotherDate = getMondayOfThatWeek(anotherDate);
        return mondayOfDate.equals(mondayOfAnotherDate);
    }

    public static boolean isSameDay(Date date, Date anotherDate) {
        Date zeroClockOfDate = getZeroClockOfDate(date);
        Date zeroClockOfAnotherDate = getZeroClockOfDate(anotherDate);
        return zeroClockOfDate.equals(zeroClockOfAnotherDate);
    }

    public static boolean isSameMonth(Date date, Date anotherDate) {
        Date firstDayOfMonthFromDate = getFirstDayOfMonth(date);
        Date firstDayOfMonthFromAnotherDate = getFirstDayOfMonth(anotherDate);
        return firstDayOfMonthFromDate.equals(firstDayOfMonthFromAnotherDate);
    }

    public static boolean isSameYear(Date date, Date anotherDate) {
        Date firstDayOfYearFromDate = getFirstDayOfYear(date);
        Date firstDayOfYearFromAnotherDate = getFirstDayOfYear(anotherDate);
        return firstDayOfYearFromDate.equals(firstDayOfYearFromAnotherDate);
    }

    public static Date getLastWeekDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, -7);
        Date date = calendar.getTime();
        return date;
    }

    public static Date getDayHour(Date day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(day);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Date getDayZeroOclock(Date day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(day);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static String formatDateToString(Date date, DateFormat dateFormat){
        return dateFormat.format(date);
    }

    public static Date getFirstDayOfLastYear(Date day){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(day);
        calendar.add(Calendar.YEAR, -1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.DAY_OF_YEAR, 1);
        return calendar.getTime();
    }

    public static Date getDayOfLastYear(Date day){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(day);
        calendar.add(Calendar.YEAR, -1);
        return calendar.getTime();
    }

    public static Date getDayOfLastMonth(Date day){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(day);
        calendar.add(Calendar.MONTH, -1);
        return calendar.getTime();
    }

    public static Date getFirstDayOfLastMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }
}
