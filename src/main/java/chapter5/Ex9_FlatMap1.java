package chapter5;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Ex9_FlatMap1 {

    public static void main(String[] args) {
        List<String> words = List.of("Hello", "World");

        List<String[]> distinctCharacters1 = words.stream()
            .map(word -> word.split(""))
            .distinct()
            .collect(toList());

        System.out.println(distinctCharacters1.toString());

        List<Stream<String>> distinctCharacters2 = words.stream()
            .map(word -> word.split(""))
            .map(Arrays::stream)
            .distinct()
            .collect(toList());

        System.out.println(distinctCharacters2.toString());

        List<String> distinctCharacters3 = words.stream()
            .map(word -> word.split(""))
            .flatMap(Arrays::stream)
            .distinct()
            .collect(toList());

        System.out.println(distinctCharacters3.toString());
    }
}
