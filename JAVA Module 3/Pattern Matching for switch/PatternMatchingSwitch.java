public class PatternMatchingSwitch {
    public static void printType(Object obj) {
        // Replaced pattern matching switch with if-else and instanceof
        if (obj instanceof Integer i) {
            System.out.println("Integer: " + i);
        } else if (obj instanceof String s) {
            System.out.println("String: " + s);
        } else if (obj instanceof Double d) {
            System.out.println("Double: " + d);
        } else {
            System.out.println("Unknown type");
        }
    }

    public static void main(String[] args) {
        printType(42);
        printType("Java");
        printType(3.14);
        printType(true);
    }
}
