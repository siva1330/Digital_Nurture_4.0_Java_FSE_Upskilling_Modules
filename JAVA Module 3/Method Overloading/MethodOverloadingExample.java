public class MethodOverloadingExample {

    public static int add(int a, int b) {
        return a + b;
    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        System.out.println("Sum of 2 ints: " + add(3, 5));
        System.out.println("Sum of 2 doubles: " + add(2.5, 4.5));
        System.out.println("Sum of 3 ints: " + add(1, 2, 3));
    }
}
