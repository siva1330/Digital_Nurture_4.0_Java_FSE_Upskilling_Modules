public class TypeCastingExample {
    public static void main(String[] args) {
        double doubleValue = 9.78;
        int intValue = (int) doubleValue;  // explicit casting

        int num = 10;
        double doubleFromInt = num;  // implicit casting

        System.out.println("Double value: " + doubleValue);
        System.out.println("Converted to int: " + intValue);
        System.out.println("Int value: " + num);
        System.out.println("Converted to double: " + doubleFromInt);
    }
}
