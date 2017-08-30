package com.example.leetcode;

/**
 * Created by mrz on 17/8/29.
 * 7. Reverse Integer
 * Reverse digits of an integer.
 * <p>
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * <p>
 * click to show spoilers.
 * <p>
 * Have you thought about this?
 * Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!
 * <p>
 * If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
 * <p>
 * Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?
 * <p>
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 * <p>
 * Note:
 * The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.
 */
public class ReverseInteger {
    public static void main(String args[]) {
        int x = 1534236469;
        int y = new Solution().reverse(x);
        System.out.println("x===" + y);
    }

    static class Solution {
        public int reverse(int x) {
            if (x>Integer.MAX_VALUE/2&&x<-Integer.MAX_VALUE/2){
                return 0;
            }
            boolean isNegative;
            if (x < 0) {
                isNegative = true;
                x = Math.abs(x);
            } else if (x > 0) {
                isNegative = false;
            }else{
                return 0;
            }
            int exponent = 0;
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                double v = x / Math.pow(10, i);
                if (v < 1 && v >= 0.1) {
                    exponent = i - 1;
                    break;
                }
            }
            int result = 0;
            for (int i = exponent; i > -1; i--) {
                double temp = x;
                for (int j = i; j > 0; j--) {
                    temp = temp % Math.pow(10, j);
                }
                result += temp * Math.pow(10, i);
                x = (int) (x - temp) / 10;
            }
            if (isNegative) {
                return -result;
            } else {
                return result;
            }

        }

        public int reverse1(int x){
            String num = Integer.toString(x);
            int length = num.length() - 1;
            int result = 0;
            StringBuffer sb = new StringBuffer();
            if(x < 0) {
                num = num.substring(1);
                length--;
                sb.append("-");
            }
            for (int i = length; i >= 0 ; i--) {
                sb.append(num.charAt(i));
            }
            try {
                result = Integer.valueOf(sb.toString());
            } catch (java.lang.NumberFormatException e) {
                result = 0;
            }
            return result;
        }
    }
}
