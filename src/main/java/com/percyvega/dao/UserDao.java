package com.percyvega.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {
    public void insertData(/*String username, String password*/) throws Exception {
        String username = "Me";
        String password = "MeToo";
        System.out.println("jdbc connection");
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/strutsdb", "root", "root");
        //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/strutsdb?"+"user=root&password=root");

        try {

            try {
                Statement st = con.createStatement();
                int value = st
                        .executeUpdate("INSERT INTO USER_DETAILS(USERNAME,PASSWORD) "
                                + "VALUES('"+ username+ "','"+ password+ "')");
                System.out.println("1 row affected" + value);
            } catch (SQLException ex) {
                System.out.println("SQL statement is not executed!" + ex);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
