package chapter5;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex29_StreamGenerator {

    public static void main(String[] args) {
        Stream.generate(Math::random)
            .limit(5)
            .forEach(System.out::println);

        IntStream ones = IntStream.generate(() -> 1);
        ones.limit(3).forEach(System.out::println);

        IntStream tows = IntStream.generate(new IntSupplier() {
            @Override
            public int getAsInt() {
                return 2;
            }
        });
        tows.limit(3).forEach(System.out::println);

        IntSupplier fib = new IntSupplier() {
            private int previous = 0;
            private int current = 1;

            @Override
            public int getAsInt() {
                int oldPrevious = this.previous;
                int nextValue = this.previous + this.current;
                this.previous = this.current;
                this.current = nextValue;

                return oldPrevious;
            }
        };
        IntStream.generate(fib).limit(10).forEach(System.out::println);
    }
}
