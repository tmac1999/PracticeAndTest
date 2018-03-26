package com.example;

/**
 * Created by mrz on 18/3/22.
 */

public class TestString {
    public static void main(String args[]) {
        final String a = "hello";
        final String b = " world";
        String c = "hello world";
        String d = a+b;
        String e = a+b;
        Print.pln(c==d);
        Print.pln(d==e);
        Print.pln(c.equals(d));

    }
}
