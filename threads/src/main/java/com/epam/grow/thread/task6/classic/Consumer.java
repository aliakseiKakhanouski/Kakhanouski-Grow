package main.java.com.epam.grow.thread.task6.classic;

import java.util.ArrayList;
import java.util.List;

public class Consumer implements Runnable {

    private BlockingList<Integer> list = null;
    private List<Integer> values;
    private int limit;

    Consumer(BlockingList<Integer> list, int limit) {
        this.list = list;
        values = new ArrayList<>();
        this.limit = limit;
    }

    public void run() {
        try {
            while (limit > 0) {
                values.add(list.get());
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
