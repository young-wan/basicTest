package designPattern.DateTest;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Vector;

/**
 * @Author: Young
 * @Description: 时间类测试
 * @Date: Created at 9/22 0022 15:48
 */
public class DateTest {

    public static void main(String[] args) {
        String str1 = new String("1");
        str1.intern();
        String str2 = "1";
        System.out.println(str1 == str2);

        String str3 = new String("2") + new String("2");
        str3.intern();
        String str4 = "2" + "2";
        System.out.println(str3 == str4);

        System.out.println("s: " + System.identityHashCode(str1));
        System.out.println("s2: " + System.identityHashCode(str2));
        System.out.println("s3: " + System.identityHashCode(str3));
        System.out.println("s4: " + System.identityHashCode(str4));


    }

    private static int intTest(int a) {
        a = 3;
        return a;
    }

    public static void formatDateTest() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        Date d = new Date();
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        System.out.println(sdf.format(d));
        System.out.println(ts);
        System.out.println(sdf.format(ts.getTime()));
//        System.out.println("1" + d);
//        System.out.println("2" + d.toLocaleString());
//        System.out.println("3" + d.toString());
//        System.out.println("4" + d.getTime());
//        System.out.println(new Date());
//        System.out.println(new Date().toLocaleString());

    }


    public void calendarDemo() {
        Calendar calendar = new Calendar() {
            @Override
            protected void computeTime() {

            }

            @Override
            protected void computeFields() {

            }

            @Override
            public void add(int field, int amount) {

            }

            @Override
            public void roll(int field, boolean up) {

            }

            @Override
            public int getMinimum(int field) {
                return 0;
            }

            @Override
            public int getMaximum(int field) {
                return 0;
            }

            @Override
            public int getGreatestMinimum(int field) {
                return 0;
            }

            @Override
            public int getLeastMaximum(int field) {
                return 0;
            }
        };
    }

    public static void formatDemo() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        System.out.println("timestamp : " + timestamp);
        System.out.println("date : " + date);
        System.out.println("calendar : " + calendar.getTime());
    }

    public static void CalendarTest() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2017, 9, 22, 15, 51, 30);
        System.out.println(timeConvert(calendar.getTime()));
        // getClass().getName() 获取类型名称
        System.out.println(calendar.getClass().getName());
        System.out.println(calendar.getTime().getClass().getName());
    }

    public static void DateDemo() {
        Date date = new Date();
        date.setTime(System.currentTimeMillis());
        System.out.println(timeConvert(date));
    }

    public static String timeConvert(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        String str = sdf.format(date);
        try {
            Date d = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static int compInt() {
        int[] ints = {-44, -2, 1, 2, 10, 30, 3, 4, 5};
        int max = 0;
        for (int i = 0; i < ints.length; i++) {
            max = (max >= ints[i] ? max : ints[i]);
        }
        return max;
    }

    public static String compStr() {
        String[] strings = {"d", "a", "d", "e", "E"};
        String max = "";
        for (int i = 0; i < strings.length; i++) {
            max = (max.compareTo(strings[i]) == 1 ? max : strings[i]);
        }
        return max;
    }

    public static String time() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String str = sdf.format(date);

        System.out.println(date.getHours());
        return null;
    }

    public static void timeSet() {
        Date signDate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(signDate);
        cal.set(Calendar.HOUR_OF_DAY, 21);
        cal.set(Calendar.MINUTE, 15);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        signDate = cal.getTime();
        System.out.println(signDate);

        System.out.println(signDate.getTime());
        System.out.println(cal.getTime().getTime());
    }

    public static void signTime() {
        //  判定签到码时间
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date nowDate = new Date();
        String nowTimeStr = sdf.format(nowDate);
        int[] st = string2int("12:30".split(":"));
        int[] se = string2int("14:45".split(":"));
        int[] sn = string2int(nowTimeStr.split(":"));

        Calendar now = Calendar.getInstance();
        Calendar start = Calendar.getInstance();
        start.set(Calendar.HOUR_OF_DAY, st[0]);
        start.set(Calendar.MINUTE, st[1]);
        start.set(Calendar.SECOND, 0);
        start.set(Calendar.MILLISECOND, 0);
        Calendar end = Calendar.getInstance();
        end.set(Calendar.HOUR_OF_DAY, se[0]);
        end.set(Calendar.MINUTE, se[1]);
        end.set(Calendar.SECOND, 0);
        end.set(Calendar.MILLISECOND, 0);

        Long interval = new Long(4 * 60 * 1000);

        Long difference = now.getTimeInMillis() - start.getTimeInMillis();

        Long num = difference / interval;
        Long left = start.getTimeInMillis() + interval * num;
        //  增加判定是否时间超过
        if (left > end.getTimeInMillis()) {

            System.out.println("ddd");
            return;
        }
        Long right = start.getTimeInMillis() + interval * (num + 1);
        //  判定截止日期是否超出
        if (right > end.getTimeInMillis()) {
            right = end.getTimeInMillis();
        }

        Date leftDate = new Date(left);
        Date rightDate = new Date(right);
        System.out.println("开始签到: " + sdf.format(leftDate));
        System.out.println("结束签到: " + sdf.format(rightDate));
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(left);
    }

    private static int[] string2int(String[] strings) {
        int[] ints = new int[2];
        for (int i = 0; i < strings.length; i++) {
            ints[i] = Integer.valueOf(strings[i]);
        }
        return ints;
    }

}
