package chapter3;

import java.security.PrivilegedAction;
import java.util.Comparator;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.ToIntBiFunction;

import chapter2.model.Apple;

public class Ex9_CompatibleFunctionalInterface {

    public static void main(String[] args) {
        // () -> T
        Callable<Integer> c = () -> 42;
        PrivilegedAction<Integer> p = () -> 42;

        // 동일한 람다 표현식을 여러 인터페이스에서 사용 가능
        Comparator<Apple> c1 =
            (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
        ToIntBiFunction<Apple, Apple> c2 =
            (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
        BiFunction<Apple, Apple, Integer> c3 =
            (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
    }
}
