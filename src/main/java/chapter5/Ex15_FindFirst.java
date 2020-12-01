package chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Ex15_FindFirst {

    public static void main(String[] args) {
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> findSquareDivisibleByThree =
            someNumbers.stream()
                .map(n -> n * n)
                .filter(n -> n % 3 == 0)
                .findFirst();

        System.out.println(findSquareDivisibleByThree.orElse(0));
    }
}
