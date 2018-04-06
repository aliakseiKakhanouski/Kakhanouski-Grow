package com.epam.grow.task1;

public class OOMWithBigObj {
    // 2. java.lang.OutOfMemoryError.Java heap space. Create big objects continuously and make them stay in memory.
    // Do not use arrays or collections.
    public static void main(String[] args) {
        outOfMemory();
    }

    private static void outOfMemory() {
        StringBuilder builder = new StringBuilder("builder");
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            builder.append(builder.toString());
        }
    }
}
