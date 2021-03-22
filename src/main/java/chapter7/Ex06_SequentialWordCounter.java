package chapter7;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class Ex06_SequentialWordCounter {

    // 불변 클래스 정의
    private final int counter;
    private final boolean lastSpace;

    public Ex06_SequentialWordCounter(int counter, boolean lastSpace) {
        this.counter = counter;
        this.lastSpace = lastSpace;
    }

    // 새로운 문자를 찾을 때마다 호출
    // TODO BiFunction 시그니처가 일치하지 않는데 시그니처가 일치하는 이유 ?
    public Ex06_SequentialWordCounter accumulate(Character c) {
        if (Character.isWhitespace(c)) {
            return lastSpace ? this : new Ex06_SequentialWordCounter(counter, true);
        } else {
            // 공백 문자 발견 시 단어 수 증가
            return lastSpace ? new Ex06_SequentialWordCounter(counter + 1, false) : this;
        }
    }

    // TODO wordCounter = Identity
    private BiFunction<Ex06_SequentialWordCounter, Character, Ex06_SequentialWordCounter> accumulateInterface() {
        return (wordCounter, c) -> {
            if (Character.isWhitespace(c)) {
                return lastSpace ? this : new Ex06_SequentialWordCounter(counter, true);
            } else {
                // 공백 문자 발견 시 단어 수 증가
                return lastSpace ? new Ex06_SequentialWordCounter(counter + 1, false) : this;
            }
        };
    }

    // TODO BinaryOperator 시그니처가 일치하지 않는데 시그니처가 일치하는 이유 ?
    public Ex06_SequentialWordCounter combine(Ex06_SequentialWordCounter wordCounter) {
        return new Ex06_SequentialWordCounter(counter + wordCounter.counter, wordCounter.lastSpace);
    }

    // TODO wordCounter1 = Identity
    private BinaryOperator<Ex06_SequentialWordCounter> combineInterface() {
        return (wordCounter1, wordCounter2) ->
            new Ex06_SequentialWordCounter(counter + wordCounter2.counter, wordCounter2.lastSpace);
    }

    public int getCounter() {
        return counter;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method m = Ex06_SequentialWordCounter.class.getDeclaredMethod("accumulate", Character.class);
        for (Parameter p : m.getParameters()) {
            System.out.printf("name: %s, type: %s%n", p.getName(), p.getType());
        }
    }
}
