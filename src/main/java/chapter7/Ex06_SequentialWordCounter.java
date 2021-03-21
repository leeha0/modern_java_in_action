package chapter7;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex06_SequentialWordCounter {
    // 불변 클래스 정의

    private static final String SENTENCE =
        "Nel   mezzo del cammi di nostra vita "
            + "mi ritrovai in una  selva oscura "
            + "ch la dritta via era smarrita ";

    private final int counter;
    private final boolean lastSpace;

    public static void main(String[] args) {
        Stream<Character> stream = IntStream.range(0, SENTENCE.length())
            .mapToObj(SENTENCE::charAt);
        int sequentialWordCount = countWords(stream);
        System.out.println("Found " + sequentialWordCount + " words");
        // Found 19 words

        int parallelWordCount = countWords(stream.parallel());
        System.out.println("Found " + parallelWordCount + " words");
        // Found 38 words
        // 스트림 분할 위치에 따라 하나의 단어가 둘로 계산되는 상황 발생
    }

    public static int countWords(Stream<Character> stream) {
        Ex06_SequentialWordCounter wordCounter = stream.reduce(
            new Ex06_SequentialWordCounter(0, true),       // 초깃값
            Ex06_SequentialWordCounter::accumulate,                         // 변환 함수
            Ex06_SequentialWordCounter::combine                             // BinaryOperator(병합)
        );
        return wordCounter.getCounter();
    }

    public Ex06_SequentialWordCounter(int counter, boolean lastSpace) {
        this.counter = counter;
        this.lastSpace = lastSpace;
    }

    // 새로운 문자를 찾을 때마다 호출
    public Ex06_SequentialWordCounter accumulate(Character c) {
        if (Character.isWhitespace(c)) {
            return lastSpace ? this : new Ex06_SequentialWordCounter(counter, true);
        } else {
            // 공백 문자 발견 시 단어 수 증가
            return lastSpace ? new Ex06_SequentialWordCounter(counter + 1, false) : this;
        }
    }

    public Ex06_SequentialWordCounter combine(Ex06_SequentialWordCounter wordCounter) {
        return new Ex06_SequentialWordCounter(counter + wordCounter.counter, wordCounter.lastSpace);
    }

    public int getCounter() {
        return counter;
    }
}
