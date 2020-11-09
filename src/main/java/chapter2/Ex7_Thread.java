package chapter2;

public class Ex7_Thread {

    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world");
            }
        });

        // 람다 표현
        Thread t2 = new Thread(() -> System.out.println("Hello world"));
    }
}
