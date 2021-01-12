package chapter6;

import static chapter4.model.Dish.*;
import static java.util.Arrays.*;
import static java.util.stream.Collectors.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import chapter4.model.Dish;

public class Ex11_MappingAndGrouping {

    public static void main(String[] args) {
        // 타입별 메뉴명 그룹화
        Map<Type, List<String>> dishNamesByType = dishes().stream()
            .collect(groupingBy(Dish::getType,
                mapping(Dish::getName, toList())));
        System.out.println("dishNamesByType = " + dishNamesByType);

        Map<String, List<String>> dishTags = new HashMap<>();
        dishTags.put("pork", asList("greasy", "salty"));
        dishTags.put("beef", asList("salty", "roasted"));
        dishTags.put("chicken", asList("fried", "crisp"));
        dishTags.put("french fries", asList("greasy", "fried"));
        dishTags.put("rice", asList("light", "natural"));
        dishTags.put("season fruit", asList("fresh", "natural"));
        dishTags.put("pizza", asList("tasty", "salty"));
        dishTags.put("prawns", asList("tasty", "roasted"));
        dishTags.put("salmon", asList("delicious", "fresh"));

        // 타입별 그룹화후 그룹별 메뉴 태그 추출
        Map<Type, Set<String>> dishNamesByType2 = dishes().stream()
            .collect(groupingBy(Dish::getType,
                flatMapping(dish -> dishTags.get(dish.getName()).stream(), toSet())));
        System.out.println("dishNamesByType2 = " + dishNamesByType2);

        // 타입별 칼로리 레벨 그룹화
        Map<Type, Set<CaloricLevel>> caloricLevelByType = Dish.dishes().stream()
            .collect(groupingBy(Dish::getType,
                mapping(dish -> {
                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                    else return CaloricLevel.FAT;
                }, toSet())
            ));
        System.out.println("caloricLevelByType = " + caloricLevelByType);

        Map<Type, Set<CaloricLevel>> caloricLevelByType2 = Dish.dishes().stream()
            .collect(groupingBy(Dish::getType,
                mapping(dish -> {
                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                    else return CaloricLevel.FAT;
                }, toCollection(HashSet::new))
            ));
        System.out.println("caloricLevelByType2 = " + caloricLevelByType2);
    }
}
