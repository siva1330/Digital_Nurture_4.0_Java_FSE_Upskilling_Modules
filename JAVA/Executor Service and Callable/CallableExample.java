import java.util.concurrent.*;
import java.util.*;

public class CallableExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<Callable<String>> tasks = List.of(
            () -> "Task 1 result",
            () -> "Task 2 result",
            () -> "Task 3 result"
        );

        List<Future<String>> results = executor.invokeAll(tasks);

        for (Future<String> f : results) {
            System.out.println(f.get());
        }

        executor.shutdown();
    }
}
