package chapter5;

import static java.util.stream.Collectors.*;

import java.util.List;

import chapter4.model.Dish;

public class Ex6_Skip {

    public static void main(String[] args) {
        List<Dish> dishes = Dish.dishes().stream()
            .filter(d -> d.getCalories() > 300)
            .skip(2)
            .collect(toList());

        System.out.println(dishes.toString());
    }
}
