package chapter6;

import static java.util.stream.Collectors.partitioningBy;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Ex18_PartitionedPrime {

    public static void main(String[] args) {
        // 정수 n을 인수로 2에서 n까지의 자연수를 소수와 비소수로 분류하는 프로그램

        Map<Boolean, List<Integer>> partitionPrimes = partitionPrimes(10);
        System.out.println("partitionPrimes = " + partitionPrimes);
    }

    public static Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n).boxed()
            .collect(partitioningBy(Ex18_PartitionedPrime::isPrime));
    }

    public static boolean isPrime(int candidate) {
        // 2부터 candidate 미만 사이의 자연수 생성
        return IntStream.range(2, candidate)
            .noneMatch(i -> candidate % i == 0);
    }

    public static boolean isPrime2(int candidate) {
        // 주어진 수의 제곱근 이하의 수로 제한
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return IntStream.rangeClosed(2, candidateRoot)
            .noneMatch(i -> candidate % i == 0);
    }
}
