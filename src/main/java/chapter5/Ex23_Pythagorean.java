package chapter5;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex23_Pythagorean {

    public static void main(String[] args) {
        createAB();
        createImproveAB();
    }

    private static void createAB() {
        // 제곱근을 두번 계산
        Stream<int[]> pythagoreanTriples1 = IntStream.rangeClosed(1, 100).boxed()
            .flatMap(a -> IntStream.rangeClosed(a, 100)
                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}));
        pythagoreanTriples1.limit(5)
            .forEach(results -> prettyPrint(results[0], results[1], results[2]));
    }

    private static void createImproveAB() {
        Stream<double[]> pythagoreanTriples2 = IntStream.rangeClosed(1, 100).boxed()
            .flatMap(a -> IntStream.rangeClosed(1, 100)
                .mapToObj(b -> new double[]{a, b, Math.sqrt(a * a + b * b)})
                .filter(t -> t[2] % 1 == 0));
        pythagoreanTriples2.limit(5)
            .forEach(results -> prettyPrint(results[0], results[1], results[2]));
    }

    private static void createB() {
        int a = 3;
        IntStream.rangeClosed(1, 100)
            .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
            .boxed()
            .map(b -> new int[]{a, b, (int) Math.sqrt((a * a + b * b))})
            .forEach(results -> prettyPrint(results[0], results[1], results[2]));

        IntStream.rangeClosed(1, 100)
            .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
            .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
            .forEach(results -> prettyPrint(results[0], results[1], results[2]));
    }

    private static void prettyPrint(Number a, Number b, Number c) {
        System.out.println("(" + a + " * " + a + ") + (" + b + " * " + b + ") = (" + c + " * " + c + ")");
    }

    private static void info() {
        // 피타고라스 정의: a * a + b * b = c * c
        int a = 4;
        int b = 6;
        System.out.println("(a * a + b * b) 제곱근이 정수 입니까? " + (Math.sqrt(a * a + b * b) % 1 == 0));

        // 부동 소수점 수라면 x % 1.0은 소수점 이하 부분을 얻을 수 있다.
        System.out.println(5.6 % 1.0); // 0.5999999999999996
        System.out.println(5.6 % 1); // 0.5999999999999996
    }
}
