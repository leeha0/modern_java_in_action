package chapter5;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class Ex27_FileStream {

    public static void main(String[] args) {
        long uniqueWords = 0;

        // Stream 인터페이스는 AutoClosable 인터페이스를 구현
        try (Stream<String> lines = Files.lines(Paths.get("/Users/leeha/Workspaces/java-work/modern-java-in-action/src/main/resources/data.txt"), Charset.defaultCharset())) {
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                .distinct()
                .count();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(uniqueWords);
    }
}
