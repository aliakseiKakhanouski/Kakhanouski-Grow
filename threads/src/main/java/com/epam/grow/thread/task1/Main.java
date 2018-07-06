package main.java.com.epam.grow.thread.task1;


public class Main {

//    #                              1   2   3   4
//    End Time for RecursiveTask :  65, 20, 17, 16
//    End Time for classic:         65, 34, 47, 51
//    End Time for with cache:      75, 14, 11, 11

    private static final int FACTORIAL = 10000;
    private static final int COUNT = 4;

    public static void main(String[] args) {
        long start;
        for (int i = 0; i < COUNT; i++) {
            start = System.currentTimeMillis();
            System.out.println(FactorialFJ.factorialRecursiveTask(FACTORIAL));
            System.out.println("End Time for RecursiveTask : " + (System.currentTimeMillis() - start));

            start = System.currentTimeMillis();
            System.out.println(FactorialClassic.factorialClassic(FACTORIAL));
            System.out.println("End Time for classic: " + (System.currentTimeMillis() - start));

            start = System.currentTimeMillis();
            System.out.println(FactorialClassicWithCache.factorialWithCache(FACTORIAL));
            System.out.println("End Time for with cache: " + (System.currentTimeMillis() - start));
        }
    }
}
