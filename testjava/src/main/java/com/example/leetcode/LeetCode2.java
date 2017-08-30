package com.example.leetcode;

/**
 * Created by mrz on 17/7/17.
 */

import java.util.HashMap;

/**
 * 1. Two Sum
 * <p>
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class LeetCode2 {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        Solution solution = new Solution();
        int[] ints = solution.twoSum(nums, 26);

        for (int a:ints){
            System.out.println("==="+a);
        }
    }

    public static class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, int[]> integerIntegerHashMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int a = nums[i];
                for (int j = i + 1; j < nums.length; j++) {
                    int b = nums[j];
                    int sum = a + b;
                    int[] array = {i,j};
                    integerIntegerHashMap.put(sum,array);
                }
            }

            return integerIntegerHashMap.get(target);
        }




        public int[] twoSum1(int[] nums, int target) {

            //HashMap<Integer, int[]> integerIntegerHashMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int a = nums[i];
                for (int j = i + 1; j < nums.length; j++) {
                    int b = nums[j];
                    int sum = a + b;

                    if(sum == target){
                        return new int[]{i,j};
                    }
                    //integerIntegerHashMap.put(sum,array);
                }
            }

            return null;
        }
    }



}
