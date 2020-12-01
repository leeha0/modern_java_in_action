package chapter5;

import chapter4.model.Dish;

public class Ex10_AnyMatch {

    public static void main(String[] args) {
        if (Dish.dishes().stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("The menu is (somewhat) vegetarian friendly!!");
        }
    }
}
