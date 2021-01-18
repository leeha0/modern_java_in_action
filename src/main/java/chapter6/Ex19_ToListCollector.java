package chapter6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class Ex19_ToListCollector<T> implements Collector<T, List<T>, List<T>> {

    @Override
    public Supplier<List<T>> supplier() {
        // 수집 연산의 시발점
        // 초기 빈 결과 생성
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<T>, T> accumulator() {
        // 탐색한 항목을 누적하고 바로 누적자를 고친다.
        // 리듀싱 연산
        return List::add;
    }

    @Override
    public BinaryOperator<List<T>> combiner() {
        // 두 번째 콘텐츠와 합쳐서 첫 번째 누적자를 고친다.
        return (list1, list2) -> {
            // 변경된 첫 번재 누적자를 반환한다.
            list1.addAll(list2);
            return list1;
        };
    }

    @Override
    public Function<List<T>, List<T>> finisher() {
        // 최종 결과 변환
        // 리듀싱 결과가 곧 최종 결과 이므로 항등 함수 반환
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        // 컬렉터의 플래그를 IDENTITY_FINISH, CONCURRENT로 설정
        // 요소의 순서가 무의미 해야 병렬 처리가 가능하다.
        return Collections.unmodifiableSet(
            EnumSet.of(
                Collector.Characteristics.UNORDERED,
                Collector.Characteristics.CONCURRENT,
                Collector.Characteristics.IDENTITY_FINISH
            ));
    }
}
