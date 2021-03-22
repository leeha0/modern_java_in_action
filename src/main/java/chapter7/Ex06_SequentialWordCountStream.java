package chapter7;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex06_SequentialWordCountStream {

    private static final String SENTENCE =
        "Nel   mezzo del cammi di nostra vita "
            + "mi ritrovai in una  selva oscura "
            + "ch la dritta via era smarrita ";

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
            new Ex06_SequentialWordCounter(0, true),      // 초깃값
            Ex06_SequentialWordCounter::accumulate,                         // 변환 함수
            Ex06_SequentialWordCounter::combine                             // BinaryOperator(병합)
        );
        return wordCounter.getCounter();
    }

    public int countWords3(Stream<Character> stream) {
        Ex06_SequentialWordCounter wordCounter = stream.reduce(
            new Ex06_SequentialWordCounter(0, true),       // 초깃값
            accumulateInterface(),                                           // 변환 함수
            combineInterface()                                               // BinaryOperator(병합)
        );
        return wordCounter.getCounter();
    }

    private BiFunction<Ex06_SequentialWordCounter, Character, Ex06_SequentialWordCounter> accumulateInterface() {
        return (T, U) -> {
            // R
            return null;
        };
    }

    private BinaryOperator<Ex06_SequentialWordCounter> combineInterface() {
        return (T1, T2) -> {
            // T3
            return null;
        };
    }
}
