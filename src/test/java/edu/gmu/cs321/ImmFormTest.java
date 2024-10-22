package edu.gmu.cs321;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ImmFormTest
{
    private Immigrant immigrant;
    private ImmRelative relative;
    private ImmForm immForm;

    public void setUp() {
        immigrant = new Immigrant(); 
        relative = new ImmRelative();     
        immForm = new ImmForm(immigrant, relative, "10/21/2024", "Pending");
    }
    @Test
    public void testConstructorAndGetters() {
        assertEquals(immigrant, immForm.getImmigrant());
        assertEquals(relative, immForm.getRelative());
        assertEquals("10/21/2024", immForm.getCreationDate());
        assertEquals("Pending", immForm.getFormStatus());
    }
    @Test
    public void testValidateForm() {
        ImmForm invalidForm = new ImmForm(null, relative, "10/21/2024", "Pending");
        assertFalse(invalidForm.validateForm());
        invalidForm = new ImmForm(immigrant, null, "10/21/2024", "Pending");
        assertFalse(invalidForm.validateForm());
    }
    @Test
    public void testSetCreationDate() {
        immForm.setCreationDate("11/01/2024");
        assertEquals("11/01/2024", immForm.getCreationDate());
    }
    @Test
    public void testUpdateFormStatus() {
        immForm.updateFormStatus("Approved");
        assertEquals("Approved", immForm.getFormStatus(), "Form status should be updated.");
    }

}