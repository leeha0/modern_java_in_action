package chapter6;

import chapter4.model.Dish;
import java.util.OptionalDouble;

public class Ex16_OptimizeStream {

    public static void main(String[] args) {
        OptionalDouble average = Dish.dishes().stream()
            .filter(dish -> dish.getCalories() > 600)
            .mapToInt(Dish::getCalories).average();
        System.out.println("average = " + average);

        /*
        스트림 최적화
            스트림의 지연(lazy) 연산의 특징을 통해 성능을 최적화
            중간연산자는 최종연산자가 실행하는 시점에 자바 컴파일러와 런타임이 스트림을 처리할때 최적화하여 실행
                filter-mapToInt → average
                average → filter-mapToInt
        */
    }
}
