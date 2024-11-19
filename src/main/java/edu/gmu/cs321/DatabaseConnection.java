package edu.gmu.cs321;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    ImmForm immForm;
    private String DB_URL;
    private String USER;
    private String PASS;

    public DatabaseConnection() {}

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
                    rs.getInt(1), //id
                    rs.getString(2), //status
                    rs.getString(3), //name
                    rs.getString(4), //date of birth
                    rs.getInt(5), //registration number
                    rs.getString(6), //relationship
                    rs.getString(7) // nationality
            };
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}