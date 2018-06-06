package main.java.com.epam.grow.thread.task6.classic;

import java.util.Random;

public class Producer implements Runnable {

    private BlockingList<Integer> list = null;
    private Random random;
    private int limit;

    Producer(BlockingList<Integer> list, int limit) {
        this.list = list;
        random = new Random();
        this.limit = limit;
    }

    public void run() {
        try {
            while (limit > 0) {
                list.add(random.nextInt());
                limit--;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
