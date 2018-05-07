package com.example;

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

        int i =3000 - 3000 % 7;
        Print.pln(i);

    }
    static int i;
    public static void test(){
        String c = "hello worldddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd";
        while (true){
            String b = c+i;
            i++;
            System.out.println(b);
        }

    }
}
