package chapter6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StackOverflow_ConcurrentCollector {

    public static void main(String[] args) {
        // 데이터 소스
        // 병렬로 수행할 경우 데이터 소스를 청크로 분할한다. 이때, 데이터 소스는 복제가 이루어지기 때문에
        // Thread-Safe 하지 않아도 무관하다.
        List<Integer> list =
            Collections.synchronizedList(new ArrayList<>(Arrays.asList(1, 2, 4, 4)));

        // 예제 1: 병렬 + 동시, Thread-Safe
        // 키 함수, 값 함수, 머지 함수
        // 중복 키가 많은 경우 동기화된 Map 사용시 성능 이슈가 있을 수 있다.
        Map<Integer, Integer> collect1 = list.stream().parallel()
            .collect(Collectors.toConcurrentMap(k -> k, v -> v, Integer::sum));
        System.out.println("collect1 = " + collect1);
        // collect1 = {1=1, 2=2, 4=8}

        // 예제 2: 병렬, Thread-Safe (Thread-Safe 하지 않은 누적자를 사용하여 accumulator 가 동시에 수행되지 않기 때문)
        // 유니크한 키가 많을 경우 머지 작업시 성능 이슈가 있을 수 있다.
        Map<Integer, Integer> collect2 = list.stream().parallel()
            .collect(Collectors.toMap(k -> k, v -> v, Integer::sum));
        System.out.println("collect2 = " + collect2);
        // collect2 = {1=1, 2=2, 4=8}
    }
}
