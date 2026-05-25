package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/ticarena";
    private static final String USER = "root";
    private static final String PASSWORD = "AzhanRabeya@1605";
    public static Connection getConnection() {

        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Database connected successfully!");
            return conn;

        }
        catch(Exception e) {
            System.out.println("Connection failed!");
            e.printStackTrace();

            return null;
        }
    }
}