package chapter5;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex28_StreamIterate {

    public static void main(String[] args) {
        Stream.iterate(0, n -> n + 2)
            .limit(10)
            .forEach(System.out::println);

        IntStream.iterate(0, n -> n < 100, n -> n + 4)
            .limit(10)
            .forEach(System.out::println);

        IntStream.iterate(0, n -> n + 4)
            .takeWhile(n -> n < 100)
            .forEach(System.out::println);
    }
}
