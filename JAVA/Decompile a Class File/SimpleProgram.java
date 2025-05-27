public class SimpleProgram {
    private String message;
    private int count;

    public SimpleProgram() {
        this.message = "Hello World";
        this.count = 0;
    }

    public void incrementCount() {
        count++;
    }

    public String getMessage() {
        return message;
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        SimpleProgram program = new SimpleProgram();
        System.out.println("Message: " + program.getMessage());
        
        for (int i = 0; i < 3; i++) {
            program.incrementCount();
        }
        
        System.out.println("Count: " + program.getCount());
    }
} 