package BankManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conn {

    Connection c;
    Statement s;

    public Conn() {

        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem", "root", "");
            s = c.createStatement();

            System.out.println("Connected to the database.");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e+"hii");
        }
    }
}
