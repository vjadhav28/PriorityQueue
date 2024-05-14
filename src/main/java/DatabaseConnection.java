import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; // For MySQL Connector/J 8.x and above

    public static void main(String[] args) {
        Connection connection = null;
        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            System.out.println("Connected to database successfully.");

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}
