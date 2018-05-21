package designPattern.DateTest;


import org.apache.poi.ss.formula.functions.T;
import org.omg.CORBA.Current;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: Young
 * @Description: 时间类测试
 * @Date: Created at 9/22 0022 15:48
 */
public class DateTest {

    public static void main(String[] args) {
        formatDateTest();
    }

    public static void formatDateTest(){
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


    public void calendarDemo(){
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

    public static void formatDemo(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        System.out.println("timestamp : " + timestamp);
        System.out.println("date : " + date);
        System.out.println("calendar : " + calendar.getTime());
    }

    public static void CalendarTest(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(2017, 9, 22, 15, 51, 30);
        System.out.println(timeConvert(calendar.getTime()));
        // getClass().getName() 获取类型名称
        System.out.println(calendar.getClass().getName());
        System.out.println(calendar.getTime().getClass().getName());
    }

    public static void DateDemo(){
        Date date = new Date();
        date.setTime(System.currentTimeMillis());
        System.out.println(timeConvert(date));
    }

    public static String timeConvert(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/hh E HH:mm:ss");
        String str = sdf.format(date);
        return str;
    }

}
