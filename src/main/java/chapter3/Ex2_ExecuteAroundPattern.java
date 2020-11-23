package chapter3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ex2_ExecuteAroundPattern {

    public static void main(String[] args) throws IOException {
        processFile();
    }

    public static String processFile() throws IOException {
        try (BufferedReader br =
            new BufferedReader(new FileReader("data.txt"))) {
            return br.readLine();
        }
    }
}
