package chapter5;

import chapter4.model.Dish;

public class Ex12_NoneMatch {

    public static void main(String[] args) {
        boolean isHealthy = Dish.dishes().stream()
            .noneMatch(dish -> dish.getCalories() >= 1000);

        System.out.println(isHealthy);
    }
}
