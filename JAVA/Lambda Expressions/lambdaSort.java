import java.util.*;

public class lambdaSort {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Zara", "John", "Alex", "Emma");

        // Sort using lambda expression
        Collections.sort(names, (a, b) -> a.compareTo(b));

        System.out.println("Sorted names:");
        for (String name : names) {
            System.out.println(name);
        }
    }
}
