package chapter4;

import static java.util.stream.Collectors.toList;

import chapter4.model.Dish;
import chapter4.model.Dish.Type;
import java.util.Arrays;
import java.util.List;

public class Ex5_IntermediateOperation {

    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Type.MEAT),
            new Dish("beef", false, 700, Type.MEAT),
            new Dish("chicken", false, 400, Type.MEAT),
            new Dish("french fries", true, 540, Type.OTHER),
            new Dish("rice", true, 350, Type.OTHER),
            new Dish("season fruit", true, 120, Type.OTHER),
            new Dish("pizza", true, 550, Type.OTHER),
            new Dish("prawns", true, 540, Type.FISH),
            new Dish("salmon", true, 540, Type.FISH)
        );

        // 스트림 내부 반복: 좀 더 선언형으로 데이터를 처리할 수 있다.
//        List<String> names = menu.stream()
//            .filter(dish -> dish.getCalories() > 300) // 중간 연산
//            .map(Dish::getName) // 중간 연산
//            .limit(3) // 중간 연산
//            .collect(toList()); // 최종 연산

        List<String> names = menu.stream()
            .filter(dish -> {
                System.out.println("filtering: " + dish.getName());
                return dish.getCalories() > 300;
            })
            .map(dish -> {
                System.out.println("mapping: " + dish.getName());
                return dish.getName();
            })
            .limit(3)
            .collect(toList());
    }
}
