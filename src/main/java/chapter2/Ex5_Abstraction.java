package chapter2;

import chapter2.model.Apple;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static chapter2.model.Color.GREEN;
import static chapter2.model.Color.RED;

public class Ex5_Abstraction {

    public static void main(String[] args) {
        ArrayList<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(1, GREEN));
        inventory.add(new Apple(2, RED));
        inventory.add(new Apple(3, GREEN));

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        List<Apple> redApples = filter(inventory, apple -> RED.equals(apple.getColor()));
        List<Integer> evenNumbers = filter(numbers, i -> i % 2 == 0);
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();

        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }

        return result;
    }
}