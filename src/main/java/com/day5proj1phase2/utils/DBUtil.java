package com.day5proj1phase2.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Adrin@123");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
