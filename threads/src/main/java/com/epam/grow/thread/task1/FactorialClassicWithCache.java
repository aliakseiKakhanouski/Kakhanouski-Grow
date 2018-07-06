package main.java.com.epam.grow.thread.task1;

import java.math.BigInteger;
import java.util.HashMap;

public class FactorialClassicWithCache {

    private static HashMap<Integer, BigInteger> cache = new HashMap<>();

    public static BigInteger factorialWithCache(int n) {
        BigInteger result;
        if (n == 0) {
            return BigInteger.ONE;
        }
        if (null != (result = cache.get(n))) {
            return result;
        }
        result = BigInteger.valueOf(n).multiply(factorialWithCache(n - 1));
        cache.put(n, result);
        return result;
    }
}
