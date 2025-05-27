public class VirtualThreadDemo {
    public static void main(String[] args) {
        for (int i = 1; i <= 100000; i++) {
            new Thread(() -> System.out.println("Hello from thread " + Thread.currentThread())).start();
        }
    }
}
