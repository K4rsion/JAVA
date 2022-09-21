package ru.nsu.kgruin;

public class HeapSort {

        public static void main(String[] args) {
            int[] a = {1, 2, 3};
            int[] b = {2, 1, 3};
            HeapSort.heapsort(b);

        }

        public static void heapsort(int[] arr) {
            int n = arr.length;
            for (int i = n / 2 - 1; i >= 0; i--)
                heapify(arr, i, n);
            for (int i = n - 1; i > 0; i--) {
                int temp = arr[i];
                arr[i] = arr[0];
                arr[0] = temp;

                heapify(arr, 0, i);
            }
        }

        private static void heapify(int[] arr, int i, int n) {
            int l = 2 * i + 1;
            int r = 2 * i + 2;
            int largest = i;
            if (l < n && arr[l] > arr[largest])
                largest = l;
            if (r < n && arr[r] > arr[largest])
                largest = r;
            if (i != largest) {
                int temp = arr[i];
                arr[i] = arr[largest];
                arr[largest] = temp;

                heapify(arr, largest, n);
            }
        }
}
