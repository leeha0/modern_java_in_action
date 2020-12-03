package chapter5;

import chapter4.model.Dish;

public class Ex19_IntStream {

    public static void main(String[] args) {
        int calories = Dish.dishes().stream()
            .mapToInt(Dish::getCalories)
            .sum();
        System.out.println(calories);
    }
}
