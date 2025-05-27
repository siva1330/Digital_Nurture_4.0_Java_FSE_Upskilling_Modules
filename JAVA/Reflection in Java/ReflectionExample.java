import java.lang.reflect.Method;

class MyClass {
    public void sayHello() {
        System.out.println("Hello from Reflection!");
    }
}

public class ReflectionExample {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("MyClass");
        Object obj = cls.getDeclaredConstructor().newInstance();

        Method method = cls.getDeclaredMethod("sayHello");
        method.invoke(obj);  // Calls sayHello() dynamically
    }
}
