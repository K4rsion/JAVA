package ru.nsu.kgurin;

import java.util.List;

public class Solve{
    public Boolean sequentialSolve(List<Integer> numbers){
        return numbers.stream().anyMatch(this::notPrime);
    }

    public Boolean parallelStreamSolve(List<Integer> numbers){
        return numbers.parallelStream().anyMatch(this::notPrime);
    }

    public void threadSolve(List<Integer> numbers){
    }

    private Boolean notPrime(int n){
        for (int i = 2; i < (int)Math.sqrt(n)+1; i++){
            if (n%i==0){
                return true;
            }
        }
        return false;
    }
}
