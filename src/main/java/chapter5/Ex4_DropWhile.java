package chapter5;

import static java.util.stream.Collectors.*;

import java.util.List;

import chapter4.model.Dish;

public class Ex4_DropWhile {

    public static void main(String[] args) {
        // 조건을 만족하지 못할 때까지의 요소를 버리고 남은 요소를 가져옴
        List<Dish> slicedMenu = Dish.specialDishes().stream()
            .dropWhile(dish -> dish.getCalories() < 320)
            .collect(toList());

        System.out.println(slicedMenu);
    }
}
