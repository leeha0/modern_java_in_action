package chapter3;

import chapter3.function.Action;

public class Ex10_CastingFunctionalInterface {

    public static void main(String[] args) {
        // 어떤 메서드를 호출하는지 명확하지 않음
        // execute(() -> {});

        // 람다 캐스트를 통해 명시적으로 구분
        execute((Runnable) () -> {
        });

        execute((Action) () -> {
        });
    }

    public static void execute(Runnable runnable) {
        runnable.run();
    }

    public static void execute(Action action) {
        action.act();
    }
}
