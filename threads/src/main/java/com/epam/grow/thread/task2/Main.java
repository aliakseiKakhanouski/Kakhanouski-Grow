package main.java.com.epam.grow.thread.task2;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class Main {

    private static final int SIZE =  10000;
    public static void main(String[] args) {
        long start;
        int[] data1 = new int[SIZE];
        Random random = new Random();
        for (int i = 0; i < data1.length; i++) {
            data1[i] = random.nextInt(SIZE + 1);
        }
        QuickSortAction quickSort = new QuickSortAction(data1);
        start = System.currentTimeMillis();
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(quickSort);

        pool.shutdown();
        System.out.println("End Time: " + (System.currentTimeMillis() - start));
        System.out.println(Arrays.toString(data1));
    }
}
