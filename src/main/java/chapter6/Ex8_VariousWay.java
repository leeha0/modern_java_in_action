package chapter6;

import static java.util.stream.Collectors.*;

import chapter4.model.Dish;

public class Ex8_VariousWay {

    public static void main(String[] args) {
        // 합계: 리듀싱 컬렉터
        int totalCalories1 = Dish.dishes().stream()
            .collect(reducing(0, Dish::getCalories, Integer::sum));
        System.out.println("totalCalories1 = " + totalCalories1);

        // 합계: 컬렉터를 사용하지 않는 방법
        int totalCalories2 = Dish.dishes().stream()
            .map(Dish::getCalories).reduce(Integer::sum).orElse(0); // 하나의 인자를 갖는 reduce 는 Optional 을 반환
        System.out.println("totalCalories2 = " + totalCalories2);

        // 합계: 특화 스트림(IntStream) 사용하는 방법
        int totalCalories3 = Dish.dishes().stream()
            .mapToInt(Dish::getCalories).sum();

    }
}
