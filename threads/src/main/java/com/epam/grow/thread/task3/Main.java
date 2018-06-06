package main.java.com.epam.grow.thread.task3;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        FileProperties properties = DirSize.sizeOf(new File("C:\\Program Files (x86)"));
        System.out.println(properties.toString());
    }
}
