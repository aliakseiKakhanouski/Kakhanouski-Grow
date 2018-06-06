package main.java.com.epam.grow.thread.task2;

import java.util.concurrent.RecursiveAction;

public class QuickSortAction extends RecursiveAction {

    private int[] data;
    private int left;
    private int right;

    public QuickSortAction(int[] data) {
        this.data = data;
        left = 0;
        right = data.length - 1;
    }

    public QuickSortAction(int[] data, int left, int right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    @Override
    protected void compute() {
        if (left < right) {
            int partition = partition();
            invokeAll(new QuickSortAction(data, left, partition), new QuickSortAction(data, partition + 1, right));
        }
    }

    private int partition() {
        int pivot = data[left];
        int i = left - 1;
        int j = right + 1;
        while (true) {
            do {
                i++;
            } while (data[i] < pivot);

            do {
                j--;
            } while (data[j] > pivot);
            if (i >= j) {
                return j;
            }
            swap(i, j);
        }
    }

    private void swap(int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
