package com.example;

/**
 * Created by mrz on 18/2/1.
 */

public class TestBreak {
    public static void main(String[] args) {
//        int a = 2;
//        int b = 3;
//        out:if (a > 3) {
//            System.out.println("1111111");
//        } else {
//            System.out.println("1111111");
//            if (b > 2) break out;
//            System.out.println("2222222");
//            System.out.println("2222222");
//        }
//        System.out.println("2222222");
//        System.out.println("2222222");
//        System.out.println("2222222");


        float v = Float.valueOf(0.3f) * 100;
        // String replace = String.valueOf(v).replace(".0", "");
        String s = trimZero(String.valueOf(v));
        Print.p(s);
    }

    private static String trimZero(String s) {
        if (s.indexOf(".") > 0) {
            // 去掉多余的0
            // s = s.replaceAll("\\.+?$", "");
            // 如最后一位是.则去掉
            // s = s.replaceAll("[.]$", "");
            s = s.split("\\.")[0];
        }
        return s;
    }

}
