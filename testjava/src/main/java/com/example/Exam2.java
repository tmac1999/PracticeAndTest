package com.example;

/**
 * Created by mrz on 17/4/19.
 */

public class Exam2 {
    public static void main(String[] args) {
        int[] a = {1};//1
        int[] b = {1, 2};//	-1
        int[] c = {1, 2, 3};//	2
        int[] d = {1, 2, 3, 4};//	-2
        int[] e = {3, 3, 4, 4};//	-2
        int[] f = {3, 2, 3, 4};//0
        int[] g = {4, 1, 2, 3};//-2
        int[] h = {1, 1};//	2
        int[] i = {};//0
        int answer = get(a);
        int answer1 = get(b);
        int answer2 = get(c);
        int answer3 = get(d);
        int answer4 = get(e);
        int answer5 = get(f);
        int answer6 = get(g);
        int answer7 = get(h);
        int answer8 = get(i);

        System.out.println("====" + answer);
        System.out.println("====" + answer1);
        System.out.println("====" + answer2);
        System.out.println("====" + answer3);
        System.out.println("====" + answer4);
        System.out.println("====" + answer5);
        System.out.println("====" + answer6);
        System.out.println("====" + answer7);
        System.out.println("====" + answer8);
    }

    private static int get(int[] a) {
        int evenSum = 0;
        int oddSum = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 1) {
                oddSum += a[i];
            } else {
                evenSum += a[i];
            }
        }


        return oddSum - evenSum;
    }
}
