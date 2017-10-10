package com.example.leetcode;


/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Examples:
 * <p>
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * <p>
 * Given "bbbbb", the answer is "b", with the length of 1.
 * <p>
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LeetCode3 {


    public static void main(String[] args) {
        String str1 = "abcabcbb";
        String str2 = "bbbbb";
        String str3 = "pwwkew";
        //int length = Solution.lengthOfLongestSubstring(str1);
        //int length2 = Solution.lengthOfLongestSubstring(str2);
        int length3 = Solution.lengthOfLongestSubstring(str3);
        //System.out.println("=================" + length);
        //System.out.println("=================" + length2);
        System.out.println("=================" + length3);
    }

    static class Solution {
        public static int lengthOfLongestSubstring(String s) {
            char[] chars = s.toCharArray();
            int Length = 0;
           // ArrayList charList = new ArrayList<>();
         //   Collections.addAll(charList, chars);
            for (int i = 0; i < chars.length; i++) {
                //把第i+1个与第i个比较,如果相同,则length=1,如果不同,则i+2与i进行比较,如果相同,length=2,如果不同,则..
                for (int j = i + 1; j < chars.length - i - 1; j++) {
                    int n = i;//标记当前no repeating characters 序列的第一位位置
                    for (int m = i; m < j; m++) {
                        if (chars[m] == chars[j]) {
                            i = j-1;
                            break;
                        }

                    }
                    if (j - n > Length)
                        Length = j - n;

                }


            }
            return Length;
        }
    }
}
