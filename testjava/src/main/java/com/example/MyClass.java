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
        int fileCount = getFileCount(new File("/Users/lianhua/Downloads/PracticeAndTest"));
        System.out.println(":" + fileCount);
       // getFileCount(null);
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
}
