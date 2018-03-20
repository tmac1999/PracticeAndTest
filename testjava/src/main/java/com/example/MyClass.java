package com.example;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyClass {

    public static void main(String[] args) {
        //String text = "\"Sun\"";
//        String text = new String("sun");
//        System.out.println("===" + judgeContainsStr(text));
//        System.out.println(text);
//        String replace = text.replace("\"", "");
//        System.out.println(replace);
//        System.out.println(text);
//        change(text);
//        System.out.println(text);
       // int fileCount = getFileCount(new File("/Users/lianhua/Downloads/PracticeAndTest"));
       // System.out.println(":" + fileCount);
       // getFileCount(null);
        boolean aab = new Solution().isMatch("aab", "c*a*b");
        System.out.println(":" + aab);
        Singleton.INSTANCE.doSometing();
    }
    static int i = 0;
    public static int getFileCount(File f) {
        if (f == null || !f.exists()) return 0;

        for (File file : f.listFiles()) {
            if (file.isDirectory()){
                getFileCount(file);
            }else{
                if (file.getName().endsWith(".java")){
                    i++;
                    System.out.println(":" + file);
                }

            }



        }
        return i;
    }

    public static String change(String text) {
        text = "a";
        return text;
    }

    public static boolean judgeContainsStr(String cardNum) {
        String regex = ".*[a-zA-Z]+.*";
        Matcher m = Pattern.compile(regex).matcher(cardNum);
        return m.matches();
    }

    static class Solution {
        public boolean isMatch(String text, String pattern) {
            if (pattern.isEmpty()) return text.isEmpty();
            boolean first_match = (!text.isEmpty() &&
                    (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

            if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
                return (isMatch(text, pattern.substring(2)) ||
                        (first_match && isMatch(text.substring(1), pattern)));
            } else {
                return first_match && isMatch(text.substring(1), pattern.substring(1));
            }
        }
    }

    enum Singleton{
        INSTANCE;
        public void doSometing(){

        }
    }
}
