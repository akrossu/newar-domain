package edu.gmu.cs321;

//import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class ImmRelativeTest
{
    //test for relative ID.
    @Test
    public void testID()
    {
        ImmRelative tempRel=new ImmRelative();
        assertTrue(tempRel.getID()>=0);
    }
    
}