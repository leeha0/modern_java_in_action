package chapter6;

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.Map;

import chapter4.model.Dish;

public class Ex12_MultipleGrouping {

    public static void main(String[] args) {
        // 타입별 칼로리 레벨별 메뉴 그룹화
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel = Dish.dishes().stream()
            .collect(groupingBy(Dish::getType,
                groupingBy(dish -> {
                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                    else return CaloricLevel.FAT;
                })
            ));
        System.out.println("dishesByTypeCaloricLevel = " + dishesByTypeCaloricLevel);
    }
}
