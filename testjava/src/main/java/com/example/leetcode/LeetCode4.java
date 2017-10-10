package com.example.leetcode;

/**
 * Created by mrz on 17/10/10.
 */

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class LeetCode4 {
    public static void main(String[] args) {
        int a = 123321;
        int b = 1234321;
        int c = 12345321;
        boolean palindrome = Solution.isPalindrome(c);
        System.out.println("======="+palindrome);
    }

    static class Solution {
        public static boolean isPalindrome(int x) {
            String s = String.valueOf(x);
            char[] chars = s.toCharArray();
            boolean result = true;
            for (int i = 0; i < chars.length / 2; i++) {
                if (chars[i] != chars[chars.length - 1-i]) {
                    result = false;
                    break;
                }
            }
            return result;
        }
    }
}
