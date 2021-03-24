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
        int wordCount = reducingWordCount(stream);
        System.out.println("Found " + wordCount + " words");
        // Found 19 words
    }

    public static int reducingWordCount(Stream<Character> stream) {
        Ex06_SequentialWordCounter wordCounter = stream.reduce(
            new Ex06_SequentialWordCounter(0, true),       // 초깃값
            Ex06_SequentialWordCounter::accumulate,                         // 변환 함수 (BiFunction)
            Ex06_SequentialWordCounter::combine                             // 병합 (BinaryOperator)
        );
        return wordCounter.getCounter();
    }

    public static int collectingWordCount(Stream<Character> stream) {
        Ex06_1_SequentialWordCounter wordCounter = stream.collect(
            () -> new Ex06_1_SequentialWordCounter(0, true),  // 누적자 초깃값
            (Ex06_1_SequentialWordCounter counter, Character c) -> {           // 누적 (BiConsumer)
                if (Character.isWhitespace(c)) {
                    counter.setLastSpace(true);
                } else {
                    if (counter.isLastSpace()) {
                        counter.addCounter(1, false);
                    }
                }
            },
            (counter1, counter2) -> {                                          // 누적자 병합 (BiConsumer)
                counter1.addCounter(counter2.getCounter(), false);
            }
        );
        return wordCounter.getCounter();
    }
}
