package ru.nsu.kgurin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests for my BFS algorithm.
 */
public class BreadthFirstSearchIteratorTests {
    @Test
    public void hasNextTest() {
        Node<Integer> root = new Node<>(1);
        Node<Integer> rootA = new Node<>(2);
        root.add(rootA);
        BreadthFirstSearchIterator<Integer> bfs = new BreadthFirstSearchIterator<>(root);

        Assertions.assertTrue(bfs.hasNext());
    }

    @Test
    public void nextTest() {
        Node<Integer> root = new Node<>(1);
        Node<Integer> rootA = new Node<>(2);
        root.add(rootA);
        BreadthFirstSearchIterator<Integer> bfs = new BreadthFirstSearchIterator<>(root);
        bfs.next();

        Assertions.assertEquals(bfs.next().getValue(), rootA.getValue());
    }

    @Test
    public void modCountTest() {
        Node<Integer> root = new Node<>(1);
        Node<Integer> rootA = new Node<>(2);
        root.add(rootA);
        BreadthFirstSearchIterator<Integer> bfs = new BreadthFirstSearchIterator<>(root);
        bfs.next();
        Node<Integer> problemNode = new Node<>(3);
        rootA.add(problemNode);

        ConcurrentModificationException thrown =
                Assertions.assertThrows(ConcurrentModificationException.class, () -> {
                    bfs.next();
                }, "Changing structure while iterating");

        Assertions.assertEquals("Changing structure while iterating", thrown.getMessage());
    }

    @Test
    public void bfsAlgorithmTest() {
        //actual
        Node<Integer> root = new Node<>(1);
        Node<Integer> rootA = new Node<>(2);
        root.add(rootA);
        Node<Integer> rootAa = new Node<>(22);
        rootA.add(rootAa);
        Node<Integer> rootB = new Node<>(3);
        root.add(rootB);
        Node<Integer> rootBb = new Node<>(33);
        rootB.add(rootBb);
        Node<Integer> rootBbb = new Node<>(333);
        rootBb.add(rootBbb);

        //expected
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3, 22, 33, 333));

        BreadthFirstSearchIterator<Integer> bfs = new BreadthFirstSearchIterator<>(root);
        List<Integer> actual = new ArrayList<>();

        while (bfs.hasNext()) {
            actual.add(bfs.next().getValue());
        }

        //asserts
        Assertions.assertEquals(expected, actual);
    }
}
