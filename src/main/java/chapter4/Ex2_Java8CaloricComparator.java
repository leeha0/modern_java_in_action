package chapter4;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

import java.util.List;

import chapter4.model.Dish;

public class Ex2_Java8CaloricComparator {

    public static void main(String[] args) {
        List<String> lowCaloricDishesName =
            Dish.dishes().stream()
                .filter(d -> d.getCalories() < 400)
                .sorted(comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(toList());

        System.out.println(lowCaloricDishesName.toString());
    }
}
