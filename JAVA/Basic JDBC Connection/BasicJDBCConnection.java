import java.sql.*;

public class BasicJDBCConnection {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:students.db"; // SQLite database

        try {
            // Register the SQLite JDBC driver
            Class.forName("org.sqlite.JDBC");
            
            try (Connection conn = DriverManager.getConnection(url);
                 Statement stmt = conn.createStatement()) {

                // Create table if it doesn't exist with more details
                String createTable = "CREATE TABLE IF NOT EXISTS students (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "name TEXT, " +
                    "age INTEGER, " +
                    "grade TEXT, " +
                    "email TEXT)";
                stmt.execute(createTable);

                // Check if table is empty
                String countQuery = "SELECT COUNT(*) AS total FROM students";
                ResultSet countRs = stmt.executeQuery(countQuery);
                int total = 0;
                if (countRs.next()) {
                    total = countRs.getInt("total");
                }
                countRs.close();

                // Insert sample records if table is empty
                if (total == 0) {
                    // Insert multiple students
                    String[] inserts = {
                        "INSERT INTO students (name, age, grade, email) VALUES ('John Doe', 20, 'A', 'john.doe@email.com')",
                        "INSERT INTO students (name, age, grade, email) VALUES ('Jane Smith', 19, 'B+', 'jane.smith@email.com')",
                        "INSERT INTO students (name, age, grade, email) VALUES ('Mike Johnson', 21, 'A-', 'mike.j@email.com')",
                        "INSERT INTO students (name, age, grade, email) VALUES ('Sarah Williams', 20, 'B', 'sarah.w@email.com')",
                        "INSERT INTO students (name, age, grade, email) VALUES ('David Brown', 22, 'A+', 'david.b@email.com')"
                    };

                    for (String insert : inserts) {
                        stmt.executeUpdate(insert);
                    }
                    System.out.println("Inserted 5 sample students");
                }

                String query = "SELECT * FROM students";
                ResultSet rs = stmt.executeQuery(query);

                System.out.println("\nAll students:");
                System.out.println("ID\tName\t\tAge\tGrade\tEmail");
                System.out.println("--------------------------------------------------------");
                while (rs.next()) {
                    System.out.printf("%d\t%-15s\t%d\t%s\t%s%n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("grade"),
                        rs.getString("email"));
                }
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("SQLite JDBC driver not found: " + e.getMessage());
        }
    }
}
