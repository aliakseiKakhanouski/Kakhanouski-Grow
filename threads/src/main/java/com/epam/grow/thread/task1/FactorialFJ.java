package main.java.com.epam.grow.thread.task1;

import java.math.BigInteger;
import java.util.concurrent.ForkJoinPool;

public class FactorialFJ {

    public static BigInteger factorialRecursiveTask(int fact) {
        FactorialRecursiveTask recurssiveTask = new FactorialRecursiveTask(1, fact);
        ForkJoinPool pool = new ForkJoinPool();
        return pool.invoke(recurssiveTask);
    }
}
