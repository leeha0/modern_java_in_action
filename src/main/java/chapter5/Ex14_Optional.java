package chapter5;

import chapter4.model.Dish;

public class Ex14_Optional {

    public static void main(String[] args) {
        Dish.dishes().stream()
            .filter(Dish::isVegetarian)
            .findAny()
            .ifPresent(dish -> System.out.println(dish.getName()));
    }
}
