package chapter4;

import static java.util.stream.Collectors.*;

import java.util.List;

import chapter4.model.Dish;

public class Ex5_IntermediateOperation {

    public static void main(String[] args) {
        // 스트림 내부 반복: 좀 더 선언형으로 데이터를 처리할 수 있다.
//        List<String> names = menu.stream()
//            .filter(dish -> dish.getCalories() > 300) // 중간 연산
//            .map(Dish::getName) // 중간 연산
//            .limit(3) // 중간 연산
//            .collect(toList()); // 최종 연산

        List<String> names = Dish.dishes().stream()
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

        System.out.println(names.toString());
    }
}
