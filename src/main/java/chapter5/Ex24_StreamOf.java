package chapter5;

import java.util.stream.Stream;

public class Ex24_StreamOf {

    public static void main(String[] args) {
        Stream<String> stream = Stream.of("Modern ", "Java ", "In ", "Action ");
        stream.map(String::toUpperCase).forEach(System.out::println);

        Stream<String> emptyStream = Stream.empty();
    }
}
