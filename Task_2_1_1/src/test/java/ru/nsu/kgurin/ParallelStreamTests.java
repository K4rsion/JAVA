package ru.nsu.kgurin;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests that checks the correctness of ParallelStreamSolve class.
 */
public class ParallelStreamTests {
    @Test
    public void PrimeTestOne() throws InterruptedException {
        List<Integer> list = Arrays.asList(1, 2, 3);
        ParallelStreamSolve test = new ParallelStreamSolve();
        boolean act = test.parallelStreamSolve(list);
        boolean exp = false;
        Assertions.assertEquals(exp, act);
    }

    @Test
    public void PrimeTestTwo() throws InterruptedException {
        List<Integer> list = Arrays.asList(999917, 999931, 999953, 999959, 999961, 999979, 999983);
        ParallelStreamSolve test = new ParallelStreamSolve();
        boolean act = test.parallelStreamSolve(list);
        boolean exp = false;
        Assertions.assertEquals(exp, act);
    }

    @Test
    public void PrimeTestThree() throws InterruptedException {
        List<Integer> list = Arrays.asList(945031, 945037, 945059, 945089, 945103, 945143, 945151, 945179, 945209, 945211);
        ParallelStreamSolve test = new ParallelStreamSolve();
        boolean act = test.parallelStreamSolve(list);
        boolean exp = false;
        Assertions.assertEquals(exp, act);
    }

    @Test
    public void CompositeTestOne() throws InterruptedException {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        ParallelStreamSolve test = new ParallelStreamSolve();
        boolean act = test.parallelStreamSolve(list);
        boolean exp = true;
        Assertions.assertEquals(exp, act);
    }

    @Test
    public void CompositeTestTwo() throws InterruptedException {
        List<Integer> list = Arrays.asList(94530, 945030, 945050, 945210, 945210);
        ParallelStreamSolve test = new ParallelStreamSolve();
        boolean act = test.parallelStreamSolve(list);
        boolean exp = true;
        Assertions.assertEquals(exp, act);
    }

    @Test
    public void CompositeTestThree() throws InterruptedException {
        List<Integer> list = Arrays.asList(945032, 945037, 945059, 945089, 945103, 945143, 945151, 945179, 945209, 945211);
        ParallelStreamSolve test = new ParallelStreamSolve();
        boolean act = test.parallelStreamSolve(list);
        boolean exp = true;
        Assertions.assertEquals(exp, act);
    }
}