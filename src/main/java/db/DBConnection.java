package db;

import java.sql.*;

public class DBConnection {
    public static void main(String[] args) {

        try {
            Connection conn = getConnection();

            Statement stmt = conn.createStatement();

        } catch (SQLException e)  {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        String url = "";
        url += "";
        Connection conn = DriverManager.getConnection(url);
        return conn;
    }
}
