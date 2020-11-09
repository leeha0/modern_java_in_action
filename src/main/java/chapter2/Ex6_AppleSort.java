package chapter2;

import chapter2.model.Apple;

import java.util.ArrayList;
import java.util.Comparator;

import static chapter2.model.Color.GREEN;
import static chapter2.model.Color.RED;

public class Ex6_AppleSort {

    public static void main(String[] args) {
        ArrayList<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(1, GREEN));
        inventory.add(new Apple(2, RED));
        inventory.add(new Apple(3, GREEN));

        // 무게가 작은 순으로 정렬
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });

        inventory.sort((o1, o2) -> o1.getWeight().compareTo(o2.getWeight()));
        inventory.sort(Comparator.comparing(Apple::getWeight));
    }
}
