import java.sql.*;

public class QueryStudent {
    public static void main(String[] args) {
        try {
            // Load the SQLite JDBC driver
            Class.forName("org.sqlite.JDBC");
            
            // Connect to the database
            Connection conn = DriverManager.getConnection("jdbc:sqlite:students.db");
            
            // Create a statement
            Statement stmt = conn.createStatement();
            
            // Execute query
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");
            
            // Process results
            System.out.println("Student Records:");
            System.out.println("ID\tName");
            System.out.println("----------------");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println(id + "\t" + name);
            }
            
            // Close resources
            rs.close();
            stmt.close();
            conn.close();
            
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
} 