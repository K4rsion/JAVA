package ru.nsu.kgurin;

/**
 * heap-based sorting.
 */
public class Heapsort {
    public static void main(String[] args) {
        System.out.print("Heapsort!");
    }

    /**
     * main heapsort function.
     *
     * @param arr input array that will be sorted
     */
    public static void heapsort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            heapify(arr, 0, i);
        }
    }

    /**
     * heapify makes that for each subtree the root is bigger than its sons.
     *
     * @param arr input array (binary tree)
     * @param i root of subtree
     * @param n conditional size of binary tree
     */
    public static void heapify(int[] arr, int i, int n) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int largest = i;
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }
        if (i != largest) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, largest, n);
        }
    }
}
