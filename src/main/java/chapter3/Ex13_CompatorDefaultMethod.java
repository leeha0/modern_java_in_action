package chapter3;

import static chapter2.model.Color.*;
import static java.util.Comparator.*;

import java.util.ArrayList;
import java.util.Comparator;

import chapter2.model.Apple;

public class Ex13_CompatorDefaultMethod {

    public static void main(String[] args) {
        ArrayList<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(1, GREEN));
        inventory.add(new Apple(2, RED));
        inventory.add(new Apple(3, GREEN));

        // 비교자 생성
        Comparator<Apple> weightComparator = Comparator.comparing(Apple::getWeight);
        Comparator<Apple> colorComparator = Comparator.comparing(Apple::getColor);

        // 내림차순 정렬
        inventory.sort(weightComparator.reversed());

        // 비교자 연결
        inventory.sort(weightComparator.reversed().thenComparing(colorComparator));
    }
}
