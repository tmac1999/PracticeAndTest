package com.example.interview;

import java.util.ArrayList;

/**
 * Created by mrz on 18/3/8.
 */

public class QuickSort {
    public static void main(String[] args) {
         int a[] = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};
       // int a[] = {49, 38, 65, 97, 76, 13};
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : a) {
            list.add(i);
        }
        QuickSort(list, 0, list.size()-1);
        System.out.print(list);
    }

    //从小到大

    /**
     * @param list to be sorted
     * @param f first index
     * @param l last index
     */
    public static void QuickSort(ArrayList<Integer> list, int f, int l) {
        if (list == null || list.size() == 1) {
            return;
        }
        if (f >= l) {
            //分治之后的结果只有一个数字了
            return;
        }
        int move = 0;//移动的次数
        for (int i = f + 1; i <= l; i++) {
            if (list.get(f) > list.get(i)) {
                //比首位小，则放到首位之前的位置，否则不变
                Integer pre = list.get(i);
                list.add(f, pre);
                list.remove(i + 1);
                move++;
            }
        }
//        if (move == 0 && f >= (l - 1)) {
//            //分治之后的结果只有一个数字了,且到了数组的结尾
//            return;
//        }
        QuickSort(list, f, f + move-1);
        QuickSort(list, f+move+1 , l);


//        for (int i = 1; i < array.length; i++) {
//            if (array[0] > array[i]) {
//                //比首位小，则交换位置，否则不变
//                int temp = array[0];
//            }
//        }


    }


    private void quickSort(int[] arrays)
    {
        subQuickSort(arrays, 0, arrays.length - 1);
    }

    private void subQuickSort(int[] arrays, int start, int end)
    {
        if (start >= end)
        {
            return;
        }
        int middleIndex = subQuickSortCore(arrays, start, end);
        subQuickSort(arrays, start, middleIndex - 1);
        subQuickSort(arrays, middleIndex + 1, end);
    }

    private int subQuickSortCore(int[] arrays, int start, int end)
    {
        int middleValue = arrays[start];
        while (start < end)
        {
            while (arrays[end] >= middleValue && start < end)
            {
                end--;
            }
            arrays[start] = arrays[end];
            while (arrays[start] <= middleValue && start < end)
            {
                start++;
            }
            arrays[end] = arrays[start];
        }
        arrays[start] = middleValue;
        return start;
    }
}
