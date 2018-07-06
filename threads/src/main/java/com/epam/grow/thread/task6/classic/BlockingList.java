package main.java.com.epam.grow.thread.task6.classic;

import java.util.ArrayDeque;
import java.util.Queue;

public class BlockingList<T> {

    private final int capacity;
    private final Queue<T> list;
    private final Object lock = new Object();


    public BlockingList(int capacity) {
        this.capacity = capacity;
        this.list = new ArrayDeque<>(capacity);
    }

    public T get() throws InterruptedException {
        synchronized (lock) {
            while (list.isEmpty()) {
                lock.wait();
            }
            T e = list.poll();
            lock.notify();
            return e;
        }
    }

    public void add(T e) throws InterruptedException {
        synchronized (lock) {
            while (list.size() == capacity) {
                lock.wait();
            }
            list.add(e);
            lock.notify();
        }
    }
}
