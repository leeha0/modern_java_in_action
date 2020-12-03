package chapter5;

import java.util.stream.Stream;

public class Ex25_StreamOfNullable {

    public static void main(String[] args) {
        // 자바 9 이전에 null읆 명시적으로 확인
        String homeValue = System.getProperty("home");
        Stream<String> homeValueStream1
            = homeValue == null ? Stream.empty() : Stream.of(homeValue);

        Stream<String> homeValueStream2
            = Stream.ofNullable(System.getProperty("home"));

        Stream<String> values = Stream.of("config", "home", "user")
            .flatMap(key -> Stream.ofNullable(System.getProperty(key)));
    }
}
