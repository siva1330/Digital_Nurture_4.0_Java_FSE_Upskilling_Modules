import java.util.*;
import java.util.stream.Collectors;

public class StreamEvenFilter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        System.out.print("Enter the number of elements: ");
        int count = sc.nextInt();

        System.out.println("Enter " + count + " integers:");
        for (int i = 0; i < count; i++) {
            numbers.add(sc.nextInt());
        }

        List<Integer> evenNumbers = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());

        System.out.println("Even numbers: " + evenNumbers);
    }
}

