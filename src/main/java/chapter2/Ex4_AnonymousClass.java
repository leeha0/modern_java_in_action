package chapter2;

import chapter2.model.Apple;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static chapter2.model.Color.GREEN;
import static chapter2.model.Color.RED;

public class Ex4_AnonymousClass {

    public static void main(String[] args) {
        ArrayList<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(1, GREEN));
        inventory.add(new Apple(2, RED));
        inventory.add(new Apple(3, GREEN));

        List<Apple> redApples = filterApples(inventory, new Predicate<Apple>() {

            @Override
            public boolean test(Apple apple) {
                return RED.equals(apple.getColor());
            }
        });

        List<Apple> weightApples = filterApples(inventory, apple -> apple.getWeight() > 150);
    }

    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }

        return result;
    }
}