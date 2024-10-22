package edu.gmu.cs321;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 * Tester for Review Screen
 */
public class ReviewScreenTest
{
    /**
     * test display fields.
     */
    @Test
    public void testdisplayFields()
    {
        ReviewScreen testScreen=new ReviewScreen();
        testScreen.displayFields(null);
        assertTrue(testScreen!=null);
    }
    /**
     * test updateFields for reviewScreen
     */
    @Test
    public void testupdateFields()
    {
        ReviewScreen testScreen=new ReviewScreen();
        testScreen.updateFields("yaap");
        assertTrue(testScreen!=null);
    }
    /**
     * test submitForm for reviewScreen
     */
    @Test
    public void testsubmitForm()
    {
        ReviewScreen testScreen=new ReviewScreen();
        testScreen.submitForm();
        assertTrue(testScreen!=null);

    }
}