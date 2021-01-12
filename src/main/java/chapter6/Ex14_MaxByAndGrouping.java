package chapter6;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

import java.util.Map;
import java.util.Optional;

import chapter4.model.Dish;
import chapter4.model.Dish.Type;

public class Ex14_MaxByAndGrouping {

    public static void main(String[] args) {
        // 타입별 가장 높은 칼로리 메뉴 추출
        // groupingBy 컬렉터는 스트림의 첫 번째 요소를 찾은 이후에 그룹화 맵에 키를 (게으르게) 추가한다.
        // Optional.empty() 값을 갖는 메뉴가 존재하지 않기 때문에 Optional 래퍼를 사용할 필요는 없다.
        // 즉, 리듀싱 컬렉터는 절대 Optional.empty()를 반환하지 않는다.
        Map<Type, Optional<Dish>> mostCaloricByType = Dish.dishes().stream()
            .collect(groupingBy(Dish::getType,
                maxBy(comparingInt(Dish::getCalories))));
        System.out.println("mostCaloricByType = " + mostCaloricByType);

        // 불필요한 Optional 제거
        Map<Type, Dish> mostCaloricByType2 = Dish.dishes().stream()
            .collect(groupingBy(Dish::getType, // 분류 함수
                collectingAndThen(
                    maxBy(comparingInt(Dish::getCalories)), // 컬렉터 래필
                    Optional::get // 변환 함수
                )));
        System.out.println("mostCaloricByType2 = " + mostCaloricByType2);
    }
}
