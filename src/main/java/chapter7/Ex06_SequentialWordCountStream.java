package chapter7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Spliterator;
import java.util.stream.Collectors;
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
        // IntStream.range: RangeIntSpliterator 사용 (1개 미만이 될 때까지 분할)
        System.out.println("Found " + parallelWordCount + " words");
        // Found 38 words
        // 스트림 분할 위치에 따라 하나의 단어가 둘로 계산되는 상황 발생
    }

    public static int countWords(Stream<Character> stream) {
        Ex06_SequentialWordCounter wordCounter = stream.reduce(
            new Ex06_SequentialWordCounter(0, true),       // 초깃값
            Ex06_SequentialWordCounter::accumulate,                         // BiFunction (변환 함수)
            Ex06_SequentialWordCounter::combine                             // BinaryOperator(병합)
        );
        return wordCounter.getCounter();
    }
}
