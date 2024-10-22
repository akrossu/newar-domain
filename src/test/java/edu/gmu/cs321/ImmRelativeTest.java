package edu.gmu.cs321;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ImmRelativeTest {
    private int id = 1242;
    private String name = "John Doe";
    private String dob = "02/24/1985";
    private String status = "valid";
    private int alienRegistrationNumber = 27647264;
    private String relationship = "Spouse";
    private String nationality = "Singaporean";

    @Test
    public void testImmRelativeName() {
        ImmRelative immigrant = new ImmRelative.Builder<>()
                .setName(name)
                .build();

        assertEquals(name, immigrant.getName());
    }

    @Test
    public void testImmRelativeDateOfBirth() {
        ImmRelative immigrant = new ImmRelative.Builder<>()
                .setDateOfBirth(dob)
                .build();

        assertEquals(dob, immigrant.getDateOfBirth());
    }

    @Test
    public void testImmRelativeID() {
        ImmRelative immigrant = new ImmRelative.Builder<>()
                .setID(id)
                .build();

        assertEquals(id, immigrant.getID());
    }

    @Test
    public void testImmRelativeStatus() {
        ImmRelative immigrant = new ImmRelative.Builder<>()
                .setCitizenshipStatus(status)
                .build();

        assertEquals(status, immigrant.getCitizenshipStatus());
    }

    // TODO: Add various immigrant status tests

    @Test
    public void testImmRelativeAlienRegistrationNumber() {
        ImmRelative immigrant = new ImmRelative.Builder<>()
                .setAlienRegistrationNumber(alienRegistrationNumber)
                .build();

        assertEquals(alienRegistrationNumber, immigrant.getAlienRegistrationNumber());
    }
    @Test
    public void testImmRelativeRelationship() {
        ImmRelative immigrant = new ImmRelative.Builder<>()
                .setRelationship(relationship)
                .build();

        assertEquals(relationship, immigrant.getRelationship());
    }


    @Test
    public void testImmRelativeNationality() {
        ImmRelative immigrant = new ImmRelative.Builder<>()
                .setNationality(nationality)
                .build();

        assertEquals(nationality, immigrant.getNationality());
    }

    @Test
    public void testImmigrantInstantiation() {
        new ImmRelative.Builder<>()
                .setID(id)
                .setName(name)
                .setDateOfBirth(dob)
                .setCitizenshipStatus(status)
                .setAlienRegistrationNumber(alienRegistrationNumber)
                .setRelationship(relationship)
                .setNationality(nationality)
                .build();

        assert(true); // simply verifies an object is able to be created in its entirety
    }
}