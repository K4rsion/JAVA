package ru.nsu.kgurin;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests that checks the correctness of SequentialSolve class.
 */
public class SequentialTests {
    @Test
    public void primeTest1() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        boolean act = SequentialSolve.sequentialSolve(list);
        boolean exp = false;
        Assertions.assertEquals(exp, act);
    }

    @Test
    public void primeTest2() {
        List<Integer> list = Arrays.asList(999917, 999931, 999953, 999959, 999961, 999979, 999983);
        boolean act = SequentialSolve.sequentialSolve(list);
        boolean exp = false;
        Assertions.assertEquals(exp, act);
    }

    @Test
    public void primeTest3() {
        List<Integer> list = Arrays.asList(945031, 945037, 945059, 945089, 945103,
                945143, 945151, 945179, 945209, 945211);
        boolean act = SequentialSolve.sequentialSolve(list);
        boolean exp = false;
        Assertions.assertEquals(exp, act);
    }

    @Test
    public void compositeTest1() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        boolean act = SequentialSolve.sequentialSolve(list);
        boolean exp = true;
        Assertions.assertEquals(exp, act);
    }

    @Test
    public void compositeTest2() {
        List<Integer> list = Arrays.asList(94530, 945030, 945050, 945210, 945210);
        boolean act = SequentialSolve.sequentialSolve(list);
        boolean exp = true;
        Assertions.assertEquals(exp, act);
    }

    @Test
    public void compositeTest3() {
        List<Integer> list = Arrays.asList(945032, 945037, 945059, 945089, 945103,
                945143, 945151, 945179, 945209, 945211);
        boolean act = SequentialSolve.sequentialSolve(list);
        boolean exp = true;
        Assertions.assertEquals(exp, act);
    }
}
