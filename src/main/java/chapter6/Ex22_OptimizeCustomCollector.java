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
        // 개선1: 제곱근 이하로 대상 숫자 범위를 제한하여 isPrime 메서드 개선
        // candidate로 나눌때 나눈 결과의 몫이 candidate보다 작아지기 때문
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return IntStream.rangeClosed(2, candidateRoot)
            .noneMatch(i -> candidate % i == 0);
    }

    public static boolean isPrime(List<Integer> primes, int candidate) {
        // 개선2: 지금까지 발견된 소수 리스트로 제수(devisor)가 나누어떨어지는지 확인 (중간 결과가 있다면)
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return primes.stream()
            // .filter(i -> i <= candidateRoot) // 전체 스트림을 처리한 다음에 결과를 반환
            .takeWhile(i -> i <= candidateRoot) // 조건을 만족할때까지의 요소 반환
            .noneMatch(i -> candidate % i == 0);
    }
}
