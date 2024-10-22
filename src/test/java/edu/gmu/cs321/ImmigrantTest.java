package edu.gmu.cs321;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ImmigrantTest {
    // Intentionally left as not final
    private int id = 1242;
    private String name = "John Doe";
    private String dob = "02/24/1985";
    private String status = "valid";

    @Test
    public void testImmigrantName() {
        Immigrant immigrant = new Immigrant.Builder<>()
                .setName(name)
                .build();

        assertEquals(name, immigrant.getName());
    }

    @Test
    public void testImmigrantDateOfBirth() {
        Immigrant immigrant = new Immigrant.Builder<>()
                .setDateOfBirth(dob)
                .build();

        assertEquals(dob, immigrant.getDateOfBirth());
    }

    @Test
    public void testImmigrantID() {
        Immigrant immigrant = new Immigrant.Builder<>()
                .setID(id)
                .build();

        assertEquals(id, immigrant.getID());
    }

    @Test
    public void testImmigrantStatus() {
        Immigrant immigrant = new Immigrant.Builder<>()
                .setCitizenshipStatus(status)
                .build();

        assertEquals(status, immigrant.getCitizenshipStatus());
    }

    // TODO: Add various immigrant status tests

    @Test
    public void testImmigrantInstantiation() {
        new Immigrant.Builder<>()
                .setID(id)
                .setName(name)
                .setDateOfBirth(dob)
                .setCitizenshipStatus(status)
                .build();

        assert(true); // simply verifies an object is able to be created in its entirety
    }
}