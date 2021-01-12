package chapter6;

import static java.util.stream.Collectors.*;

import chapter4.model.Dish;

public class Ex5_JoiningDishNames {

    public static void main(String[] args) {
        // 내부적으로 StringBuilder 사용
        String shortMenu = Dish.dishes().stream().map(Dish::getName).collect(joining());
        System.out.println("shortMenu = " + shortMenu);

        String shortMenu2 = Dish.dishes().stream().map(Dish::getName).collect(joining(", "));
        System.out.println("shortMenu2 = " + shortMenu2);
    }
}
