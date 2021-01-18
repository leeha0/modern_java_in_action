package chapter6;

import chapter4.model.Dish;
import java.util.List;
import java.util.stream.Collectors;

public class Ex20_ToListCollectDish {

    public static void main(String[] args) {
        List<Dish> myDishes = Dish.dishes().stream().collect(new Ex19_ToListCollector<>());
        System.out.println("myDishes = " + myDishes);

        List<Dish> dishes = Dish.dishes().stream().collect(Collectors.toList());
        System.out.println("dishes = " + dishes);
    }
}
