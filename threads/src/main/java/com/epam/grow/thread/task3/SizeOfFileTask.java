package main.java.com.epam.grow.thread.task3;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class SizeOfFileTask extends RecursiveTask<FileProperties> {

    private final File file;
    private long folders;
    private long files;
    private long size;

    public SizeOfFileTask(final File file) {
        this.file = file;
        folders = 0;
        files = 0;
        size = 0;
    }

    @Override
    protected FileProperties compute() {
        if (file.isFile()) {
            return new FileProperties(file.length(), 1, 0);
        }

        List<SizeOfFileTask> tasks = new ArrayList<>();
        File[] children = file.listFiles();
        if (children != null) {
            for (File child : children) {
                SizeOfFileTask task = new SizeOfFileTask(child);
                task.fork();
                tasks.add(task);
                if (child.isDirectory()) {
                    folders++;
                }
            }
        }
        return joinAndSummarize(tasks);
    }

    private FileProperties joinAndSummarize(List<SizeOfFileTask> tasks) {
        FileProperties fileProperties;
        for (SizeOfFileTask task : tasks) {
            fileProperties = task.join();
            size += fileProperties.getSize();
            files += fileProperties.getFiles();
            folders += fileProperties.getFolders();
        }
        return new FileProperties(size, files, folders);
    }
}
