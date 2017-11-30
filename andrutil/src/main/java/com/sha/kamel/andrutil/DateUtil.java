package com.sha.kamel.andrutil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by Sha on 10/26/17.
 */

public final class DateUtil{
    public static final String DATE_FORMAT_Y_M_D = "yyyy-MM-dd";
    public static final String DATE_FORMAT_D_M_Y = "dd-MM-yyyy";
    public static final String DATE_FORMAT = "yyyy-MM-dd hh:mm:ss";
    public static final String DATE_FORMAT_REVERSED = "hh:mm:ss yyyy-MM-dd";

    public static String hourOFDayString(String dateString){
        return String.valueOf(hourOfDay(dateString));
    }

    public static Calendar calendar(String dateString){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(toDate(dateString));
        long offset = timeZoneOffset();
        calendar.setTimeInMillis(calendar.getTimeInMillis() + offset);
        return calendar;
    }

    public static int hourOfDay(String dateString){
        return calendar(dateString).get(Calendar.HOUR_OF_DAY);
    }

    public static long timeInMillis(String dateString){
        return calendar(dateString).getTimeInMillis();
    }

    public static Date toDate(String dateString){
        return toDate(dateString, DATE_FORMAT);
    }

    public static Date toDate(String dateString, String format){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);
            return sdf.parse(dateString);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String toDateTime(String dateString){
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(Long.parseLong(dateString));
            return new SimpleDateFormat(DATE_FORMAT_REVERSED, Locale.US).format(cal.getTime());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static int timeZoneOffset(){
        TimeZone timezone = TimeZone.getDefault();
        return timezone.getOffset(Calendar.ZONE_OFFSET);
    }

    public static String toDateDmy(String dateString){
        try {
            // To get the required format, we must get the time from calendar
            Calendar cal = calendar(dateString);
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_D_M_Y, Locale.US);
            sdf.setTimeZone(Calendar.getInstance().getTimeZone());
            return sdf.format(cal.getTime());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String hourAs12H(int hourOfDay) {
        int  hour = hourOfDay;

        String timeSet = "AM";

        if (hour > 12) {
            hour -= 12;
            timeSet = "PM";
        }
        else if (hour == 0) {
            hour = 12;
            timeSet = "AM";
        }
        else if (hour == 12)
            timeSet = "PM";

        return new StringBuilder()
                .append(hour)
                .append(" ")
                .append(timeSet)
                .append(" ")
                .toString();
    }

    public static String currentUtcTime(){
        DateFormat df = DateFormat.getTimeInstance();
        df.setTimeZone(utcTimeZone());
        String utc = df.format(new Date());
        return utc;
    }

    public static long epochTime(){
        return System.currentTimeMillis();
    }

    public static TimeZone utcTimeZone(){
        return TimeZone.getTimeZone("UTC");
    }
}
