package edu.gmu.cs321;

import java.sql.*;

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
        Statement stmt = null;
        try (Connection connection = DriverManager.getConnection(this.DB_URL, this.USER, this.PASS)) {
            stmt = connection.createStatement();
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
        } finally {
            //if (stmt != null) stmt.close();
        }
    }

    public void insertIntoDatabase(ImmForm form) throws RuntimeException {
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO People (id, petitioner_name, petitioner_dob, petitioner_ssn, relative_status, relative_name, relative_dob, relative_nationality, relative_alien_reg) VALUES (?,?,?,?,?,?,?,?,?)";
        try (Connection connection = DriverManager.getConnection(this.DB_URL, this.USER, this.PASS)) {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, form.getId());
            pstmt.setString(2, form.getImmigrant().getName());
            pstmt.setDate(3, form.getImmigrant().getDateOfBirth());
            pstmt.setString(4, form.getImmigrant().getSSN());
            pstmt.setString(5, form.getRelative().getCitizenshipStatus());
            pstmt.setString(6, form.getRelative().getName());
            pstmt.setDate(7, form.getRelative().getDateOfBirth());
            pstmt.setString(8, form.getRelative().getNationality());
            pstmt.setString(9, form.getRelative().getRelationship());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //if (pstmt != null) pstmt.close();
        }
    }
}