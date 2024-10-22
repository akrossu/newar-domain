package edu.gmu.cs321;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class ReviewTest
{
    /**
    * test validateFields
    */
   @Test
   public void testvalidateFields()
   {
        Review testReview = new Review();
        assertTrue(testReview.validateFields()>=0);
   }
    /**
    * test getWorkflowForm
    */
   @Test
   public void testgetWorkflowForm()
   {
        Review testReview = new Review();
        assertTrue(testReview.getWorkflowForm());
   }
   /**
    * test updateWorkflowForm 
    */
   @Test
   public void testupdateWorkflowForm()
   {
        Review testReview = new Review();
        assertTrue( testReview.updateWorkflowForm() );
   }
}