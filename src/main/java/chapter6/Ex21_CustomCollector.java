package chapter6;

import chapter4.model.Dish;
import java.util.ArrayList;
import java.util.List;

public class Ex21_CustomCollector {

    public static void main(String[] args) {
        // IDENTITY_FINISH, CONCURRENT, ORDERED 시에만 동작
        List<Dish> dishes = Dish.dishes().stream().collect(
            // 발행
            ArrayList::new,
            // 누적
            List::add,
            // 합침
            List::addAll
        );
        System.out.println("dishes = " + dishes);
    }
}
