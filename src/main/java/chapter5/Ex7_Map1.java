package chapter5;

import static java.util.stream.Collectors.*;

import java.util.List;

import chapter4.model.Dish;

public class Ex7_Map1 {

    public static void main(String[] args) {
        List<String> dishNames = Dish.dishes().stream()
            .map(Dish::getName)
            .collect(toList());

        System.out.println(dishNames.toString());
    }
}
