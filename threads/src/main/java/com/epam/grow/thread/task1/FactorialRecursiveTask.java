package main.java.com.epam.grow.thread.task1;

import java.math.BigInteger;
import java.util.concurrent.RecursiveTask;

public class FactorialRecursiveTask extends RecursiveTask<BigInteger> {

    private static final int THRESHOLD = 10;
    private int start;
    private int end;

    public FactorialRecursiveTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected BigInteger compute() {
        if ((end - start) <= THRESHOLD) {
            return computeDirectly();
        } else {
            int mid = start + ((end - start) / 2);
            FactorialRecursiveTask left = new FactorialRecursiveTask(start, mid);
            left.fork();
            mid++;
            FactorialRecursiveTask right = new FactorialRecursiveTask(mid, end);
            return right.compute().multiply(left.join());
        }
    }

    private BigInteger computeDirectly() {
        BigInteger result = BigInteger.ONE;
        for (int i = start; i <= end; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
