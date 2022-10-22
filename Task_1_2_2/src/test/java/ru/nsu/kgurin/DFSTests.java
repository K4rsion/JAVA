package ru.nsu.kgurin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.List;


/**
 * Tests for my DFS algorithm.
 */
public class DFSTests {

    @Test
    public void hasNextTest() {
        Node<Integer> root = new Node<>(1);
        Node<Integer> rootA = new Node<>(2);
        root.add(rootA);
        DepthFirstSearchIterator<Integer> dfs = new DepthFirstSearchIterator<>(root);

        Assertions.assertTrue(dfs.hasNext());
    }

    @Test
    public void nextTest() {
        Node<Integer> root = new Node<>(1);
        Node<Integer> rootA = new Node<>(2);
        root.add(rootA);
        DepthFirstSearchIterator<Integer> dfs = new DepthFirstSearchIterator<>(root);
        dfs.next();

        Assertions.assertEquals(dfs.next().getValue(), rootA.getValue());
    }

    @Test
    public void modCountTest() {
        Node<Integer> root = new Node<>(1);
        Node<Integer> rootA = new Node<>(2);
        root.add(rootA);
        DepthFirstSearchIterator<Integer> dfs = new DepthFirstSearchIterator<>(root);
        dfs.next();
        Node<Integer> problemNode = new Node<>(3);
        rootA.add(problemNode);

        ConcurrentModificationException thrown = Assertions.assertThrows(ConcurrentModificationException.class, () -> {
            dfs.next();
            ;
        }, "Changing structure while iterating");

        Assertions.assertEquals("Changing structure while iterating", thrown.getMessage());
    }

    @Test
    public void dfsAlgorithmTest() {
        //expected
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 3, 33, 333, 2, 22));

        //actual
        Node<Integer> root = new Node<>(1);
        Node<Integer> rootA = new Node<>(2);
        root.add(rootA);
        Node<Integer> rootAA = new Node<>(22);
        rootA.add(rootAA);
        Node<Integer> rootB = new Node<>(3);
        root.add(rootB);
        Node<Integer> rootBB = new Node<>(33);
        rootB.add(rootBB);
        Node<Integer> rootBBB = new Node<>(333);
        rootBB.add(rootBBB);

        DepthFirstSearchIterator<Integer> dfs = new DepthFirstSearchIterator<>(root);
        List<Integer> actual = new ArrayList<>();

        while (dfs.hasNext()) {
            actual.add(dfs.next().getValue());
        }

        //asserts
        Assertions.assertEquals(expected, actual);
    }
}

