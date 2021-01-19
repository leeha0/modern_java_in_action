package chapter6;

import static java.util.stream.Collector.*;

import chapter4.model.Dish;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collector.Characteristics;
import java.util.stream.Collectors;

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

        Collector<Dish, List<Dish>, List<Dish>> dishCollector =
            of(
                ArrayList::new,
                List::add,
                (List<Dish> list1, List<Dish> list2) -> {
                    list1.addAll(list2);
                    return list1;
                },
                new Collector.Characteristics[]{
                    Characteristics.UNORDERED,
                    Characteristics.CONCURRENT,
                    Characteristics.IDENTITY_FINISH
                }
            );

        List<Dish> dishes1 = Dish.dishes().stream().collect(dishCollector);
        System.out.println("dishes1 = " + dishes1);
    }
}
