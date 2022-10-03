package ru.nsu.kgurin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.nsu.kgurin.Stack;

/**
 * Tests for a stack realization.
 */
public class StackTest {

    @Test
    public void exampleTest(){
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

        Assertions.assertTrue(expected.stackAssertion(actual));
    }

    @Test
    public void emptyStackTest(){
        Stack<Integer> expected = new Stack<>(0);

        Stack<Integer> actual = new Stack<>(0);

        Assertions.assertTrue(expected.stackAssertion(actual));
    }

    @Test
    public void boundExceededTest(){
        Stack<Integer> expected = new Stack<>(0);
        expected.pop();
        expected.push(2);

        Stack<Integer> actual = new Stack<>(0);
        actual.push(2);
        actual.push(7);
        actual.push(8);
        actual.popStack(2);

        Assertions.assertTrue(expected.stackAssertion(actual));
    }

    @Test
    public void equalPopAndPopStackTest(){
        Stack<Integer> expected = new Stack<>(0);

        Stack<Integer> actual = new Stack<>(2);
        actual.push(2);
        actual.push(7);
        actual.popStack(1);
        actual.pop();

        Assertions.assertTrue(expected.stackAssertion(actual));
    }

    @Test
    public void reallocTest(){
        Stack<Integer> expected = new Stack<>(0);
        expected.push(1);
        expected.push(2);
        expected.push(3);

        Stack<Integer> actual = new Stack<>(0);
        actual.push(1);
        Stack<Integer> s1 = new Stack<>(0);
        s1.push(2);
        s1.push(3);
        actual.pushStack(s1);

        Assertions.assertTrue(expected.stackAssertion(actual));
    }
}
