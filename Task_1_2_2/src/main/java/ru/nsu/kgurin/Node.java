package ru.nsu.kgurin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * Node is a fundamental component of the tree.
 * Tree is formed from a set of interconnected nodes.
 */
class Node<T> implements Iterable<Node<T>> {
    private Node<T> parent;
    private List<Node<T>> children;
    private T value;
    private int typeOfFirstSearch;
    private int modCount;

    /**
     * Initialization of node.
     *
     * @param val value which node contains in it
     */
    public Node(T val) {
        this.children = new ArrayList<Node<T>>();
        this.value = val;
        this.parent = null;
        this.modCount = 0;
        this.typeOfFirstSearch = 1;
    }

    /**
     * Add node in tree. New node is put in after a parent node.
     *
     * @param childNode node which will be added
     */
    public void add(Node<T> childNode) {
        childNode.parent = this;
        this.children.add(childNode);
        getRoot().modCount++;
    }

    /**
     * Remove a current node from tree.
     *
     * @param childNode node which will be removed
     */
    public void remove(Node<T> childNode) {
        getRoot().modCount++;
        Node<T> tmp = childNode.parent;
        childNode.parent = null;
        childNode.children.clear();
        tmp.children.remove(childNode);
    }

    /**
     * Get root of a tree.
     *
     * @return the root of a tree
     */
    public Node<T> getRoot() {
        Node<T> vertex = this;
        while (vertex.parent != null) {
            vertex = vertex.parent;
        }
        return vertex;
    }

    /**
     * Get the number of modifications with a tree.
     *
     * @return the number of modifications with a tree
     */
    public int getModCount() {
        Node<T> root = getRoot();
        return root.modCount;
    }

    /**
     * Get the list of all children(nodes) of current parent node.
     *
     * @return the list of nodes
     */
    public List<Node<T>> getChildren() {
        return this.children;
    }

    /**
     * Get the data which stores in current node.
     *
     * @return the value of current node
     */
    public T getValue() {
        return this.value;
    }

    /**
     * Choose the type of iterating(BFS or DFS) throughout a tree.
     *
     * @param newType the identifier of type of search
     */
    public void setTypeOfFirstSearch(int newType) {
        this.typeOfFirstSearch = newType;
    }

    /**
     * Custom iterator for tree with help of BFS, DFS algorithms.
     *
     * @return the current type of algorithm(BFS, DFS)
     */
    @Override
    public Iterator<Node<T>> iterator() {
        if (typeOfFirstSearch == 1) {
            return new DepthFirstSearchIterator<>(this);
        }
        return new BreadthFirstSearchIterator<>(this);
    }

    /**
     * Custom tree check equality function.
     *
     * @return true if trees are equal and false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Node<?> root = (Node<?>) o;

        return Objects.equals(value, root.value)
                && Objects.equals(children, root.children);
    }

    /**
     * Calculate the hash of current tree.
     *
     * @return the calculated hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(value, children);
    }

}