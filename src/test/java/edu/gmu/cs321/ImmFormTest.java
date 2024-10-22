package edu.gmu.cs321;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * ImmFormTest is responsible for testing methods of ImmForm
 */
public class ImmFormTest {
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

    /**
     * Testing validate form.
     */
    @Test
    public void testValidateForm() {
        Immigrant testImm=new Immigrant();
        //Relative testRel=new Relative();
        ImmForm testImmForm= new ImmForm(testImm, null, null, null);
        assertTrue(testImmForm.validateForm());
    }
    /**
     * testing getImmigrant.
     */
    @Test
    public void testgetImmigrant()
    {
        Immigrant testImm=new Immigrant(), recieved = new Immigrant();
        ImmForm testImmForm=new ImmForm(testImm, null, null, null);
        assertTrue(testImmForm.getImmigrant()==recieved);
        
    }
    /**
     * testing getRelative
     */
    @Test
    public void testgetRelative()
    {
        ImmForm testImmForm=new ImmForm(null, null, null, null);
        assertTrue(testImmForm.getRelative()!=null);
    }
    /**
     * Testing getCreationDate
     */
    @Test
    public void testgetCreationDate()
    {
        ImmForm testImmForm=new ImmForm(null, null, null, null);
        assertTrue(testImmForm.getCreationDate()!=null);
    }
    //methods like these arent working properly right now, and so the test should
    //catch a failure.
    /**
     * Testing setCreationDate
     */
    @Test
    public void testsetCreationDate()
    {
        Immigrant testImm=new Immigrant();
        ImmForm testImmForm=new ImmForm(testImm, null, null, null);
        assertTrue(testImmForm.setCreationDate("today"));
    }
    /**
     * Testing getFormStatus
     */
    @Test
    public void testgetFormStatus()
    {
        Immigrant testImm=new Immigrant();
        ImmForm testImmForm=new ImmForm(testImm, null, null, null);
        assertTrue(testImmForm.getFormStatus()!=null);
    }
    /**
     * Testing updateFormStatus
     */
    @Test
    public void testupdateFormStatus()
    {
        Immigrant testImm=new Immigrant();
        ImmForm testImmForm=new ImmForm(testImm, null, null, null);
        assertTrue(testImmForm.updateFormStatus("no"));
    }
}