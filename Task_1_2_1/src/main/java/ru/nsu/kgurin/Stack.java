package ru.nsu.kgurin;

import java.util.Arrays;

/**
 * A stack is linear data structure,
 * elements are stacked on top of each other.
 * It works according to the principle - last in, first out (LIFO).
 */
public class Stack<T> {
    private T[] arr;
    private int size;
    private int capacity;

    /**
     * Initial stack constructor.
     *
     * @param capacity capacity of stack
     */
    public Stack(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.arr = (T[]) new Object[capacity];
    }

    /**
     * "realloc" method enhance the size of stack.
     */
    private void realloc() {
        capacity *= 2;
        arr = Arrays.copyOf(arr, capacity);
    }

    /**
     * "push" method puts element to the end of the stack.
     *
     * @param elem new element to be inserted in the stack
     */
    public void push(T elem) {
        if (size == capacity) {
            realloc();
        }
        arr[size++] = elem;
    }

    /**
     * "pushStack" method puts new stack to the end of the actual stack.
     *
     * @param stack new stack to be appended to the actual stack
     */
    public void pushStack(Stack<T> stack) {
        for (int i = 0; i < stack.size; i++) {
            push(stack.arr[i]);
        }
    }

    /**
     * "pop" method deletes the last element of the stack and returns it.
     * If stack is empty, method returns "null".
     *
     * @return popped element
     */
    public T pop() {
        if (size != 0) {
            T remElem = arr[--size];
            arr[size] = null;
            return remElem;
        } else {
            return null;
        }
    }

    /**
     * "popStack" method returns the last N elements of the stack and removes them.
     *
     * @param num N elements to be returned and removed
     * @return last N elements of the stack
     */
    public Stack<T> popStack(int num) {
        Stack<T> remStack = new Stack<T>(num);
        remStack.size = num;
        for (int i = num - 1; i >= 0; i--) {
            remStack.arr[i] = pop();
        }
        return remStack;
    }

    /**
     * "count" method returns the size of stack.
     *
     * @return size of stack
     */
    public int count() {
        return size;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Stack<?> that = (Stack<?>) obj;

        if (that.size != ((Stack<?>) obj).size) {
            return false;
        }

        for (int i = 0; i < that.size; i++) {
            if (that.arr[i] != ((Stack<?>) obj).arr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return 31 * (Arrays.hashCode(arr));
    }
}
