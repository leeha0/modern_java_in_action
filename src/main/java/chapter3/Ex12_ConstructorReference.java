package chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Ex12_ConstructorReference {

    public static void main(String[] args) {
        List<Integer> weights = Arrays.asList(7, 3, 4, 10);
        List<Apple> apples = map(weights, Apple::new);
        System.out.println(apples.toString());
    }

    public static List<Apple> map(List<Integer> list, Function<Integer, Apple> f) {
        List<Apple> result = new ArrayList<>();
        for (Integer i : list) {
            result.add(f.apply(i));
        }
        return result;
    }

    private static class Apple {

        int weight;

        public Apple(int weight) {
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Apple{" +
                "weight=" + weight +
                '}';
        }
    }
}
