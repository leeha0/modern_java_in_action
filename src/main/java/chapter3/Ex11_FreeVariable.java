package chapter3;

public class Ex11_FreeVariable {

    public static void main(String[] args) {
        int portNumber = 1337;
        Runnable r = () -> System.out.println(portNumber); // 람다 캡처링
        // portNumber = 31337; // 재할당 불가
    }
}
