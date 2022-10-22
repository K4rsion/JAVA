package ru.nsu.kgurin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Tests for my tree implementation.
 */
class TreeTests {

    //Atomic Tests
    @Test
    public void addTest() {
        //expected
        Node<Integer> expected = new Node<>(1);
        Node<Integer> expectedA = new Node<>(2);
        expected.add(expectedA);

        //actual
        Node<Integer> actual = new Node<>(1);
        Node<Integer> actualA = new Node<>(2);
        actual.add(actualA);

        //asserts
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void removeTest() {
        //expected
        Node<Integer> expected = new Node<>(1);

        //actual
        Node<Integer> actual = new Node<>(1);
        Node<Integer> actualA = new Node<>(2);
        actual.add(actualA);
        actual.remove(actualA);

        //asserts
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getRootTest() {
        Node<Integer> root = new Node<>(1);
        Node<Integer> rootA = new Node<>(2);
        root.add(rootA);
        Node<Integer> rootAA = new Node<>(22);
        rootA.add(rootAA);

        Assertions.assertEquals(root, rootAA.getRoot());
    }

    @Test
    public void getModCountTest() {
        //expected
        Node<Integer> expected = new Node<>(1);
        Node<Integer> expectedA = new Node<>(2);
        expected.add(expectedA);
        expected.remove(expectedA);

        //actual
        Node<Integer> actual = new Node<>(1);
        Node<Integer> actualA = new Node<>(2);
        actual.add(actualA);
        Node<Integer> actualAA = new Node<>(22);
        actualA.add(actualAA);

        //asserts
        Assertions.assertEquals(expected.getModCount(), actual.getModCount());
    }

    @Test
    public void getChildrenTest() {
        //expected
        Node<Integer> expected = new Node<>(1);
        Node<Integer> expectedA = new Node<>(2);
        expected.add(expectedA);
        Node<Integer> expectedB = new Node<>(3);
        expected.add(expectedB);
        List<Integer> expectedArray = new ArrayList<>();
        for (var vertex : expected.getChildren()) {
            expectedArray.add(vertex.getValue());
        }

        //actual
        List<Integer> actual = new ArrayList<>(Arrays.asList(2, 3));

        //asserts
        Assertions.assertEquals(expectedArray, actual);
    }

    @Test
    public void getValueTest() {
        Node<Integer> root = new Node<>(1);

        Assertions.assertEquals(root.getValue(), 1);
    }

    @Test
    public void iteratorTest() {
        Node<Integer> root = new Node<>(1);
        Node<Integer> rootA = new Node<>(2);
        root.add(rootA);
        Node<Integer> rootB = new Node<>(3);
        root.add(rootB);
        Node<Integer> rootAA = new Node<>(4);
        rootA.add(rootAA);
        Node<Integer> rootAB = new Node<>(5);
        rootA.add(rootAB);
        Node<Integer> rootBA = new Node<>(6);
        rootB.add(rootBA);

        //actual
        List<Integer> actualListDfs = new ArrayList<>();
        for (Node<Integer> i : root) {
            actualListDfs.add(i.getValue());
        }

        root.setTypeOfFirstSearch(2);
        List<Integer> actualListBfs = new ArrayList<>();
        for (Node<Integer> i : root) {
            actualListBfs.add(i.getValue());
        }

        //expected
        List<Integer> expectedListDfs = new ArrayList<>(Arrays.asList(1, 3, 6, 2, 5, 4));
        List<Integer> expectedListBfs = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        //asserts
        Assertions.assertEquals(expectedListDfs, actualListDfs);
        Assertions.assertEquals(expectedListBfs, actualListBfs);
    }

    @Test
    public void hashCodeTest() {
        Node<Integer> a = new Node<>(1);
        Node<Integer> a1 = new Node<>(2);
        a.add(a1);

        Node<Integer> b = new Node<>(1);
        Node<Integer> b1 = new Node<>(2);
        b.add(b1);

        Node<Integer> c = new Node<>(10);
        Node<Integer> c1 = new Node<>(20);
        c.add(c1);

        Assertions.assertEquals(a.hashCode(), b.hashCode());
        Assertions.assertNotEquals(a.hashCode(), c.hashCode());
    }

    //Common Tests
    @Test
    public void rootNodeTest() {
        //expected
        Node<Integer> expected = new Node<>(1);

        //actual
        Node<Integer> actual = new Node<>(1);

        //asserts
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void typeOfNodeTest() {
        //expected
        Node<String> expected = new Node<>("first");

        //actual
        Node<String> actual = new Node<>("first");

        //asserts
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void structureTest() {
        //expected
        Node<Integer> expected = new Node<>(1);
        Node<Integer> expectedA = new Node<>(2);
        expected.add(expectedA);
        Node<Integer> expectedB = new Node<>(3);
        expected.add(expectedB);
        Node<Integer> expectedAA = new Node<>(4);
        expectedA.add(expectedAA);

        //actual
        Node<Integer> actual = new Node<>(1);
        Node<Integer> actualA = new Node<>(2);
        actual.add(actualA);
        Node<Integer> actualB = new Node<>(3);
        actual.add(actualB);
        Node<Integer> actualC = new Node<>(4);
        actual.add(actualC);
        Node<Integer> actualCC = new Node<>(5);
        actualC.add(actualCC);
        actual.remove(actualC);
        Node<Integer> actualAA = new Node<>(4);
        actualA.add(actualAA);

        //asserts
        Assertions.assertEquals(expected, actual);
    }
}