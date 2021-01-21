package chapter7;

import java.util.stream.Stream;

public class Ex01_SequentialSum {

    public static void main(String[] args) {
        System.out.println("sequentialSum(10) = " + sequentialSum(10));
    }

    public static long sequentialSum(long n) {
        // 무한 스트림
        return Stream.iterate(1L, i -> i + 1)
            .limit(n)
            .reduce(0L, Long::sum);
    }

    public static long traditionalSequentialSum(long n) {
        // n 이 커진다면 병렬 처리를 고려해야 한다.
        long result = 0;
        for (long i = 1L; i <= n; i++) {
            result += i;
        }
        return result;
    }
}
