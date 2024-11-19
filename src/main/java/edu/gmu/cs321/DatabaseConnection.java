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
                rs.getInt(1), // id
                rs.getString(2), // petitioner_name
                rs.getDate(3), // petitioner_dob
                rs.getString(4), // petitioner_ssn
                rs.getString(5), // relative_status
                rs.getString(6), // relative_name
                rs.getDate(7), // relative_dob
                rs.getString(8), // relative_nationality
                rs.getString(9) // relative_alien_reg
            };
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}