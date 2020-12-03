package chapter5;

import java.util.OptionalInt;

import chapter4.model.Dish;

public class Ex21_OptionalInt {

    public static void main(String[] args) {
        OptionalInt maxCalories = Dish.dishes().stream()
            .mapToInt(Dish::getCalories)
            .max();
        int max = maxCalories.orElse(1);
    }
}
