/*				
 * Copyright (C) FPT University , Ltd. 2023	
 * 30/09/2023 FPT 4USER
 */
package dal;

import java.sql.*;

public class DBContext {

    protected Connection connection;

    /**
     * get an connection
     *
     * @return connection or null
     */
    public Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Book_Store";
            String user = "sa";
            String password = "1234";
            connection = DriverManager.getConnection(url, user, password);
            return connection;
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error " + e.getMessage() + " at DBContext");
            return null;
        }
    }

    public static void main(String[] args) {
        DBContext test = new DBContext();
        test.connection = test.getConnection();
        System.out.println(test.connection);
    }
}
