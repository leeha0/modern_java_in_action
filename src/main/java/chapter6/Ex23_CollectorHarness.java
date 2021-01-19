package chapter6;

import static chapter6.Ex22_OptimizeCustomCollector.partitionPrimes;
import static chapter6.Ex23_TakeWhileForJava8.partitionPrimesWithCustomCollector;

import chapter3.function.Action;

public class Ex23_CollectorHarness {

    public static void main(String[] args) {
        int n = 1_000_000;

        Action action1 = () -> partitionPrimes(n);
        // Fastest execution done in 307 msecs
        Action action2 = () -> partitionPrimesWithCustomCollector(n);
        // Fastest execution done in 280 msecs

        testPartitioningBy(action1);
        testPartitioningBy(action2);
    }

    private static void testPartitioningBy(Action action) {
        long fastest = Long.MAX_VALUE;

        for (long i = 0; i < 20; i++) {
            long start = System.nanoTime();
            action.act();
            fastest = getFastestDuration(fastest, start);
        }

        System.out.println("Fastest execution done in " + fastest + " msecs");
    }

    private static long getFastestDuration(long fastest, long start) {
        long duration = (System.nanoTime() - start) / 1_000_000;

        // 가장 빠른 케이스를 기록
        if (duration < fastest) {
            fastest = duration;
        }
        return fastest;
    }
}
