package org.example.Homework_13;

import java.sql.*;

public class DataBaseReader {
    private static final String URL = "jdbc:postgresql://localhost:4321/rd";
    private static final String USER = "rd";
    private static final String PASSWORD = "rd";

    public static void main(String[] args) {
        try(Connection conn = DriverManager.getConnection(URL,USER,PASSWORD)){
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from teachers");
            while (resultSet.next()){
                System.out.println(resultSet.getString("first_name"));
            }
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
