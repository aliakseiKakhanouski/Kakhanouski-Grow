package main.java.com.epam.grow.thread.task3;

public class FileProperties {

    private long size;
    private long files;
    private long folders;

    public FileProperties() {

    }

    public FileProperties(long size, long files, long folders) {
        this.size = size;
        this.folders = folders;
        this.files = files;
    }

    public void setFiles(long files) {
        this.files = files;
    }

    public void setFolders(long folders) {
        this.folders = folders;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getFiles() {
        return files;
    }

    public long getFolders() {
        return folders;
    }

    public long getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Size = " + size + "\nFiles = " + files + "\nFolders = " + folders;
    }
}
