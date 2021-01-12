package chapter6;

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.Map;

import chapter4.model.Dish;
import chapter4.model.Dish.Type;

public class Ex10_FilterAndGrouping {

    public static void main(String[] args) {
        Map<Type, List<Dish>> caloricDishedByType = Dish.dishes().stream()
            .filter(dish -> dish.getCalories() > 600)
            .collect(groupingBy(Dish::getType));
        System.out.println("caloricDishedByType = " + caloricDishedByType);

        Map<Type, List<Dish>> caloricDishedByType2 = Dish.dishes().stream()
            .collect(groupingBy(Dish::getType, filtering(dish -> dish.getCalories() > 600, toList())));
        System.out.println("caloricDishedByType2 = " + caloricDishedByType2);
    }
}
