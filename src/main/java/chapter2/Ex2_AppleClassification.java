package chapter2;

import static chapter2.Ex2_AppleClassification.Color.*;

public class Ex2_AppleClassification {

    class AppleHeavyWeightPredicate implements Ex2_ApplePredicate {

        @Override
        public boolean test(Ex1_AppleClassification.Apple apple) {
            return apple.getWeight() > 150;
        }
    }

    class AppleGreenColorPredicate implements Ex2_ApplePredicate {

        @Override
        public boolean test(Ex1_AppleClassification.Apple apple) {
            return GREEN.equals(apple.getColor());
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
    }

    enum Color {
        GREEN,
        RED;
    }
}
