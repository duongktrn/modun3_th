package com.example.th3md3.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Myconnection {
    private final String DB_URL = "jdbc:mysql://localhost:3306/product_md3?useSSL=false";
    private final String DB_USERNAME= "root";
    private final String DB_PASSWORD= "12345678";
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
            return connection;
        }catch (ClassNotFoundException | SQLException e) {
            System.out.println("không kết nối được sql");
        }
        return null;
    }
}
