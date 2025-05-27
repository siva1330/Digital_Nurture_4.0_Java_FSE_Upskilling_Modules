import java.sql.*;

public class TransactionDemo {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:bank.db";

        try {
            // Explicitly load the SQLite JDBC driver
            Class.forName("org.sqlite.JDBC");
            try (Connection conn = DriverManager.getConnection(url)) {
                conn.setAutoCommit(false);

                Statement stmt = conn.createStatement();
                stmt.executeUpdate("UPDATE accounts SET balance = balance - 500 WHERE id = 1");
                stmt.executeUpdate("UPDATE accounts SET balance = balance + 500 WHERE id = 2");

                conn.commit();
                System.out.println("Transaction completed successfully.");
            }
        } catch (Exception e) {
            System.out.println("Transaction failed: " + e.getMessage());
        }
    }
}
