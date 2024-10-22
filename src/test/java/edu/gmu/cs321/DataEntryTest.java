package edu.gmu.cs321;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple Approval.
 */
public class DataEntryTest 
{
    /**
     * test validate fields
     */
    @Test
    public void testvalidateFields()
    {
        DataEntry testDataEntry= new DataEntry();
        assertTrue( testDataEntry.validateFields()>=0 );
    }
    /**
     * test get form template
     */
    @Test
    public void testgetFormTemplate()
    {
        DataEntry testDataEntry= new DataEntry();
        assertTrue( testDataEntry.getFormTemplate() );
    }
    /**
     * test add workflow form 
     */
    @Test
    public void testaddWorkflowForm()
    {
        DataEntry testDataEntry= new DataEntry();
        assertTrue( testDataEntry.addWorkflowForm() );
    }
}
