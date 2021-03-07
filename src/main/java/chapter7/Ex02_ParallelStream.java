package chapter7;

import java.util.stream.Stream;

public class Ex02_ParallelStream {

    public static void main(String[] args) {
        System.out.println("parallelSum(10) = " + parallelSum(10));
        System.out.println("Runtime.getRuntime().availableProcessors() = " + Runtime.getRuntime().availableProcessors());

        System.setProperty("java.util.concurrent.ForJoinPool.common.parallelism", "12");
    }

    public static long parallelSum(long n) {
        // 스트림을 병렬 스트림으로 변환
        return Stream.iterate(1L, i -> i + 1)
            .limit(n)
            .parallel()
            .reduce(0L, Long::sum);
    }

    public static long combinationSum(long n) {
        /**
         * stream.parallel()
         *      .filter()
         *      .sequential()
         *      .map()
         *      .parallel() // 마지막에 호출한 메서드 적용
         *      .reduce();
         */

        return 0L;
    }
}
