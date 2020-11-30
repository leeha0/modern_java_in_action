package chapter4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import chapter4.model.Dish;

public class Ex3_ExternalIteration {

    public static void main(String[] args) {
        List<Dish> menu = Dish.dishes();

        // for-each 외부 반복
        List<String> names = new ArrayList<>();
        for (Dish dish : menu) {
            names.add(dish.getName());
        }

        // iterator 외부 반복
        // List<String> names = new ArrayList<>();
        Iterator<Dish> iterator = menu.iterator();
        while (iterator.hasNext()) {
            Dish dish = iterator.next();
            names.add(dish.getName());
        }

        System.out.println(names.toString());
    }
}
