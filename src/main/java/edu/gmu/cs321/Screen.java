package edu.gmu.cs321;
/**
 *  Screen is the class responsible for displaying DateEntry, ReviewScreen, ApprovalScreen.
 */
public class Screen {
    /**
     * Object variables
     */
    private int screenID;
    private ImmForm screenForm;

    /**
     * Constructor
     */
    public Screen()
    {
        screenID=-1;
        screenForm=null;
    }
    
    /**
     * Clears screen
     */
    public void clearScreen()
    {
    }
    
    /**
     * Closes screen
     */
    public void closeScreen()
    {
    }

    /**
     * gets a Form.
     */
    public ImmForm getForm()
    {
        return screenForm;
    }

}