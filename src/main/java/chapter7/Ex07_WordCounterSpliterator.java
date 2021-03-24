package chapter7;

import java.util.Spliterator;
import java.util.function.Consumer;

public class Ex07_WordCounterSpliterator implements Spliterator<Character> {

    private final String string;
    private int currentChar = 0;

    public Ex07_WordCounterSpliterator(String string) {
        this.string = string;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Character> action) {
        // 요소를 순차적으로 소비하며 소비할 요소가 남아있으면 참을 반환
        // 요소 소비 (현재 인덱스에 해당하는 문자를 제공하고 인덱스 증가)
        action.accept(string.charAt(currentChar++));
        // 다음 요소 존재 여부 반환
        return currentChar < string.length();
    }

    @Override
    public Spliterator<Character> trySplit() {
        // 요소를 분할하여 또 다른 Spliterator를 생성
        // RecursiveTask 의 compute 메서드와 동일한 역할
        int currentSize = string.length();

        // 분할 여부 확인
        if (currentSize < 10) {
            // 분할 중지
            return null;
        }

        // 분할
        for (int splitPos = currentSize / 2 + currentChar; splitPos < string.length(); splitPos++) {
            // 분할 조건 설정 (기준 문자가 공백일 경우 분할 발생)
            if (Character.isWhitespace(string.charAt(splitPos))) {
                // Spliterator 생성
                Spliterator<Character> spliterator =
                    new Ex07_WordCounterSpliterator(string.substring(currentChar, splitPos));
                currentChar = splitPos;
                return spliterator;
            }
        }
        // 분할 중지
        return null;
    }

    @Override
    public long estimateSize() {
        // 탐색해야 할 요소 수 제공
        return string.length() - currentChar;
    }

    @Override
    public int characteristics() {
        // ORDERED: 문자열 순서가 유의미 함
        // SIZED: 요소 수를 정확하게 알 수 있음 (= 정확한 크기를 갖음)
        // SUBSIZED: 서브 Spliterator의 요소 수를 정확하게 알 수 있음
        // NONNULL: null 요소가 존재하지 않음
        // IMMUTABLE: 문자열 자체가 불변 클래스이므로 요소는 불변 함
        return ORDERED + SIZED + SUBSIZED + NONNULL + IMMUTABLE;
    }
}
