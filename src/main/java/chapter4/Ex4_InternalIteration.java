package chapter4;

import static java.util.stream.Collectors.*;

import java.util.List;

import chapter4.model.Dish;

public class Ex4_InternalIteration {

    public static void main(String[] args) {
        // 스트림 내부 반복: 좀 더 선언형으로 데이터를 처리할 수 있다.
        List<String> names = Dish.dishes().stream()
            .map(Dish::getName)
            .collect(toList());

        System.out.println(names.toString());
    }
}
