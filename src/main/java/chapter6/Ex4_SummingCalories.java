package chapter6;

import static java.util.stream.Collectors.*;

import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;

import chapter4.model.Dish;

public class Ex4_SummingCalories {

    public static void main(String[] args) {
        // 객체를 int로 매핑하는 함수를 인자로 요약
        // 합계
        int totalCalories = Dish.dishes().stream().collect(Collectors.summingInt(Dish::getCalories));
        System.out.println("totalCalories = " + totalCalories);

        // 평균
        double avgCalories = Dish.dishes().stream().collect(averagingInt(Dish::getCalories));
        System.out.println("avgCalories = " + avgCalories);

        // 요약 (두 개 이상의 연산을 한 번에 수행)
        IntSummaryStatistics menuStatistics = Dish.dishes().stream().collect(summarizingInt(Dish::getCalories));
        System.out.println("menuStatistics = " + menuStatistics);
    }
}
