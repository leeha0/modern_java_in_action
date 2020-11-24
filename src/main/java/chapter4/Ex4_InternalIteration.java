package chapter4;

import static java.util.stream.Collectors.*;

import chapter4.model.Dish;
import chapter4.model.Dish.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex4_InternalIteration {

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
        List<String> names = menu.stream()
            .map(Dish::getName)
            .collect(toList());
    }
}
