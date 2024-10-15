package edu.gmu.cs321;

//import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class RelativeTest
{
    //test for relative ID.
    @Test
    public void testID()
    {
        Relative tempRel=new Relative();
        assertTrue(tempRel.getID()>=0);
    }
    
}