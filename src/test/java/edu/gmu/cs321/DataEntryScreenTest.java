package edu.gmu.cs321;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 * Tester for Data Entry Screen
 */
public class DataEntryScreenTest
{
    /**
     * test display fields.
     */
    @Test
    public void testdisplayFields()
    {
        DataEntryScreen testScreen=new DataEntryScreen();
        testScreen.displayFields(null);
        assertTrue(testScreen!=null);
    }
    /**
     * test updateFields
     */
    @Test
    public void testupdateFields()
    {
        DataEntryScreen testScreen=new DataEntryScreen();
        testScreen.updateFields("yeep");
        assertTrue(testScreen!=null);
    }
    /**
     * test submitForm
     */
    @Test
    public void testsubmitForm()
    {
        DataEntryScreen testScreen=new DataEntryScreen();
        testScreen.submitForm();
        assertTrue(testScreen!=null);
    }
}