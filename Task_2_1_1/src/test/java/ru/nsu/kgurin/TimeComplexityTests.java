package ru.nsu.kgurin;

import java.util.ArrayList;
import java.util.List;

/**
 * Complex tests for time measuring.
 */
public class TimeComplexityTests {
    private final List<Integer> primeList = initPrimeList();

    /**
     * Initialization of list contains only prime numbers.
     *
     * @return list with prime numbers
     */
    private List<Integer> initPrimeList() {
        List<Integer> result = new ArrayList<>();
        long size = 10_000_000;
        for (long i = 0; i < size; i++) {
            result.add(100003);
        }
        return result;
    }

    public long sequentialPrimeTest() {
        long timeStart = System.currentTimeMillis();
        SequentialSolve.sequentialSolve(primeList);
        long timeFinish = System.currentTimeMillis() - timeStart;
        System.out.println("Sequential test: " + timeFinish);
        return timeFinish;
    }

    public long parallelStreamPrimeTest() {
        long timeStart = System.currentTimeMillis();
        ParallelStreamSolve.parallelStreamSolve(primeList);
        long timeFinish = System.currentTimeMillis() - timeStart;
        System.out.println("ParallelStream test: " + timeFinish);
        return timeFinish;
    }

    public long threadsPrimeTest1() throws InterruptedException {
        long timeStart = System.currentTimeMillis();
        ThreadSolve test = new ThreadSolve();
        test.threadSolve(primeList, 1);
        long timeFinish = System.currentTimeMillis() - timeStart;
        System.out.println("1 thread test: " + timeFinish);
        return timeFinish;
    }

    public long threadsPrimeTest2() throws InterruptedException {
        long timeStart = System.currentTimeMillis();
        ThreadSolve test = new ThreadSolve();
        test.threadSolve(primeList, 2);
        long timeFinish = System.currentTimeMillis() - timeStart;
        System.out.println("2 thread test: " + timeFinish);
        return timeFinish;
    }

    public long threadsPrimeTest4() throws InterruptedException {
        long timeStart = System.currentTimeMillis();
        ThreadSolve test = new ThreadSolve();
        test.threadSolve(primeList, 4);
        long timeFinish = System.currentTimeMillis() - timeStart;
        System.out.println("4 thread test: " + timeFinish);
        return timeFinish;
    }

    public long threadsPrimeTest8() throws InterruptedException {
        long timeStart = System.currentTimeMillis();
        ThreadSolve test = new ThreadSolve();
        test.threadSolve(primeList, 8);
        long timeFinish = System.currentTimeMillis() - timeStart;
        System.out.println("8 thread test: " + timeFinish);
        return timeFinish;
    }

    public long threadsPrimeTest16() throws InterruptedException {
        long timeStart = System.currentTimeMillis();
        ThreadSolve test = new ThreadSolve();
        test.threadSolve(primeList, 16);
        long timeFinish = System.currentTimeMillis() - timeStart;
        System.out.println("16 thread test: " + timeFinish);
        return timeFinish;
    }

    public long threadsPrimeTest32() throws InterruptedException {
        long timeStart = System.currentTimeMillis();
        ThreadSolve test = new ThreadSolve();
        test.threadSolve(primeList, 32);
        long timeFinish = System.currentTimeMillis() - timeStart;
        System.out.println("32 thread test: " + timeFinish);
        return timeFinish;
    }

    public long threadsPrimeTest64() throws InterruptedException {
        long timeStart = System.currentTimeMillis();
        ThreadSolve test = new ThreadSolve();
        test.threadSolve(primeList, 64);
        long timeFinish = System.currentTimeMillis() - timeStart;
        System.out.println("64 thread test: " + timeFinish);
        return timeFinish;
    }

    public long threadsPrimeTest128() throws InterruptedException {
        long timeStart = System.currentTimeMillis();
        ThreadSolve test = new ThreadSolve();
        test.threadSolve(primeList, 128);
        long timeFinish = System.currentTimeMillis() - timeStart;
        System.out.println("128 thread test: " + timeFinish);
        return timeFinish;
    }

    public long threadsPrimeTest256() throws InterruptedException {
        long timeStart = System.currentTimeMillis();
        ThreadSolve test = new ThreadSolve();
        test.threadSolve(primeList, 256);
        long timeFinish = System.currentTimeMillis() - timeStart;
        System.out.println("256 thread test: " + timeFinish);
        return timeFinish;
    }

    public long threadsPrimeTest512() throws InterruptedException {
        long timeStart = System.currentTimeMillis();
        ThreadSolve test = new ThreadSolve();
        test.threadSolve(primeList, 512);
        long timeFinish = System.currentTimeMillis() - timeStart;
        System.out.println("512 thread test: " + timeFinish);
        return timeFinish;
    }

    public long threadsPrimeTest1024() throws InterruptedException {
        long timeStart = System.currentTimeMillis();
        ThreadSolve test = new ThreadSolve();
        test.threadSolve(primeList, 1024);
        long timeFinish = System.currentTimeMillis() - timeStart;
        System.out.println("1024 thread test: " + timeFinish);
        return timeFinish;
    }
}
