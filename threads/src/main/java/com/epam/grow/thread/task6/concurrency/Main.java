package main.java.com.epam.grow.thread.task6.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

    private static final int CAPACITY = 50;
    private static final int LIMIT = 100000;
    private static final int PRODUCER_PRIORITY = Thread.MAX_PRIORITY;
    private static final int CONSUMER_PRIORITY = 5;

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(CAPACITY);
        long start = System.currentTimeMillis();
        Thread producer = new Thread(new Producer(queue, LIMIT));
        Thread consumer = new Thread(new Consumer(queue, LIMIT));
        producer.setPriority(PRODUCER_PRIORITY);
        consumer.setPriority(CONSUMER_PRIORITY);
        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
        System.out.println((System.currentTimeMillis() - start));
    }
}
