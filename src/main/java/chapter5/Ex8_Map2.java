package chapter5;

import static java.util.stream.Collectors.*;

import java.util.List;

import chapter4.model.Dish;

public class Ex8_Map2 {

    public static void main(String[] args) {
        List<Integer> dishNameLengths = Dish.dishes().stream()
            .map(Dish::getName)
            .map(String::length)
            .collect(toList());

        System.out.println(dishNameLengths.toString());
    }
}
