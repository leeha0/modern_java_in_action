package chapter6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Ex23_TakeWhileForJava8 {

    public static void main(String[] args) {
        Map<Boolean, List<Integer>> partitionPrimes = partitionPrimesWithCustomCollector(10);
        System.out.println("partitionPrimes = " + partitionPrimes);
    }

    public static Map<Boolean, List<Integer>> partitionPrimesWithCustomCollector(int n) {
        return IntStream.rangeClosed(2, n).boxed()
            .collect(new Ex23_PrimeNumbersCollector());
    }

    public static Map<Boolean, List<Integer>> partitionPrimesWithCustomCollect(int n) {
        return IntStream.rangeClosed(2, n).boxed()
            .collect(
                // 발행
                () -> new HashMap<Boolean, List<Integer>>() {{
                    put(true, new ArrayList<>());
                    put(false, new ArrayList<>());
                }},
                // 누적
                (acc, candidate) -> acc.get(isPrime(acc.get(true), candidate)).add(candidate),
                // 합침
                (map1, map2) -> {
                    map1.get(true).addAll(map2.get(true));
                    map2.get(false).addAll(map2.get(false));
                });
    }

    public static boolean isPrime(List<Integer> primes, int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return takeWhile(primes, i -> i <= candidateRoot)
            .stream()
            .noneMatch(p -> candidate % p == 0);
    }

    public static <A> List<A> takeWhile(List<A> list, Predicate<A> p) {
        // 직접 구현한 takeWhile 메서드는 적극적(Eager)으로 동작한다.
        // 가능하면 noneMatch 동작과 조화를 이룰 수 있도록 자바 9의 스트림에서 제공하는 게으른 버전의 takeWhile 을 사용하는 것이 좋다.
        int i = 0;
        for (A item : list) {
            if (!p.test(item)) {
                return list.subList(0, i);
            }
            i++;
        }

        return list;
    }
}
