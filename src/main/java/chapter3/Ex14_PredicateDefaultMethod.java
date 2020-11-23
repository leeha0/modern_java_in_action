package chapter3;

import static chapter2.model.Color.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import chapter2.model.Apple;

public class Ex14_PredicateDefaultMethod {

    public static void main(String[] args) {
        ArrayList<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(1, GREEN));
        inventory.add(new Apple(2, RED));
        inventory.add(new Apple(3, GREEN));

        Predicate<Apple> redApple = apple -> RED.equals(apple.getColor());
        Predicate<Apple> greenApple = apple -> GREEN.equals(apple.getColor());
        Predicate<Apple> heavyApple = apple -> apple.getWeight() > 150;

        // 반전
        Predicate<Apple> notRedApple = redApple.negate();

        // AND 연결
        Predicate<Apple> redAndHeavyApple = redApple.and(heavyApple);

        // OR 연결
        Predicate<Apple> redAndHeavyAppleOrGreen = redAndHeavyApple.or(greenApple);
    }
}
