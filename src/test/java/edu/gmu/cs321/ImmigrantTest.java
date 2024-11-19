package edu.gmu.cs321;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDate;

class ImmigrantTest {
    private final String ssn = "1242";
    private final String name = "John Doe";
    private final Date dob = Date.valueOf(LocalDate.now());
    private final String status = "valid";

    @Test
    void testImmigrantName() {
        Immigrant immigrant = new Immigrant.Builder<>()
                .setName(name)
                .build();

        assertEquals(name, immigrant.getName());
    }

    @Test
    void testImmigrantDateOfBirth() {
        Immigrant immigrant = new Immigrant.Builder<>()
                .setDateOfBirth(dob)
                .build();

        assertEquals(dob, immigrant.getDateOfBirth());
    }

    @Test
    void testImmigrantID() {
        Immigrant immigrant = new Immigrant.Builder<>()
                .setSSN(ssn)
                .build();

        assertEquals(ssn, immigrant.getSSN());
    }

    @Test
    void testImmigrantInstantiation() {
        Immigrant imm = new Immigrant.Builder<>()
                .setSSN(ssn)
                .setName(name)
                .setDateOfBirth(dob)
                .build();

        assertNotNull(imm); // simply verifies an object is able to be created in its entirety
    }
}