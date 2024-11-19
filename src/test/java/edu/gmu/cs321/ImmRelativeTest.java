package edu.gmu.cs321;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDate;

class ImmRelativeTest {
    private final String id = "1242";
    private final String name = "John Doe";
    private final Date dob = Date.valueOf(LocalDate.now());
    private final String status = "valid";
    private final String alienRegistrationNumber = "27647264";
    private final String relationship = "Spouse";
    private final String nationality = "Singaporean";

    @Test
    void testImmRelativeName() {
        ImmRelative immigrant = new ImmRelative.Builder<>()
                .setName(name)
                .build();

        assertEquals(name, immigrant.getName());
    }

    @Test
    void testImmRelativeDateOfBirth() {
        ImmRelative immigrant = new ImmRelative.Builder<>()
                .setDateOfBirth(dob)
                .build();

        assertEquals(dob, immigrant.getDateOfBirth());
    }

    @Test
    void testImmRelativeStatus() {
        ImmRelative immigrant = new ImmRelative.Builder<>()
                .setCitizenshipStatus(status)
                .build();

        assertEquals(status, immigrant.getCitizenshipStatus());
    }

    @Test
    void testImmRelativeAlienRegistrationNumber() {
        ImmRelative immigrant = new ImmRelative.Builder<>()
                .setAlienRegistrationNumber(alienRegistrationNumber)
                .build();

        assertEquals(alienRegistrationNumber, immigrant.getAlienRegistrationNumber());
    }
    @Test
    void testImmRelativeRelationship() {
        ImmRelative immigrant = new ImmRelative.Builder<>()
                .setRelationship(relationship)
                .build();

        assertEquals(relationship, immigrant.getRelationship());
    }


    @Test
    void testImmRelativeNationality() {
        ImmRelative immigrant = new ImmRelative.Builder<>()
                .setNationality(nationality)
                .build();

        assertEquals(nationality, immigrant.getNationality());
    }

    @Test
    void testImmigrantInstantiation() {
        ImmRelative rel = new ImmRelative.Builder<>()
                .setName(name)
                .setDateOfBirth(dob)
                .setCitizenshipStatus(status)
                .setAlienRegistrationNumber(alienRegistrationNumber)
                .setRelationship(relationship)
                .setNationality(nationality)
                .build();

        assertNotNull(rel); // simply verifies an object is able to be created in its entirety
    }
}