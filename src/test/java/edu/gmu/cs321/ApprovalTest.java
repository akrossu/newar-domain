package edu.gmu.cs321;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple Approval.
 */
public class ApprovalTest 
{
    /**
     * test sendEmail
     */
   @Test
   public void testsendEmail()
   {
       Approval testApproval = new Approval();
       assertTrue( testApproval.sendEmail());
   }
   /**
    * test getWorkflowForm
    * Currently this test does not do anything, but further testing will be added later
    */
   @Test
   public void testgetWorkflowForm()
   {
        Approval testApproval = new Approval();
        testApproval.getWorkflowForm();
        assertTrue(testApproval!=null);
   }
   /**
    * test updateWorkflowForm 
    */
   @Test
   public void testupdateWorkflowForm()
   {
        Approval testApproval = new Approval();
        assertTrue( testApproval.updateWorkflowForm() );
   }
}
