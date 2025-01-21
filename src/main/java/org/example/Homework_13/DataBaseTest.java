package org.example.Homework_13;

import java.sql.*;
import java.util.Arrays;
import java.util.List;


public class DataBaseTest {
    private static final String URL = "jdbc:postgresql://localhost:4321/rd";
    private static final String USER = "rd";
    private static final String PASSWORD = "rd";

    public static void main(String[] args) {
        DataBaseTest dbTest = new DataBaseTest();
        List<String> teachers = Arrays.asList("Janet", "Lee", "Samantha", "Betty", "Kathleen", "Maria");
        dbTest.performDatabaseOperations(teachers);
    }
    public void performDatabaseOperations(List<String>teachers){
        Connection connection = null;
        PreparedStatement insertStmt = null;
        PreparedStatement selectStmt = null;
        PreparedStatement updateStmt = null;
        PreparedStatement deleteStmt = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
            String insertSQL = "Insert into teachers (first_name) Values (?)";
            insertStmt = connection.prepareStatement(insertSQL);
            for (String teacher : teachers){
                insertStmt.setString(1,teacher);
                insertStmt.executeUpdate();
            }
            String selectSQL = "SELECT * FROM teachers WHERE first_name = ?";
            selectStmt = connection.prepareStatement(selectSQL);
            for (String teacher : teachers) {
                selectStmt.setString(1, teacher);
                resultSet = selectStmt.executeQuery();
                while (resultSet.next()) {
                    System.out.println("ID: " + resultSet.getInt("id"));
                    System.out.println("first_name: " + resultSet.getString("first_name"));
                }
            }
            String updateSQL = "UPDATE teachers SET first_name = ? WHERE first_name = ?";
            updateStmt = connection.prepareStatement(updateSQL);
            for (String teacher : teachers) {
                updateStmt.setString(1, teacher + " Updated");
                updateStmt.setString(2, teacher);
                updateStmt.executeUpdate();
            }
            String deleteSQL = "DELETE FROM teachers WHERE first_name = ?";
            deleteStmt = connection.prepareStatement(deleteSQL);
            for (String teacher : teachers) {
                deleteStmt.setString(1, teacher + " Updated");
                deleteStmt.executeUpdate();
        }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Clean up resources
            try {
                if (resultSet != null) resultSet.close();
                if (insertStmt != null) insertStmt.close();
                if (selectStmt != null) selectStmt.close();
                if (updateStmt != null) updateStmt.close();
                if (deleteStmt != null) deleteStmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}