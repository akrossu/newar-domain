package edu.gmu.cs321;

import org.junit.jupiter.api.Test;

public class ImmigrantTest
{
    //tester for immigrant ID
    @Test
    public void testImmigrantID()
    {
        Immigrant testImm =new Immigrant();
        int testID = testImm.getID();
        assertTrue(testID>=0);
    }
}