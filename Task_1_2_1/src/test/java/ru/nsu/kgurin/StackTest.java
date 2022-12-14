package ru.nsu.kgurin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests for a stack realization.
 */
public class StackTest {

    @Test
    public void exampleTest() {
        Stack<Integer> expected = new Stack<>(1);
        expected.push(2);

        Stack<Integer> actual = new Stack<>(1);
        actual.push(2);
        actual.push(7);
        Stack<Integer> s1 = new Stack<>(2);
        s1.push(4);
        s1.push(8);
        actual.pushStack(s1);
        actual.pop();
        actual.popStack(2);
        actual.count();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void emptyStackTest() {
        Stack<Integer> expected = new Stack<>(1);

        Stack<Integer> actual = new Stack<>(1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void boundExceededTest() {
        Stack<Integer> expected = new Stack<>(1);
        expected.pop();
        expected.push(2);

        Stack<Integer> actual = new Stack<>(1);
        actual.push(2);
        actual.push(7);
        actual.push(8);
        actual.popStack(2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void equalPopAndPopStackTest() {
        Stack<Integer> expected = new Stack<>(1);
        expected.pop();

        Stack<Integer> actual = new Stack<>(2);
        actual.push(2);
        actual.push(7);
        actual.popStack(1);
        actual.pop();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void reallocTest() {
        Stack<Integer> expected = new Stack<>(1);
        expected.push(1);
        expected.push(2);
        expected.push(3);

        Stack<Integer> actual = new Stack<>(1);
        actual.push(1);
        Stack<Integer> s1 = new Stack<>(1);
        s1.push(2);
        s1.push(3);
        actual.pushStack(s1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void stringTest() {
        Stack<String> expected = new Stack<>(4);
        expected.push("My");
        expected.push("Name");
        expected.push("Is");
        expected.push("Kirill!");

        Stack<String> actual = new Stack<>(2);
        actual.push("My");
        actual.push("Name");
        Stack<String> s1 = new Stack<>(1);
        s1.push("Is");
        s1.push("Andrew!");
        s1.pop();
        actual.pushStack(s1);
        actual.push("Kirill!");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void pushTest() {
        Stack<Integer> expected = new Stack<>(1);
        expected.push(1);
        expected.push(2);

        Stack<Integer> actual = new Stack<>(1);
        actual.push(1);
        actual.push(2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void popTest() {
        Stack<Integer> expected = new Stack<>(1);
        expected.push(1);
        expected.push(2);

        Stack<Integer> actual = new Stack<>(1);
        actual.push(1);
        actual.push(3);
        actual.pop();
        actual.push(2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void pushStackTest() {
        Stack<Integer> expected = new Stack<>(1);
        expected.push(1);
        expected.push(2);
        expected.push(3);

        Stack<Integer> actual = new Stack<>(1);
        actual.push(1);
        Stack<Integer> s1 = new Stack<>(1);
        s1.push(2);
        s1.push(3);
        actual.pushStack(s1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void popStackTest() {
        Stack<Integer> expected = new Stack<>(1);
        expected.push(1);

        Stack<Integer> actual = new Stack<>(1);
        actual.push(1);
        actual.push(2);
        actual.push(3);
        actual.popStack(2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void countTest() {
        Stack<Integer> expected = new Stack<>(1);
        expected.push(1);
        expected.push(2);

        Stack<Integer> actual = new Stack<>(1);
        actual.push(1);
        actual.push(2);

        Assertions.assertEquals(expected.count(), actual.count());
    }
}
