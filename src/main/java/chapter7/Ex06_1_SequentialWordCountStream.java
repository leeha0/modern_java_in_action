package chapter7;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex06_1_SequentialWordCountStream {

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
        Ex06_1_SequentialWordCounter wordCounter = stream.collect(
            () -> new Ex06_1_SequentialWordCounter(0, true), // 누적자
            (Ex06_1_SequentialWordCounter counter, Character c) -> {           // 누적자, 요소
                if (Character.isWhitespace(c)) {
                    counter.setLastSpace(true);
                } else {
                    if (counter.isLastSpace()) {
                        counter.addCounter(1, false);
                    }
                }
            },
            (counter1, counter2) -> {                                          // 누적자 병합
                counter1.addCounter(counter2.getCounter(), false);
            }
        );
        return wordCounter.getCounter();
    }
}
