package chapter6;

import static java.util.stream.Collectors.*;

import java.util.Map;

import chapter4.model.Dish;
import chapter4.model.Dish.Type;

public class Ex13_CountingAndGrouping {

    public static void main(String[] args) {
        // 타입별 메뉴수 추출
        Map<Type, Long> typesCount = Dish.dishes().stream()
            .collect(groupingBy(Dish::getType, counting()));
        System.out.println("typesCount = " + typesCount);
    }
}
