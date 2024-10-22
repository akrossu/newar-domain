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

}