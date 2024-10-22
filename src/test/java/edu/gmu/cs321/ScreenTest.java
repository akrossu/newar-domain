package edu.gmu.cs321;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
/**
 * Tester for Screen
 */
public class ScreenTest
{
    /**
     * test get form
     */
    @Test
    public void testgetForm() {
        Screen testScreen=new Screen();
        assertTrue(testScreen.getForm()!=null);
    }
    /**
     * test if screen was cleared
     */
    @Test
    public void testclearScreen() {
        Screen testScreen=new Screen();
        testScreen.clearScreen();
        assertTrue(testScreen.getForm()!=null);
    }
    /**
     * test if screen was closed.
     */
    @Test
    public void testcloseScreen() {
        Screen testScreen=new Screen();
        testScreen.closeScreen();
        assertTrue(testScreen.getForm()!=null);
    }
}