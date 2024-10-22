package edu.gmu.cs321;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class ImmFormTest
{
    @Test
    public void testValidateForm() {
        Immigrant testImm=new Immigrant();
        //Relative testRel=new Relative();
        ImmForm testImmForm= new ImmForm(testImm, null, null, null);
        assertTrue(testImmForm.validateForm());
    }

    @Test
    public void testgetImmigrant()
    {
        Immigrant testImm=new Immigrant(), recieved = new Immigrant();
        ImmForm testImmForm=new ImmForm(testImm, null, null, null);
        assertTrue(testImmForm.getImmigrant()==recieved);
        
    }

    @Test
    public void testgetRelative()
    {
        ImmForm testImmForm=new ImmForm(null, null, null, null);
        assertTrue(testImmForm.getRelative()!=null);
    }

    @Test
    public void testgetCreationDate()
    {
        ImmForm testImmForm=new ImmForm(null, null, null, null);
        assertTrue(testImmForm.getCreationDate()!=null);
    }
    //methods like these arent working properly right now, and so the test should
    //catch a failure.
    @Test
    public void testsetCreationDate()
    {
        Immigrant testImm=new Immigrant();
        ImmForm testImmForm=new ImmForm(testImm, null, null, null);
        assertTrue(testImmForm.setCreationDate("today"));
    }

    @Test
    public void testgetFormStatus()
    {
        Immigrant testImm=new Immigrant();
        ImmForm testImmForm=new ImmForm(testImm, null, null, null);
        assertTrue(testImmForm.getFormStatus()!=null);
    }

    @Test
    public void testupdateFormStatus()
    {
        Immigrant testImm=new Immigrant();
        ImmForm testImmForm=new ImmForm(testImm, null, null, null);
        assertTrue(testImmForm.updateFormStatus("no"));
    }

}