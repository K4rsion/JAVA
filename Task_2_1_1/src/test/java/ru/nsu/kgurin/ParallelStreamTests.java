package ru.nsu.kgurin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Tests that checks the correctness of ParallelStreamSolve class.
 */
public class ParallelStreamTests {
    @Test
    public void PrimeTest1() throws InterruptedException {
        List<Integer> list = Arrays.asList(1, 2, 3);
        ParallelStreamSolve test = new ParallelStreamSolve();
        boolean act = test.parallelStreamSolve(list);
        boolean exp = false;
        Assertions.assertEquals(exp, act);
    }

    @Test
    public void PrimeTest2() throws InterruptedException {
        List<Integer> list = Arrays.asList(999917, 999931, 999953, 999959, 999961, 999979, 999983);
        ParallelStreamSolve test = new ParallelStreamSolve();
        boolean act = test.parallelStreamSolve(list);
        boolean exp = false;
        Assertions.assertEquals(exp, act);
    }

    @Test
    public void PrimeTest3() throws InterruptedException {
        List<Integer> list = Arrays.asList(945031, 945037, 945059, 945089, 945103, 945143, 945151, 945179, 945209, 945211);
        ParallelStreamSolve test = new ParallelStreamSolve();
        boolean act = test.parallelStreamSolve(list);
        boolean exp = false;
        Assertions.assertEquals(exp, act);
    }

    @Test
    public void CompositeTest1() throws InterruptedException {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        ParallelStreamSolve test = new ParallelStreamSolve();
        boolean act = test.parallelStreamSolve(list);
        boolean exp = true;
        Assertions.assertEquals(exp, act);
    }

    @Test
    public void CompositeTest2() throws InterruptedException {
        List<Integer> list = Arrays.asList(94530, 945030, 945050, 945210, 945210);
        ParallelStreamSolve test = new ParallelStreamSolve();
        boolean act = test.parallelStreamSolve(list);
        boolean exp = true;
        Assertions.assertEquals(exp, act);
    }

    @Test
    public void CompositeTest3() throws InterruptedException {
        List<Integer> list = Arrays.asList(945032, 945037, 945059, 945089, 945103, 945143, 945151, 945179, 945209, 945211);
        ParallelStreamSolve test = new ParallelStreamSolve();
        boolean act = test.parallelStreamSolve(list);
        boolean exp = true;
        Assertions.assertEquals(exp, act);
    }
}
