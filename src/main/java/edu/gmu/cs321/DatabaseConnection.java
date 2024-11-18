package edu.gmu.cs321;

import java.sql.*;

public class DatabaseConnection {
    ImmForm immForm;
    private String DB_URL;
    private String USER;
    private String PASS;

    DatabaseConnection() {}

    public void setDbUrl(String dbUrl) {
        this.DB_URL = dbUrl;
    }

    public void setUser(String user) {
        this.USER = user;
    }

    public void setPassword(String pass) {
        this.PASS = pass;
    }

    public Object[] queryDatabase(String query) {
        try (Connection connection = DriverManager.getConnection(this.DB_URL, this.USER, this.PASS)) {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            rs.next();
            return new Object[]{
                    rs.getInt(1), //ID
                    rs.getInt(2), //AGE
                    rs.getString(3), //FIRST
                    rs.getString(4) //LAST
            };
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}