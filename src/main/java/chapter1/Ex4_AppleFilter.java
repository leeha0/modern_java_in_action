package chapter1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static chapter1.Ex4_AppleFilter.Color.*;
import static java.util.stream.Collectors.toList;

public class Ex4_AppleFilter {

    public static void main(String[] args) {
        ArrayList<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(1, GREEN));
        inventory.add(new Apple(2, RED));
        inventory.add(new Apple(3, GREEN));

        traditionalFilterGreenApples(inventory);
        traditionalFilterHeavyApples(inventory);

        modernFilterApples(inventory, Ex4_AppleFilter::isGreenApple);
        modernFilterApples(inventory, Ex4_AppleFilter::isHeavyApple);

        modernFilterApples(inventory, (Apple a) -> GREEN.equals(a.getColor()));
        modernFilterApples(inventory, (Apple a) -> a.getWeight() > 150);
        modernFilterApples(inventory, (Apple a) -> a.getWeight() < 80 || RED.equals(a.getColor()));

        List<Apple> heavyApplesByStream = inventory.stream().filter((Apple a) -> a.getWeight() > 150).collect(toList());
        List<Apple> heavyApplesByParallelStream = inventory.parallelStream().filter((Apple a) -> a.getWeight() > 150).collect(toList());
    }

    public static List<Apple> traditionalFilterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (GREEN.equals(apple.getColor())) {
                result.add(apple);
            }
        }

        return result;
    }

    public static List<Apple> traditionalFilterHeavyApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (apple.getWeight() > 150) {
                result.add(apple);
            }
        }

        return result;
    }

    public static List<Apple> modernFilterApples(List<Apple> inventory, Predicate<Apple> p) {
        // 프리디케이트: 인수로 값을 받아 true/false 반환하는 함수
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }

        return result;
    }


    public static boolean isGreenApple(Apple apple) {
        return GREEN.equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    static class Apple {
        Integer weight;
        Color color;

        public Apple(Integer weight, Color color) {
            this.weight = weight;
            this.color = color;
        }

        public Integer getWeight() {
            return weight;
        }

        public Color getColor() {
            return color;
        }
    }

    enum Color {
        GREEN,
        RED;
    }
}
