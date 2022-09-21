package ru.nsu.kgurin;

import org.junit.jupiter.api.Test;
import ru.nsu.kgruin.HeapSort;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Tests {
    @Test
    void test_1() {
        int[] a = {1, 2, 3};
        int[] b = {2, 1, 3};
        HeapSort.heapsort(b);
        assertArrayEquals(a,b);
    }

    @Test
    void test_2() {
        int[] a = {-1, 0, 46, 255};
        int[] b = {255, -1, 0, 46};
        HeapSort.heapsort(b);
        assertArrayEquals(a,b);
    }

    @Test
    void test_3() {
        int[] a = {0};
        int[] b = {0};
        HeapSort.heapsort(b);
        assertArrayEquals(a,b);
    }

    @Test
    void test_4() {
        int[] a = {};
        int[] b = {};
        HeapSort.heapsort(b);
        assertArrayEquals(a,b);
    }

    @Test
    void test_5(){
        int[] a = {1,2,3};
        int[] b = {1,2,3};
        HeapSort.heapsort(b);
        assertArrayEquals(a,b);
    }
}