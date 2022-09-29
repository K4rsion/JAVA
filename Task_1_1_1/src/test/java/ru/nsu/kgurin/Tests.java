package ru.nsu.kgurin;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

/**
 * tests for heapsort.
 */
public class Tests {
    @Test
    void simpleTest() {
        int[] a = {1, 2, 3};
        int[] b = {2, 1, 3};
        Heapsort.heapsort(b);
        assertArrayEquals(a, b);
    }

    @Test
    void simpleTestWithNegativeNumbers() {
        int[] a = {-1, 0, 46, 255};
        int[] b = {255, -1, 0, 46};
        Heapsort.heapsort(b);
        assertArrayEquals(a, b);
    }

    @Test
    void equalTest() {
        int[] a = {0};
        int[] b = {0};
        Heapsort.heapsort(b);
        assertArrayEquals(a, b);
    }

    @Test
    void emptyArraysTest() {
        int[] a = {};
        int[] b = {};
        Heapsort.heapsort(b);
        assertArrayEquals(a, b);
    }
}