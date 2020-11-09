package chapter2;

import java.util.ArrayList;
import java.util.List;

import static chapter2.Ex2_AppleClassification.Color.GREEN;
import static chapter2.Ex2_AppleClassification.Color.RED;

public class Ex2_AppleClassification {

    static class AppleHeavyWeightPredicate implements Ex2_ApplePredicate {

        @Override
        public boolean test(Apple apple) {
            return apple.getWeight() > 150;
        }
    }

    static class AppleGreenColorPredicate implements Ex2_ApplePredicate {

        @Override
        public boolean test(Apple apple) {
            return GREEN.equals(apple.getColor());
        }
    }

    static class AppleRedAndHeavyPredicate implements Ex2_ApplePredicate {

        @Override
        public boolean test(Apple apple) {
            return RED.equals(apple.getColor()) && apple.getWeight() > 150;
        }
    }

    public static void main(String[] args) {
        ArrayList<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(1, Ex1_AppleClassification.Color.GREEN));
        inventory.add(new Apple(2, Ex1_AppleClassification.Color.RED));
        inventory.add(new Apple(3, Ex1_AppleClassification.Color.GREEN));

        List<Apple> heavyApples = filterApples(inventory, new AppleHeavyWeightPredicate());
        List<Apple> greenApples = filterApples(inventory, new AppleGreenColorPredicate());
        List<Apple> redAndHeavyApples = filterApples(inventory, new AppleRedAndHeavyPredicate());
    }

    public static List<Apple> filterApples(List<Apple> inventory, Ex2_ApplePredicate p) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }

        return result;
    }

    static class Apple {
        Integer weight;
        Ex1_AppleClassification.Color color;

        public Apple(Integer weight, Ex1_AppleClassification.Color color) {
            this.weight = weight;
            this.color = color;
        }

        public Integer getWeight() {
            return weight;
        }

        public Ex1_AppleClassification.Color getColor() {
            return color;
        }
    }

    enum Color {
        GREEN,
        RED;
    }
}
