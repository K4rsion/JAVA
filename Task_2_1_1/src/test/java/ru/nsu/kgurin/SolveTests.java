package ru.nsu.kgurin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SolveTests {
    @Test
    public void simple(){
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        Solve act = new Solve();
        Assertions.assertTrue(act.sequentialSolve(numbers));
        Assertions.assertTrue(act.parallelStreamSolve(numbers));
    }
}
