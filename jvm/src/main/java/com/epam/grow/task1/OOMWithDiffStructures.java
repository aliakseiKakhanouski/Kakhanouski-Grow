package com.epam.grow.task1;

import java.util.ArrayList;
import java.util.List;

public class OOMWithDiffStructures {
    // 1. java.lang.OutOfMemoryError: Java heap space. You can use different data structures. Don’t tune heap size.
    public static void main(String[] args) {
        outOfMemory();
    }

    private static void outOfMemory() {
        int arraySize = 20;
        List<int[]> list = new ArrayList<>();
        for (int i = 1; i < 20; i++) {
            list.add(new int[arraySize]);
            arraySize *= 10;
        }
    }
}
