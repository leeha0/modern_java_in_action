package chapter5;

import java.util.Arrays;

public class Ex26_ArraysStream {

    public static void main(String[] args) {
        int[] numbers = {2, 3, 5, 7, 11, 13};
        int sum = Arrays.stream(numbers).sum();

        System.out.println(sum);
    }
}
