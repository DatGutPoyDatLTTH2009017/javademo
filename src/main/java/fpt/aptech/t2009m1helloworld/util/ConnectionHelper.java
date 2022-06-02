package fpt.aptech.t2009m1helloworld.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Làm nhiệm đảm bảo duy nhất một kết nối đến database.
 */
public class ConnectionHelper {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/t2009m1_hello_world";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "";

    private static Connection connection; // Class variable.

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
                System.out.println("Connection success!");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
