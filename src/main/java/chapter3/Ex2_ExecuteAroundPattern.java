package chapter3;

import chapter3.function.BufferedReaderProcessor;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ex2_ExecuteAroundPattern {

    public static void main(String[] args) throws IOException {
        // 단일 행을 읽을 수 있는 메서드
        String result1 = processFile();

        // 동작 파라미터화: 여러 행을 읽을 수 있는 메서드 전달
        String result2 = processFile((BufferedReader br) -> br.readLine() + br.readLine());
    }

    public static String processFile() throws IOException {
        try (BufferedReader br =
            new BufferedReader(new FileReader("data.txt"))) {
            return br.readLine();
        }
    }

    public static String processFile(BufferedReaderProcessor processor) throws IOException {
        try (BufferedReader br =
            new BufferedReader(new FileReader("data.txt"))) {
            return processor.process(br);
        }
    }
}
