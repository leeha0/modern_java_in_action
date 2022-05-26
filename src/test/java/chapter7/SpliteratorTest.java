package chapter7;

import static org.assertj.core.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class SpliteratorTest {

    @Test
    void collectionSpliteratorTest() {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        LinkedList<Integer> linkedList = new LinkedList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Stream<Integer> integerStream = list
            .parallelStream();

        integerStream.forEach(i -> {
            Thread.dumpStack();
        });

        Spliterator<Integer> spliterator = integerStream.spliterator();
        System.out.println(spliterator.getClass());

        long estimateSize = spliterator.estimateSize(); // 1 to 9
        spliterator.tryAdvance(System.out::println);
        spliterator.tryAdvance(System.out::println);
        spliterator.tryAdvance(System.out::println);
        spliterator.tryAdvance(System.out::println);
        spliterator.tryAdvance(System.out::println);
        spliterator.tryAdvance(System.out::println);
        spliterator.tryAdvance(System.out::println);
        spliterator.tryAdvance(System.out::println);

        Spliterator<Integer> subSpliterator = spliterator.trySplit(); // 10
        long estimateSize2 = subSpliterator.estimateSize();
        spliterator.tryAdvance(System.out::println);
        subSpliterator.tryAdvance(System.out::println);

        assertThat(estimateSize).isEqualTo(10);
        assertThat(estimateSize2).isEqualTo(1);
    }
}
