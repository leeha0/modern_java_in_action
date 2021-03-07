package chapter7;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class Ex04_ForkJoinSum {

    public static void main(String[] args) {
        long n = 10_000_000L;
        long summing = forkJoinSum(n);
        System.out.println("summing = " + summing);
    }

    public static long forkJoinSum(long n) {
        long[] numbers = LongStream.rangeClosed(1, n).toArray();
        ForkJoinTask<Long> task = new Ex04_ForkJoinSumCalculator(numbers);
        // invoke 메서드의 결과는 ForkJoinSumCalculator 태스크의 결과이다.
        // 일반적으로 애플리케이션에서는 둘 이상의 ForkJoinPool을 사용하지 않는다.
        // 정적 필드에 싱글턴으로 저장하여 사용한다.
        return new ForkJoinPool().invoke(task);
    }
}
