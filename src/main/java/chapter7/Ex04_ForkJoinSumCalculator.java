package chapter7;

import java.util.concurrent.RecursiveTask;

public class Ex04_ForkJoinSumCalculator extends RecursiveTask<Long> {

    private final long[] numbers;
    private final int start;
    private final int end;
    public static final long THRESHOLD = 10_000L;

    public Ex04_ForkJoinSumCalculator(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    public Ex04_ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end - start;

        // if (태스크가 충분히 작거나 더 이상 분할할 수 없으면) {
        if (length <= THRESHOLD) {
            // 순차적으로 태스트 계산
            return computeSequentially();
        }

        // 태스크를 두 서브태스크로 분할
        Ex04_ForkJoinSumCalculator leftTask =
            new Ex04_ForkJoinSumCalculator(numbers, start, start + length / 2);
        // ForkJoinPool 의 다른 스레드로 새로 생성한 태스크를 비동기로 실행
        leftTask.fork();

        Ex04_ForkJoinSumCalculator rightTask =
            new Ex04_ForkJoinSumCalculator(numbers, start + length / 2, end);
        // 태스크가 다시 서브태스크로 분할되도록 이 메서드를 재귀적으로 호출함
        // 두 번째 서브태스크를 동기 실행한다. 추가로 분할이 일어난다.
        Long rightResult = rightTask.compute();
        // 모든 서브태스크의 연산이 완료될 때까지 기다림
        // 첫 번째 서브태스크 결과를 읽거나 아직 결과가 없으면 기다린다.
        Long leftResult = leftTask.join();

        // 각 서브태스크의 결과를 합침
        // 두 서브태스크의 결과를 조합한 값이 이 태스크의 결과다.
        return leftResult + rightResult;
    }

    private long computeSequentially() {
        // 더 분할할 수 없을때 서브태스크의 결과를 계산하는 단순한 알고리즘
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    /**
     * RecursiveTask compute 메서드 (분할 정복 알고리즘 기반)
     * if (태스크가 충분히 작거나 더 이상 분할할 수 없으면) {
     *     순차적으로 태스트 계산
     * } else {
     *     태스크를 두 서브태스크로 분할
     *     태스크가 다시 서브태스크로 분할되도록 이 메서드를 재귀적으로 호출함
     *     모든 서브태스크의 연산이 완료될 때까지 기다림
     *     각 서브태스크의 결과를 합침
     * }
     */
}
