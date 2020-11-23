package chapter3;

import java.util.ArrayList;
import java.util.List;

public class Ex6_Autoboxing {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 300; i < 400; i++) {
            list.add(i); // 오토박싱
        }
    }
}
