package com.epam.grow.overload;

public class OrderOfCalling {
    /*
        Answer:
        1 int
        3 long
        4 Integer
        6 Object
        2 int...
    */
    public static String glide(int i) {
        return "1";
    }

    public static String glide(int... i) {
        return "2";
    }

    public static String glide(long i) {
        return "3";
    }

    public static String glide(Integer i) {
        return "4";
    }

    public static String glide(Long i) {
        return "5";
    }

    public static String glide(Object i) {
        return "6";
    }

    public static String glide(Integer[] i) {
        return "7";
    }

    public static void main(String[] args) {
        System.out.println(glide(1));
    }
}
