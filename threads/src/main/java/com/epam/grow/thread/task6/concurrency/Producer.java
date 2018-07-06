package main.java.com.epam.grow.thread.task6.concurrency;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private BlockingQueue<Integer> queue = null;
    private Random random;
    private int limit;

    public Producer(BlockingQueue<Integer> queue, int limit) {
        this.queue = queue;
        random = new Random();
        this.limit = limit;
    }

    public void run() {
        try {
            while (limit > 0) {
                queue.put(random.nextInt());
                limit--;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
