package chapter6;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.partitioningBy;

import chapter4.model.Dish;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Ex17_PartitionedMenu {

    public static void main(String[] args) {
        // 분류 함수를 통한 분류
        Map<Boolean, List<Dish>> partitionedMenu =
            Dish.dishes().stream().collect(partitioningBy(Dish::isVegetarian));
        System.out.println("partitionedMenu = " + partitionedMenu);

        List<Dish> vegetarianDishes1 = partitionedMenu.get(true);
        System.out.println("vegetarianDishes1 = " + vegetarianDishes1);

        // 필터링을 통한 결과 수집
        List<Dish> vegetarianDishes2 =
            Dish.dishes().stream().filter(Dish::isVegetarian).collect(Collectors.toList());
        System.out.println("vegetarianDishes2 = " + vegetarianDishes2);

        // 콜렉터를 사용하여 두 수준의 맵 생성
        Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishsByType = Dish.dishes().stream()
            .collect(partitioningBy(Dish::isVegetarian,
                groupingBy(Dish::getType)));
        System.out.println("vegetarianDishsByType = " + vegetarianDishsByType);

        Map<Boolean, Dish> mostCaloricPartitionedByVegetarian = Dish.dishes().stream()
            .collect(partitioningBy(Dish::isVegetarian,
                collectingAndThen(
                    maxBy(Comparator.comparingInt(Dish::getCalories)),
                    Optional::get)
                ));
        System.out.println("mostCaloricPartitionedByVegetarian = " + mostCaloricPartitionedByVegetarian);
    }
}
