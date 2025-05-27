public class OperatorPrecedence {
    public static void main(String[] args) {
        int result = 10 + 5 * 2; // Multiplication happens before addition
        int corrected = (10 + 5) * 2; // Parentheses change the order

        System.out.println("Without parentheses: " + result);
        System.out.println("With parentheses: " + corrected);
    }
}
