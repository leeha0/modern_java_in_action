package chapter5;

import java.util.List;
import java.util.Optional;

public class Ex16_Reduce1 {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4);

        int sum1 = numbers.stream().reduce(0, (a, b) -> a + b);
        int sum2 = numbers.stream().reduce(0, Integer::sum);
        Optional<Integer> sum3 = numbers.stream().reduce(Integer::sum);

        System.out.println(sum1);
        System.out.println(sum2);
        System.out.println(sum3.orElse(0));
    }
}
