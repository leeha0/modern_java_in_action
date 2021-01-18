package chapter6;

import static java.util.stream.Collectors.partitioningBy;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Ex22_OptimizeCustomCollector {

    public static void main(String[] args) {
        Map<Boolean, List<Integer>> partitionPrimes = partitionPrimes(10);
        System.out.println("partitionPrimes = " + partitionPrimes);
    }

    public static Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n).boxed()
            .collect(partitioningBy(candidate -> isPrime(candidate)));
    }

    public static boolean isPrime(int candidate) {
        // 개선1: 제곱근 이하로 대상 숫자 범위를 제한하여 isPrame 메서드 개선
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return IntStream.rangeClosed(2, candidateRoot)
            .noneMatch(i -> candidate % i == 0);
    }
}
