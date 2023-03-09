package ru.nsu.kgurin;

import java.util.Arrays;

public class AverageTest {
    public static void main(String[] args) throws InterruptedException {
        TimeComplexityTests test = new TimeComplexityTests();
        Long[][] data = new Long[13][5];
        for (int i = 0; i < 5; i++) {
            System.out.println("Test repeat № " + (i + 1) + " - started");
            data[0][i] = test.sequentialPrimeTest();
            data[1][i] = test.parallelStreamPrimeTest();
            data[2][i] = test.threadsPrimeTest1();
            data[3][i] = test.threadsPrimeTest2();
            data[4][i] = test.threadsPrimeTest4();
            data[5][i] = test.threadsPrimeTest8();
            data[6][i] = test.threadsPrimeTest16();
            data[7][i] = test.threadsPrimeTest32();
            data[8][i] = test.threadsPrimeTest64();
            data[9][i] = test.threadsPrimeTest128();
            data[10][i] = test.threadsPrimeTest256();
            data[11][i] = test.threadsPrimeTest256();
            data[12][i] = test.threadsPrimeTest256();
            System.out.println("Test repeat № " + (i + 1) + " - finished");
        }
        System.out.println("============Tests " +
                "finished===========");
        System.out.println("Sequential average: " +
                Arrays.stream(data[0])
                        .mapToLong(Long::longValue)
                        .average());
        System.out.println("ParallelStream average: " +
                Arrays.stream(data[1])
                        .mapToLong(Long::longValue)
                        .average());
        System.out.println("1 thread average: " +
                Arrays.stream(data[2])
                        .mapToLong(Long::longValue)
                        .average());
        System.out.println("2 thread average: " +
                Arrays.stream(data[3])
                        .mapToLong(Long::longValue)
                        .average());
        System.out.println("4 thread average: " +
                Arrays.stream(data[4])
                        .mapToLong(Long::longValue)
                        .average());
        System.out.println("8 thread average: " +
                Arrays.stream(data[5])
                        .mapToLong(Long::longValue)
                        .average());
        System.out.println("16 thread average: " +
                Arrays.stream(data[6])
                        .mapToLong(Long::longValue)
                        .average());
        System.out.println("32 thread average: " +
                Arrays.stream(data[7])
                        .mapToLong(Long::longValue)
                        .average());
        System.out.println("64 thread average: " +
                Arrays.stream(data[8])
                        .mapToLong(Long::longValue)
                        .average());
        System.out.println("128 thread average: " +
                Arrays.stream(data[9])
                        .mapToLong(Long::longValue)
                        .average());
        System.out.println("256 thread average: " +
                Arrays.stream(data[10])
                        .mapToLong(Long::longValue)
                        .average());
        System.out.println("512 thread average: " +
                Arrays.stream(data[11])
                        .mapToLong(Long::longValue)
                        .average());
        System.out.println("1024 thread average: " +
                Arrays.stream(data[12])
                        .mapToLong(Long::longValue)
                        .average());
    }
}
