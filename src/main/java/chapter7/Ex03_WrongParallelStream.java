package chapter7;

import java.util.stream.LongStream;

public class Ex03_WrongParallelStream {

    public static void main(String[] args) {
        long n = 10_000_000L;

        long summing = sideEffectSum(n);
        System.out.println("summing = " + summing);

        long parallelSumming = sideEffectParallelSum(n);
        System.out.println("parallelSumming = " + parallelSumming);
    }

    public static long sideEffectSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n) // 1-100 숫자 스트림 생성
            .forEach(accumulator::add);
        return accumulator.total;
    }

    public static long sideEffectParallelSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n)
            .parallel()
            .forEach(accumulator::add);
        return accumulator.total;
    }

    public static class Accumulator {

        // 공유된 상태, 데이터 레이스 문제 발생
        // 동기화로 문제를 해결할 경우 병렬화의 특성이 사라지는 문제 존재
        public long total = 0;

        public void add(long value) {
            total += value;
        }
    }
}
