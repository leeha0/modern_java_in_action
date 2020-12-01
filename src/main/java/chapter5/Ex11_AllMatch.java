package chapter5;

import chapter4.model.Dish;

public class Ex11_AllMatch {

    public static void main(String[] args) {
        boolean isHealthy = Dish.dishes().stream()
            .anyMatch(dish -> dish.getCalories() < 1000);

        System.out.println(isHealthy);
    }
}
