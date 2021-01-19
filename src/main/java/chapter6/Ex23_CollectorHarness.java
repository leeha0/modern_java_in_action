package chapter6;

import static chapter6.Ex22_OptimizeCustomCollector.partitionPrimes;
import static chapter6.Ex23_TakeWhileForJava8.partitionPrimesWithCustomCollector;

public class Ex23_CollectorHarness {

    public static void main(String[] args) {
        partitioningByHarness();
        partitioningByWithCustomCollectorHarness();
    }

    private static void partitioningByHarness() {
        long fastest = Long.MAX_VALUE;
        for (long i = 0; i < 20; i++) {
            long start = System.nanoTime();
            partitionPrimes(1_000_000); // 백만 개의 숫자를 소수와 비소수로 분할한다.
            long duration = (System.nanoTime() - start) / 1_000_000;
            if (duration < fastest) { // 가장 빠른 케이스를 기록
                fastest = duration;
            }
        }

        System.out.println("Fastest execution done in " + fastest + " msecs (partitioningByHarness)");
        // Fastest execution done in 307 msecs (partitioningByHarness)
    }

    // 32 프로의 성능 향상 ..?
    private static void partitioningByWithCustomCollectorHarness() {
        long fastest = Long.MAX_VALUE;
        for (long i = 0; i < 20; i++) {
            long start = System.nanoTime();
            partitionPrimesWithCustomCollector(1_000_000); // 백만 개의 숫자를 소수와 비소수로 분할한다.
            long duration = (System.nanoTime() - start) / 1_000_000;
            if (duration < fastest) { // 가장 빠른 케이스를 기록
                fastest = duration;
            }
        }

        System.out.println("Fastest execution done in " + fastest + " msecs (partitioningByWithCustomCollectorHarness)");
        // Fastest execution done in 280 msecs (partitioningByWithCustomCollectorHarness)
    }
}
