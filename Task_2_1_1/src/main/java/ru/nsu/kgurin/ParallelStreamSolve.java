package ru.nsu.kgurin;

import java.util.List;

/**
 * Parallel streaming class used for finding composite number in the list of numbers.
 */
public class ParallelStreamSolve {
    /**
     * Function to find if there is a composite numbers in the list.
     *
     * @param numbers list of numbers to check
     * @return true if there is composite number, and false otherwise
     */
    public static boolean parallelStreamSolve(List<Integer> numbers) {
        return numbers.parallelStream().anyMatch(NotPrime::notPrime);
    }

}
