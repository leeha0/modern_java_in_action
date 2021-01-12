package chapter6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex7_CollectAndReduce {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // 모든 요소를 하나의 리스트로 생성
        // collect
        List<Integer> collectedNumbers = numbers.stream().collect(Collectors.toList());
        System.out.println("collectedNumbers = " + collectedNumbers);

        // reduce
        List<Integer> reducedNumbers = numbers.stream().reduce(
            new ArrayList<>(),
            (List<Integer> l, Integer e) -> {
                l.add(e);
                return l;
            },
            (List<Integer> l1, List<Integer> l2) -> {
                l1.addAll(l2); // 누적자 사용
                return l1;
            });
        System.out.println("reducedNumbers = " + reducedNumbers);
    }
}
