package chapter6;

import java.util.stream.Collectors;

import chapter4.model.Dish;

public class Ex2_CountingDishes {

    public static void main(String[] args) {
        printCount1();
        printCount2();
    }

    public static void printCount1() {
        // Collectors 팩토리 메서드 이용한 방법
        long houManyDishes = Dish.dishes().stream().collect(Collectors.counting());
        System.out.println(houManyDishes);
    }

    public static void printCount2() {
        // 불필요한 과정을 생략한 방법
        long howManyDishes = Dish.dishes().stream().count();
        System.out.println(howManyDishes);
    }
}
