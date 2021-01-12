package chapter6;

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.Map;

import chapter4.model.Dish;
import chapter4.model.Dish.Type;

public class Ex9_GrouppingDishes {

    public static void main(String[] args) {
        // 분류 함수(Classification Function)를 기준으로 스트림의 요소 그룹화
        Map<Type, List<Dish>> dishesByType =
            Dish.dishes().stream().collect(groupingBy(Dish::getType));
        System.out.println("dishesByType = " + dishesByType);

        // 400 칼로리 이하 'diet'
        // 400~700 칼로리 'normal'
        // 700 칼로리 초과 'fat'
        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = Dish.dishes().stream()
            .collect(groupingBy(dish -> {
                if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                else if (dish.getCalories() < 700) return CaloricLevel.NORMAL;
                else return CaloricLevel.FAT;
            }));
        System.out.println("dishesByCaloricLevel = " + dishesByCaloricLevel);
    }
}
