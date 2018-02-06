package com.example;

/**
 * Created by mrz on 18/2/1.
 */

public class TestBreak {
    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        out:if (a > 3) {
            System.out.println("1111111");
        } else {
            System.out.println("1111111");
            if (b > 2) break out;
            System.out.println("2222222");
            System.out.println("2222222");
        }
        System.out.println("2222222");
        System.out.println("2222222");
        System.out.println("2222222");
    }
}
