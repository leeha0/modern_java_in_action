package chapter7;

import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Ex07_ParallelWordCounter {

    private static final String SENTENCE =
        "Nel   mezzo del cammi di nostra vita "
            + "mi ritrovai in una  selva oscura "
            + "ch la dritta via era smarrita ";

    public static void main(String[] args) {
        Spliterator<Character> spliterator = new Ex07_WordCounterSpliterator(SENTENCE);
        Stream<Character> stream = StreamSupport.stream(spliterator, true);
        int wordCount = countWords(stream);
        System.out.println("Found " + wordCount + " words");
        // Found 19 words
    }

    public static int countWords(Stream<Character> stream) {
        Ex06_SequentialWordCounter wordCounter = stream.reduce(
            new Ex06_SequentialWordCounter(0, true),       // 초깃값
            Ex06_SequentialWordCounter::accumulate,                         // 변환 함수
            Ex06_SequentialWordCounter::combine                             // BinaryOperator(병합)
        );
        return wordCounter.getCounter();
    }
}
