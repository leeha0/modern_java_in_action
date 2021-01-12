package chapter6;

import static java.util.stream.Collectors.*;

import java.util.Map;

import chapter4.model.Dish;
import chapter4.model.Dish.Type;

public class Ex15_SummingAndGrouping {

    public static void main(String[] args) {
        Map<Type, Integer> totalCaloriesByType = Dish.dishes().stream()
            .collect(groupingBy(Dish::getType,
                summingInt(Dish::getCalories)));
        System.out.println("totalCaloriesByType = " + totalCaloriesByType);
    }
}
