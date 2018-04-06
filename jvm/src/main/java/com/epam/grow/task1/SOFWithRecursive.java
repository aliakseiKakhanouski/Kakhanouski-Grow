package com.epam.grow.task1;

public class SOFWithRecursive {
    // 4. java.lang.StackOverflowError. Use recursive methods. Don’t tune stack size.
    public static void main(String[] args) {
        recursion();
    }

    private static void recursion() {
        recursion();
    }
}
