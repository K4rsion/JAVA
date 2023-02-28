package ru.nsu.kgurin;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Complex tests for time measuring.
 */
public class TimeComplexityTests {
    private final long size = 10000000;
    private final List<Integer> primeList = initPrimeList();

    private List<Integer> initPrimeList() {
        List<Integer> result = new ArrayList<>();
        for (long i = 0; i < size; i++) {
            result.add(100003);
        }
        return result;
    }

    @Test
    public void sequentialPrimeTest() {
        long time = System.currentTimeMillis();
        boolean act = SequentialSolve.sequentialSolve(primeList);
        System.out.println("Sequential test with prime numbers: "
                + (System.currentTimeMillis() - time));
        boolean exp = false;
        Assertions.assertEquals(exp, act);
    }

    @Test
    public void ParallelStreamPrimeTest() {
        long time = System.currentTimeMillis();
        boolean act = ParallelStreamSolve.parallelStreamSolve(primeList);
        System.out.println("ParallelStream test with prime numbers: "
                + (System.currentTimeMillis() - time));
        boolean exp = false;
        Assertions.assertEquals(exp, act);
    }

    @Test
    public void ThreadsPrimeTestOne() throws InterruptedException {
        long time = System.currentTimeMillis();
        ThreadSolve test = new ThreadSolve();
        boolean act = test.threadSolve(primeList, 1);
        System.out.println("1 thread test with prime numbers: "
                + (System.currentTimeMillis() - time));
        boolean exp = false;
        Assertions.assertEquals(exp, act);
    }

    @Test
    public void ThreadsPrimeTestTwo() throws InterruptedException {
        long time = System.currentTimeMillis();
        ThreadSolve test = new ThreadSolve();
        boolean act = test.threadSolve(primeList, 2);
        System.out.println("2 thread test with prime numbers: "
                + (System.currentTimeMillis() - time));
        boolean exp = false;
        Assertions.assertEquals(exp, act);
    }

    @Test
    public void ThreadsPrimeTestThree() throws InterruptedException {
        long time = System.currentTimeMillis();
        ThreadSolve test = new ThreadSolve();
        boolean act = test.threadSolve(primeList, 4);
        System.out.println("4 thread test with prime numbers: "
                + (System.currentTimeMillis() - time));
        boolean exp = false;
        Assertions.assertEquals(exp, act);
    }

    @Test
    public void ThreadsPrimeTestFour() throws InterruptedException {
        long time = System.currentTimeMillis();
        ThreadSolve test = new ThreadSolve();
        boolean act = test.threadSolve(primeList, 8);
        System.out.println("8 thread test with prime numbers: "
                + (System.currentTimeMillis() - time));
        boolean exp = false;
        Assertions.assertEquals(exp, act);
    }

    @Test
    public void ThreadsPrimeTestFive() throws InterruptedException {
        long time = System.currentTimeMillis();
        ThreadSolve test = new ThreadSolve();
        boolean act = test.threadSolve(primeList, 32);
        System.out.println("32 thread test with prime numbers: "
                + (System.currentTimeMillis() - time));
        boolean exp = false;
        Assertions.assertEquals(exp, act);
    }

    @Test
    public void ThreadsPrimeTestSix() throws InterruptedException {
        long time = System.currentTimeMillis();
        ThreadSolve test = new ThreadSolve();
        boolean act = test.threadSolve(primeList, 64);
        System.out.println("64 thread test with prime numbers: "
                + (System.currentTimeMillis() - time));
        boolean exp = false;
        Assertions.assertEquals(exp, act);
    }

    @Test
    public void ThreadsPrimeTestSeven() throws InterruptedException {
        long time = System.currentTimeMillis();
        ThreadSolve test = new ThreadSolve();
        boolean act = test.threadSolve(primeList, 128);
        System.out.println("128 thread test with prime numbers: "
                + (System.currentTimeMillis() - time));
        boolean exp = false;
        Assertions.assertEquals(exp, act);
    }
}
