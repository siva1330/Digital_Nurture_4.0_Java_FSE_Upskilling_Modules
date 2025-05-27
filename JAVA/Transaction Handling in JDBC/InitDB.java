import java.sql.*;

public class InitDB {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:sqlite:bank.db";
        Class.forName("org.sqlite.JDBC");
        try (Connection conn = DriverManager.getConnection(url)) {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS accounts (id INTEGER PRIMARY KEY, balance INTEGER)");
            stmt.executeUpdate("INSERT OR IGNORE INTO accounts (id, balance) VALUES (1, 1000), (2, 1000)");
            System.out.println("Database initialized.");
        }
    }
} 