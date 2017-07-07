package com.example;

/**
 * Created by mrz on 17/4/19.
 */

public class Exam3 {
    public static void main(String[] args){
        char[] answer = getStr(new char[]{'a', 'b', 'c'}, 0, 4);	//null
        char[] answer1 = getStr(new char[]{'a', 'b', 'c'}, 0, 3);//	{'a', 'b', 'c'}
        char[] answer2 = getStr(new char[]{'a', 'b', 'c'}, 0, 2);//	{'a', 'b'}
        char[] answer3 = getStr(new char[]{'a', 'b', 'c'}, 0, 1);//	{'a'}
        char[] answer4 = getStr(new char[]{'a', 'b', 'c'}, 1, 3);//	null
        char[] answer5 = getStr(new char[]{'a', 'b', 'c'}, 1, 2);//	{'b', 'c'}
        char[] answer6 = getStr(new char[]{'a', 'b', 'c'}, 1, 1);//	{'b'}
        char[] answer7 = getStr(new char[]{'a', 'b', 'c'}, 2, 2);//	null
        char[] answer8 = getStr(new char[]{'a', 'b', 'c'}, 2, 1);//	{'c'}
        char[] answer9 = getStr(new char[]{'a', 'b', 'c'}, 3, 1);//	null
        char[] answer10 = getStr(new char[]{'a', 'b', 'c'}, 1, 0);//	{}
        char[] answer11 = getStr(new char[]{'a', 'b', 'c'}, -1, 2	);//null
        char[] answer12 = getStr(new char[] {'a', 'b', 'c'}, -1, -2);//	null
        char[] answer13 = getStr(new char[] {}, 0, 1	);//null
        System.out.println("====" + formart(answer));
        System.out.println("====" +formart(answer1));
        System.out.println("====" +formart(answer2));
        System.out.println("====" +formart(answer3));
        System.out.println("====" +formart(answer4));
        System.out.println("====" +formart(answer5));
        System.out.println("====" +formart(answer6));
        System.out.println("====" +formart(answer7));
        System.out.println("====" +formart(answer8));
        System.out.println("====" +formart(answer9));
        System.out.println("====" +formart(answer10));
        System.out.println("====" +formart(answer11));
        System.out.println("====" +formart(answer12));
        System.out.println("====" +formart(answer13));
    }

    private static String formart(char[] answer) {
        if (answer==null)
            return null;
        StringBuilder a= new StringBuilder();
        for (int i=0;i<answer.length;i++){
            a.append(answer[i]+",");
        }
        return a.toString();
    }

    private static char[] getStr(char[] strings,int start,int length){

        if (start<0||strings.length-start<length){
            return null;
        }
        char[] splits = new char[length];
        int j =0;
        for (int i =start;i<start+length;i++){
            splits[j] = strings[i];
            j++;
        }
        return splits;
    }
}
