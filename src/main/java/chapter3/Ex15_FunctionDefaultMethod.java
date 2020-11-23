package chapter3;

import java.util.function.Function;

import org.omg.PortableInterceptor.INACTIVE;

public class Ex15_FunctionDefaultMethod {

    public static void main(String[] args) {
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> h1 = f.andThen(g);
        Function<Integer, Integer> h2 = f.compose(g);

        int result1 = h1.apply(1);
        System.out.println(result1); // g(f(x)) = (x+1) * 2 = 4

        int result2 = h2.apply(1);
        System.out.println(result2); // f(g(x)) = (x*2) + 1 = 3
    }
}
