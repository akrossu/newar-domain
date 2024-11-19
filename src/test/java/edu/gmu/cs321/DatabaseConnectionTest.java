package edu.gmu.cs321;

import org.junit.jupiter.api.Test;
import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseConnectionTest {
    @Test
    void setDatabaseConnection() {
        DatabaseConnection dc = new DatabaseConnection();
        assertNotNull(dc);
    }

    @Test
    void getDatabaseContentFromId() throws SQLException {
        int id = 1;
        Dotenv dotenv = Dotenv.configure().load();
        DatabaseConnection dc = new DatabaseConnection();
        dc.setUser(dotenv.get("USER"));
        dc.setDbUrl(dotenv.get("DB_URL"));
        dc.setPassword(dotenv.get("PASS"));
        Object[] obj = dc.queryDatabase("SELECT * FROM People WHERE id=" + id);
        assertEquals(1, obj[0]);
    }

    @Test
    void getDatabaseContentFromIdSQLExceptionEmptySet() {
        int id = 99;
        Dotenv dotenv = Dotenv.configure().load();
        DatabaseConnection dc = new DatabaseConnection();
        dc.setUser(dotenv.get("USER"));
        dc.setDbUrl(dotenv.get("DB_URL"));
        dc.setPassword(dotenv.get("PASS"));
        try { dc.queryDatabase("SELECT * FROM People WHERE id=" + id); }
        catch (RuntimeException e) {
            assertEquals("java.sql.SQLException: Illegal operation on empty result set.", e.getMessage());
        }
    }
}
