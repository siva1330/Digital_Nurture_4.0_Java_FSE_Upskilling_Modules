public class BytecodeDemo {
    public int square(int x) {
        return x * x;
    }

    public static void main(String[] args) {
        BytecodeDemo demo = new BytecodeDemo();
        System.out.println(demo.square(5));
    }
}
