package chapter6;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

import chapter4.model.Dish;

public class Ex3_MinMaxCalories {

    public static void main(String[] args) {
        // ComparingInt 키에 대해 사전식 순서로 정렬
        Comparator<Dish> dishCaloriesComparator =
            Comparator.comparingInt(Dish::getCalories);

        // Optional 값을 포함하거나 또는 포함하지 않을 수 있는 컨테이너
        Optional<Dish> mostCalorieDish = Dish.dishes().stream()
            .collect(Collectors.maxBy(dishCaloriesComparator));

        System.out.println(mostCalorieDish.get().toString());
    }
}
