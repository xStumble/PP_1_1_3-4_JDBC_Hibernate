package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String hostName = "localhost";
    private static final String dbName = "pp1134";
    private static final String userName = "root";
    private static final String password = "root";

    private static Connection connection;
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        if (connection == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionUrl = "jdbc:mysql://" + hostName + ":3306/" + dbName;
            connection = DriverManager.getConnection(connectionUrl, userName, password);
        }

        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
