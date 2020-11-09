package chapter2;

import java.util.ArrayList;
import java.util.List;

public class Ex3_ApplePrettyPrint {

    static class AppleFancyFormatter implements Ex3_AppleFormatter {

        @Override
        public String accept(Apple apple) {
            String characteristic = apple.getWeight() > 150 ? "heavy" : "light";
            return "A " + characteristic + " " + apple.getColor() + " apple";
        }
    }

    static class AppleSimpleFormatter implements Ex3_AppleFormatter {

        @Override
        public String accept(Apple apple) {
            return "An apple of" + apple.getWeight() + "g";
        }
    }

    public static void main(String[] args) {
        ArrayList<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(1, Ex1_AppleClassification.Color.GREEN));
        inventory.add(new Apple(2, Ex1_AppleClassification.Color.RED));
        inventory.add(new Apple(3, Ex1_AppleClassification.Color.GREEN));

        prettyPrintApple(inventory, new AppleSimpleFormatter());
        prettyPrintApple(inventory, new AppleFancyFormatter());
    }

    public static void prettyPrintApple(List<Apple> inventory, Ex3_AppleFormatter f) {
        for (Apple apple : inventory) {
            String output = f.accept(apple);
            System.out.println(output);
        }
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

        @Override
        public String toString() {
            return "Apple{" +
                    "weight=" + weight +
                    ", color=" + color +
                    '}';
        }
    }
}
