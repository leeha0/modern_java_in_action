package chapter5;

import java.util.stream.IntStream;

public class Ex22_IntStreamRange {

    public static void main(String[] args) {
        IntStream evenNumbers = IntStream.rangeClosed(1, 100)
            .filter(n -> n % 2 == 0);
        System.out.println(evenNumbers.count());
    }
}
