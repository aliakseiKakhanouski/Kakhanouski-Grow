package main.java.com.epam.grow.thread.task3;

import java.io.File;
import java.util.concurrent.ForkJoinPool;

public class DirSize {

    private DirSize() {
    }

    public static FileProperties sizeOf(final File file) {
        ForkJoinPool pool = new ForkJoinPool();
        try {
            return pool.invoke(new SizeOfFileTask(file));
        } finally {
            pool.shutdown();
        }
    }
}
