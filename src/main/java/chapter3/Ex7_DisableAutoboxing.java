package chapter3;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class Ex7_DisableAutoboxing {

    public static void main(String[] args) {
        IntPredicate evenNumbers = (int i) -> i % 2 == 0;
        boolean evenNumbersTest = evenNumbers.test(1000);// 박싱하지 않음 (int -> Integer)
        System.out.println(evenNumbersTest);

        Predicate<Integer> oddNumbers = (Integer i) -> i % 2 != 0;
        boolean oddNumbersTest = oddNumbers.test(1000);// 박싱
        System.out.println(oddNumbersTest);
    }
}
