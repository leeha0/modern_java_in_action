package chapter1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ex1_AppleWeightSort {

    public static void main(String[] args) {
        ArrayList<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(1));
        inventory.add(new Apple(2));
        inventory.add(new Apple(3));

        traditionalSort(inventory);
        modernSort(inventory);
    }

    public static void modernSort(List<Apple> inventory) {
        inventory.sort(Comparator.comparing(Apple::getWeight));
    }

    public static void traditionalSort(List<Apple> inventory) {
        Collections.sort(inventory, new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });
    }

    static class Apple {
        Integer weight;

        public Apple(Integer weight) {
            this.weight = weight;
        }

        public Integer getWeight() {
            return weight;
        }
    }
}
