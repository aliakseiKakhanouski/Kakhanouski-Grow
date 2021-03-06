package main.java.com.epam.grow.thread.task1;

import java.math.BigInteger;

public class FactorialClassic {

    public static BigInteger factorialClassic(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n; ++i) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
