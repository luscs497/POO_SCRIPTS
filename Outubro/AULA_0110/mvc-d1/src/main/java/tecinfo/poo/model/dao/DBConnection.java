/* by Josenalde Oliveira 2024 */
package tecinfo.poo.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String USER = "postgres";
    private static final String PASSWORD = "101520";
    private static final String URL_DB = "jdbc:postgresql://localhost:5432/products"; // you may change the server port and database name

    public static Connection getConnection() {
        Connection conn = null; // a default null connection
        try {
            conn = DriverManager.getConnection(DBConnection.URL_DB, DBConnection.USER, DBConnection.PASSWORD); // server password
            if (conn != null) {
                System.out.println("Connected to database #1");
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e); //e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return conn;
    }
}