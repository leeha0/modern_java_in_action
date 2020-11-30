package chapter4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import chapter4.model.Dish;

public class Ex1_Java7CaloricComparator {

    public static void main(String[] args) {
        // 가비지 변수 (중간 변수)
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for (Dish dish : Dish.dishes()) {
            if (dish.getCalories() < 400) {
                lowCaloricDishes.add(dish);
            }
        }

        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(), o2.getCalories());
            }
        });

        List<String> lowCaloricDishesName = new ArrayList<>();
        for (Dish dish : lowCaloricDishes) {
            lowCaloricDishesName.add(dish.getName());
        }

        System.out.println(lowCaloricDishesName.toString());
    }
}
