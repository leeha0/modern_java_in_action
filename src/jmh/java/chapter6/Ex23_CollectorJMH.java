package chapter6;

import static chapter6.Ex22_OptimizeCustomCollector.partitionPrimes;
import static chapter6.Ex23_TakeWhileForJava8.partitionPrimesWithCustomCollector;

import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;

public class Ex23_CollectorJMH {

    private static final int N = 1_000_000;

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void partitioningBy() {
        // 백만 개의 숫자를 소수와 비소수로 분할한다.
        partitionPrimes(N);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void partitioningByWithCustomCollector() {
        // 백만 개의 숫자를 소수와 비소수로 분할한다.
        partitionPrimesWithCustomCollector(N);
    }
}
