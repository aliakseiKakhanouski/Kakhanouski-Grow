package main.java.com.epam.grow.thread.task6.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private BlockingQueue<Integer> queue = null;
    private List<Integer> values;
    private int limit;

    public Consumer(BlockingQueue<Integer> queue, int limit) {
        this.queue = queue;
        this.limit = limit;
        values = new ArrayList<>();
    }

    public void run() {
        try {
            while (limit > 0) {
                values.add(queue.take());
                calcAverage();
                limit--;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private double calcAverage() {
        return values.stream()
                .mapToDouble(a -> a)
                .average()
                .orElse(0.0);
    }
}
