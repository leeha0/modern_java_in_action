package chapter5;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import chapter4.model.Dish;

public class Ex20_IntStreamBoxed {

    public static void main(String[] args) {
        IntStream intStream = Dish.dishes().stream().mapToInt(Dish::getCalories);
        Stream<Integer> stream = intStream.boxed();

        stream.forEach(System.out::println);
    }
}
