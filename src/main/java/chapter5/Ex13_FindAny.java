package chapter5;

import java.util.Optional;

import chapter4.model.Dish;
import chapter4.model.Dish.Type;

public class Ex13_FindAny {

    public static void main(String[] args) {
        Optional<Dish> dish = Dish.dishes().stream()
            .filter(Dish::isVegetarian)
            .findAny();

        System.out.println(dish.orElseGet(() -> new Dish("default", false, 0, Type.OTHER)));
    }
}
