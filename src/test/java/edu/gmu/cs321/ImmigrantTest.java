package edu.gmu.cs321;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class ImmigrantTest {
    private final int id = 1242;
    private final String name = "John Doe";
    private final String dob = "02/24/1985";
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
                .setID(id)
                .build();

        assertEquals(id, immigrant.getID());
    }

    @Test
    void testImmigrantStatus() {
        Immigrant immigrant = new Immigrant.Builder<>()
                .setCitizenshipStatus(status)
                .build();

        assertEquals(status, immigrant.getCitizenshipStatus());
    }

    @Test
    void testImmigrantInstantiation() {
        Immigrant imm = new Immigrant.Builder<>()
                .setID(id)
                .setName(name)
                .setDateOfBirth(dob)
                .setCitizenshipStatus(status)
                .build();

        assertNotNull(imm); // simply verifies an object is able to be created in its entirety
    }
}