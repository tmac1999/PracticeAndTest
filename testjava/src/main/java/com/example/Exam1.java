package com.example;

import java.util.HashSet;

/**
 * Created by mrz on 17/4/19.
 */

public class Exam1 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int[] b = {4, 1, 2, 3};
        int[] c = {1, 1, 2, 2};
        int[] d = {1, 1};    //-1
        int[] e = {1};//	-1
        int[] f = {};
        int s = getSecondLargestNumInArray1(a);
        int s1 = getSecondLargestNumInArray1(b);
        int s2 = getSecondLargestNumInArray1(c);
        int s3 = getSecondLargestNumInArray1(d);
        int s4 = getSecondLargestNumInArray1(e);
        int s5 = getSecondLargestNumInArray1(f);
        System.out.println("======" + s);
        System.out.println("======" + s1);
        System.out.println("======" + s2);
        System.out.println("======" + s3);
        System.out.println("======" + s4);
        System.out.println("======" + s5);



    }

    private static int getSecondLargestNumInArray(int[] a) {
        //list--- from large to small
        //ArrayList<Integer> list = new ArrayList<>();

//        for (int i = 0; i < a.length; i++) {
//            if (list.length == 0) {
//                list[0] = a[0];
//                continue;
//            }
////            Integer integer = list.get(list.size() - 1);
////            if (integer > a[i]) {
////                //small mumber add in the end of the list
////                list.add(a[i]);
////            }
//
//            for (int j = 0; j < list.length; j++) {
//                Integer mum = list[j];
//                if (mum < a[i]) {
//                    //a[i] larger than the  num of the list,add a[i] to ahead of the mum
//                    list[j+1] = list[j];
//                    list[]
//                            j, a[i]);
//                } else if (mum > a[i]) {
//                    if (j == list.size() - 1) {
//                        //if till the end of the list,add a[i] to the end of the list
//                        list.add(a[i]);
//                    }
//
//                }
//            }
//
//
//        }


        HashSet<Integer> integers = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            integers.add(a[i]);
        }
        int[] list = new int[integers.size()];
        int m = 0;
        for (Integer integer : integers) {
            list[m] = integer;
            m++;
        }
        for (int i = 0; i < list.length; i++) {
            for (int j = i + 1; j < list.length; j++) {
                if (list[i] > list[j]) {
                    //from large to small


                } else if (list[i] < list[j]) {
                    int temp = list[j];
                    list[j] = list[i];
                    list[i] = temp;
                }
            }
        }
        if (list.length < 2) {
            return -1;
        }
        return list[1];
    }

    private static int getSecondLargestNumInArray1(int[] a) {
        // max num
        int max1 = -1;
        //second max num
        int max2 = -1;

        for (int i = 0; i < a.length; i++) {
            //if a[i] larger than max1 -- max1 = a[i] ,max2= max1
            //if a[i] larger than max2 but smaller or equal  max1   max2= a[i]
            if (max1 < a[i]) {
                int temp = max1;
                max1 = a[i];
                max2 = temp;
            }
            if (max2 < a[i] && max1 != a[i]) {
                //in this case all a[i] are less or equal max1.we should ignore the equal num
                max2 = a[i];
            }
        }


        return max2;
    }
}
