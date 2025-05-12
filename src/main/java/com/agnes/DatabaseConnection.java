package com.agnes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DatabaseConnection {
    public static void main(String[] args) {
        exe1();
    }
    public static void exe(){
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

            //create a statement
            Statement statement = connection.createStatement();

            //write a sql command or create a table
            String sql = "CREATE TABLE IF NOT EXISTS students( id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR (100), age INT)";

            // execute a command
            statement.execute(sql);
            System.out.println("Successfully created a table");

            // Step 5: Insert a student
            String insertStudent = "INSERT INTO students (name, age) VALUES ('Agnes', 29)";
            int rowsInserted = statement.executeUpdate(insertStudent);
            if (rowsInserted > 0) {
                System.out.println(" Student inserted successfully!");
            }

            // close the connection when done
            connection.close();
            statement.close();
            System.out.println(" All done and connection closed.");

        } catch (SQLException e) {
            // Handle any SQL exceptions here
            System.out.println("Error: something went wrong");
            e.printStackTrace();
        }
    }
    public static  void exe1() {
        /* Exercise 1: Insert One Student Using Scanner
Create a Java program that:

Connects to the database.

Asks the user to input:

A student's name.

A student's age.

Inserts the data into the students table.

🧪 Exercise 2: Insert Three Students in a Row
Update Exercise 1 so it:

Repeats the input and insertion process 3 times.

Stores 3 students in the table (ask the user each time).
         */
        //create a database connection with your sql name
        String url = "jdbc:mysql://localhost:3306/my_database";
        //create your database username
        String user = "root";
        //create your password
        String password = "75240644.Pa@";
        Scanner scanner = new Scanner(System.in);
        try {
            //  create a connection to the database
            Connection connection = DriverManager.getConnection(url, user, password);

            // If connection is successful, print a message
            System.out.println("Successfully connected to the database!");

            Statement statement = connection.createStatement();

            //get user input
            System.out.println("Enter student name");
            String name = scanner.nextLine();

            System.out.println("Enter student age");
            int age = scanner.nextInt();

            // build sql query
            String sql = "INSERT INTO students (name, age) VALUES ( '" + name + "', " + age + ")";

            //execute query

            int rows = statement.executeUpdate(sql);

            if (rows > 0) {
                System.out.println("Student added successfully");
            }
            // close everything
            connection.close();
            statement.close();
        } catch (SQLException e ) {
            System.out.println("Error, something went wrong");
            e.printStackTrace();

        } finally {
            scanner.close();
        }
    }
}



