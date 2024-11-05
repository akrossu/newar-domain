package edu.gmu.cs321;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.openfx.ApprovalScreen;

/**
 * Tester for Approval Screen
 */
public class ApprovalScreenTest
{
    /**
     * test display fields.
     */
    @Test
    public void testdisplayFields()
    {
        ApprovalScreen testScreen=new ApprovalScreen();
        testScreen.displayFields(null);
        assertTrue(testScreen!=null);
    }

    /**
     * test reject Form
     */
    @Test
    public void testrejectForm()
    {
        ApprovalScreen testScreen=new ApprovalScreen(); 
        assertTrue(testScreen.rejectForm().equals("sucess"));  
    }
    /**
     * Test approveForm
     */
    @Test
    public void testapproveForm()
    {
        ApprovalScreen testScreen=new ApprovalScreen(); 
        assertTrue(testScreen.approveForm()==true);
    }
}