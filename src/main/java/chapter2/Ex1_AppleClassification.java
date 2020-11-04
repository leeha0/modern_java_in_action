package chapter2;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.List;

import static chapter2.Ex1_AppleClassification.Color.GREEN;
import static chapter2.Ex1_AppleClassification.Color.RED;

public class Ex1_AppleClassification {

    public static void main(String[] args) {
        ArrayList<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(1, Color.GREEN));
        inventory.add(new Apple(2, RED));
        inventory.add(new Apple(3, Color.GREEN));

        filterGreenApples(inventory);
        filterRedApples(inventory);

        filterApples(inventory, GREEN);
        filterApples(inventory, RED);

        filterApplesByWeight(inventory, 150);

        filterApples(inventory, GREEN, 0, true);
        filterApples(inventory, null, 150, false);
    }

    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (GREEN.equals(apple.getColor())) {
                result.add(apple);
            }
        }

        return result;
    }

    public static List<Apple> filterRedApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (RED.equals(apple.getColor())) {
                result.add(apple);
            }
        }

        return result;
    }

    public static List<Apple> filterApples(List<Apple> inventory, Color color) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (color.equals(apple.getColor())) {
                result.add(apple);
            }
        }

        return result;
    }

    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (apple.getWeight() > weight) {
                result.add(apple);
            }
        }

        return result;
    }

    public static List<Apple> filterApples(List<Apple> inventory, Color color, int weight, boolean flag) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if ((flag && apple.getColor().equals(color)) || (!flag && apple.getWeight() > weight)) {
                result.add(apple);
            }
        }

        return result;
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
