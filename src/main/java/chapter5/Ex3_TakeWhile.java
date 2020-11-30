package chapter5;

import static java.util.stream.Collectors.*;

import java.util.Collections;
import java.util.List;

import chapter4.model.Dish;

public class Ex3_TakeWhile {

    public static void main(String[] args) {
        List<Dish> specialMenu = Dish.specialDishes();

        List<Dish> filterMenu = specialMenu.stream()
            .filter(dish -> dish.getCalories() < 320)
            .collect(toList());

        System.out.println(filterMenu.toString());

        // 조건을 만족할 때까지의 요소를 가져옴
        List<Dish> slicedMenu = specialMenu.stream()
            .takeWhile(dish -> dish.getCalories() < 320)
            .collect(toList());

        System.out.println(slicedMenu.toString());
    }
}
