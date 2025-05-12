package com.agnes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static void main(String[] args) {
        //create a database connection with your sql name
        String url = "jdbc:mysql://localhost:3306/my_database";
        //create your database username
        String user = "root";
        //create your password
        String password = "75240644.Pa@";
        try {
            //  create a connection to the database
            Connection connection = DriverManager.getConnection(url, user, password);

            // If connection is successful, print a message
            System.out.println("Successfully connected to the database!");

            // close the connection when done
            connection.close();
        } catch (SQLException e) {
            // Handle any SQL exceptions here
            System.out.println("Error: Unable to connect to the database.");
            e.printStackTrace();
        }
    }
}



