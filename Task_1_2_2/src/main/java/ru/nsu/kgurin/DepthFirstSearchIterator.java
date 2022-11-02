package ru.nsu.kgurin;

import java.util.ConcurrentModificationException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 * DFS algorithm for traversing a tree in breadth.
 */
public class DepthFirstSearchIterator<T> implements Iterator<Node<T>> {
    Deque<Node<T>> stack = new ArrayDeque<>();
    private int modCount;

    /**
     * Initialization of BFS Iterator.
     *
     * @param vertex vertex from BFS is executed
     */
    public DepthFirstSearchIterator(Node<T> vertex) {
        stack.push(vertex);
        modCount = vertex.getModCount();
    }

    /**
     * Check if the next node exists.
     *
     * @return true if there is next vertex, false otherwise
     */
    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * Switch to the next node of the tree.
     *
     * @return the current node
     */
    @Override
    public Node<T> next() {
        Node<T> next = stack.pop();
        if (this.modCount != next.getModCount()) {
            throw new ConcurrentModificationException("Changing structure while iterating");
        }
        for (var vertex : next.getChildren()) {
            stack.push(vertex);
        }
        return next;
    }
}
