package chapter6;

import static chapter6.Ex23_TakeWhileForJava8.isPrime;
import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class Ex23_PrimeNumbersCollector implements
    Collector<Integer, Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> {

    @Override
    public Supplier<Map<Boolean, List<Integer>>> supplier() {
        // 누적자 반환
        return () -> new HashMap<>() {{
            put(true, new ArrayList<>()); // 소수
            put(false, new ArrayList<>()); // 비소수
        }};
    }

    @Override
    public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
        // 스트림의 요소를 어떻게 수집할지 결정하는 메서드
        // 최적화의 핵심
        return (Map<Boolean, List<Integer>> acc, Integer candidate) -> {
            acc.get(isPrime(acc.get(true), candidate))
                .add(candidate);
        };
    }

    @Override
    public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
        // 병렬 수집 과정에서 두 부분의 누적자를 합칠 수 있는 메서드
        // 알고리즘 자체가 순차적이라 컬렉터는 병렬로 실행되지 않는다
        // 빈구현 or UnsupportedOperationException 을 예외로 던지도록 구현한다
        return (Map<Boolean, List<Integer>> map1, Map<Boolean, List<Integer>> map2) -> {
            map1.get(true).addAll(map2.get(true));
            map1.get(false).addAll(map2.get(false));
            return map1;
        };
    }

    @Override
    public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
        // 최종 결과를 반환하는 메서드
        // 누적자가 곧 결과라면 항등 함수를 리턴
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        // UNORDERED, CONCURRENT를 지원하지 않는 알고리즘
        return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH));
    }
}
