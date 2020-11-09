package chapter2;

import java.util.concurrent.*;

public class Ex8_ExecutorService {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        // submit: Callable, Runnable 인터페이스를 인자로 받음
        Future<String> threadName = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return Thread.currentThread().getName();
            }
        });

        // 람다 표현식
        Future<String> threadName2 = executorService.submit(() -> Thread.currentThread().getName());
    }
}
