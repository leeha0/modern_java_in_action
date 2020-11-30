package chapter5;

import static java.util.stream.Collectors.*;

import java.util.List;

import chapter4.model.Dish;

public class Ex5_Limit {

    public static void main(String[] args) {
        List<Dish> dishes = Dish.specialDishes().stream()
            .filter(dish -> dish.getCalories() > 300)
            .limit(3)
            .collect(toList());

        System.out.println(dishes.toString());
    }
}
