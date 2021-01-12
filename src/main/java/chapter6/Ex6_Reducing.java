package chapter6;

import static java.util.stream.Collectors.*;

import java.util.Optional;
import java.util.stream.Collector;

import chapter4.model.Dish;

public class Ex6_Reducing {

    public static void main(String[] args) {
        // 합계
        int totalCalories = Dish.dishes().stream()
            .collect(reducing(0, Dish::getCalories, (i, j) -> i + j));
        System.out.println("totalCalories = " + totalCalories);

        // 최댓값
        Optional<Dish> mostCalorieDish = Dish.dishes().stream()
            .collect(reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));
        System.out.println("mostCalorieDish = " + mostCalorieDish);

        // 카운팅
        long totalMenuCount = Dish.dishes().stream()
            .collect(counting());
        System.out.println("totalMenuCount = " + totalMenuCount);

    }

    // 제네릭 와일드 카드 '?': 컬렉터의 누적자 형식이 알려지지 않았으며, 누적자 형식이 자유로움을 의미
    public static <T> Collector<T, ?, Long> counting() {
        return reducing(0L, e -> 1L, Long::sum);
    }
}
