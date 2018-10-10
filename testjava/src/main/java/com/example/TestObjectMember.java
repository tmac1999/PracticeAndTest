package com.example;

/**
 * Created by mrz on 18/9/14.
 */
class Father {
    public static String name;
}

class Child extends Father {

    //    static {
//        name = "sad";
//    }
    public static String name ;
    public static String BASE = "base";
    public static String URL = BASE+"asdad.com";

    public void initName(String s) {
        name = s;
    }


}

public class TestObjectMember {
    public static void main(String[] args) {
        new Child().initName("sad");
//        Print.pln(Father.name);
//        Print.pln(Child.name);
        Print.pln(Child.URL);
        Child.BASE = "aaa";

        Print.pln(Child.URL);
        Child.class.getAnnotations();

    }
}


