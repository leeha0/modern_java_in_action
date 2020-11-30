package chapter5;

import static java.util.stream.Collectors.*;

import java.util.List;

import chapter4.model.Dish;

public class Ex1_PredicateFilter {

    public static void main(String[] args) {
        List<Dish> menu = Dish.dishes();

        List<Dish> vegetarianMenu = menu.stream()
            .filter(Dish::isVegetarian)
            .collect(toList());

        System.out.println(vegetarianMenu.toString());
    }
}
