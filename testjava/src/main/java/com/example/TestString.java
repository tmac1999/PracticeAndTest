package com.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by mrz on 18/3/22.
 */

public class TestString {

    public static void main(String args[]) {
        final String a = "hello";
        final String b = " world";
//
//        String c = "hello world";
//        String[] ddd={"das"};
//        String d = a+b;
//        String e = a+b;
//        Print.pln(c==d);
//        Print.pln(d==e);
//        Print.pln(c.equals(d));
//        while (true){
////            try {
////                Thread.sleep(1000);
////                Print.pln("======"+i);
////                i++;
////            } catch (InterruptedException e1) {
////                e1.printStackTrace();
////            }
//            test();
//        }

//        int i = 3000 - 3000 % 7;
//        Print.pln(i);


//        Print.pln(getCurrentTime());
//        Print.p(getLastMonth(getCurrentTime()));
//        Print.p(getPreMonth(getCurrentTime()));

        double aaa = 86;
        String number = String.valueOf(aaa);
        String split = number.split("/.")[0];
        String intNumber = number.substring(0,number.indexOf("."));
        Print.pln(split);
        Print.pln(intNumber);

        String number1 = "123.456";
        System.out.println(number1.split(".")[0]);
    }

    static int i;

    public static void test() {
        String c = "hello worldddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd";
        while (true) {
            String b = c + i;
            i++;
            System.out.println(b);
        }

    }

    /**
     * 获取系统当前日期时间 yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static String getCurrentTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        String date = format.format(new Date());
        return date;
    }

    // 使用当前月份,得到上一个月的月份:月份的格式是:yyyy-MM
    public static String getLaterMonth(String currentDate) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(currentDate + "-" + "01");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, -1);
        String lastDate;
        if (c.get(Calendar.MONTH) + 1 < 10) {
            lastDate = c.get(Calendar.YEAR) + "-"
                    + "0" + String.valueOf(c.get(Calendar.MONTH) + 1);
        } else {
            lastDate = c.get(Calendar.YEAR) + "-"
                    + (c.get(Calendar.MONTH) + 1);
        }


        return lastDate;

    }


    /**
     *      * 获取任意时间的下一个月
     *      * 描述:<描述函数实现的功能>.
     *      * @param repeatDate
     *      * @return
     *     
     */

    public static String getPreMonth(String repeatDate) {
        String lastMonth = "";
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM");
        int year = Integer.parseInt(repeatDate.substring(0, 4));
        String monthsString = repeatDate.substring(5, 7);
        int month;
        if ("0".equals(monthsString.substring(0, 1))) {
            month = Integer.parseInt(monthsString.substring(1, 2));
        } else {
            month = Integer.parseInt(monthsString.substring(0, 2));
        }
        cal.set(year, month, Calendar.DATE);
        lastMonth = dft.format(cal.getTime());
        return lastMonth;
    }

    /**
     *      * 获取任意时间的上一个月
     *      * 描述:<描述函数实现的功能>.
     *      * @param repeatDate
     *      * @return
     *     
     */


    public static String getLastMonth(String repeatDate) {
        String lastMonth = "";
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM");
        int year = Integer.parseInt(repeatDate.substring(0, 4));
        String monthsString = repeatDate.substring(5, 7);
        int month;
        if ("0".equals(monthsString.substring(0, 1))) {
            month = Integer.parseInt(monthsString.substring(1, 2));
        } else {
            month = Integer.parseInt(monthsString.substring(0, 2));
        }
        cal.set(year, month - 2, Calendar.DATE);
        lastMonth = dft.format(cal.getTime());
        return lastMonth;
    }
}
