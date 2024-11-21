package edu.gmu.cs321;

import java.sql.Date;
import java.time.LocalDateTime;

import io.github.cdimascio.dotenv.Dotenv;

/**
 * Approval responsible for approving
 */
public class Approval 
{
    /**
     * object variables
     */
    private ImmForm immForm;

    private final WorkflowStaging ws;

    private final DatabaseConnection dc;

    /**
     * For testing, generally to find petitions we need to search for database for pending petitions.
     * In a later sprint, it will be necessary to have one shared workflow staging with review.
     */
    public Approval()
    {
        this.ws = new WorkflowStaging();
        this.dc = new DatabaseConnection();
        this.getWorkflowForm();
    }


    /**
     * sends an email.
     * This function is to be completed at a later date, in case email compatibility becomes a 
     * major requirement.
     */
    public Boolean sendEmail()
    {
        return false;
    }
    /**
     * get workflowForm, set up our ImmFormData.
     * acts as a setting for ImmForm
     */
    public void getWorkflowForm()
    {
        int itemId = this.ws.getNextApprovalWFItem();
        if (itemId == -3) {
            System.out.println("No Items Found");
            return;
        }
        this.immForm = this.ws.getWFId(itemId);

        System.out.println(this.immForm.getImmigrant().getName());
    }
    /**
     * add a worflow form, to review.
     * After adding to Review, we should get our new Workflow Form.
     */
    public Boolean updateWorkflowForm()
    {
        if (this.immForm == null) return false;
        this.immForm.updateFormStatus("Pending");
        System.out.println(this.immForm.getFormStatus());
        return true;
    }
    /**
     * get immForm
     */
    public ImmForm getImmForm() {
        return this.immForm;
    }

    /**
     * display errors
     */
    public String getErrors()
    {
        if (immForm==null)
        {
            return "No Errors to Display";
        }
        Object[] obj = dc.queryDatabase("SELECT * FROM People WHERE relative_alien_reg=" + immForm.getRelative().getAlienRegistrationNumber());
        
        if (obj[0]==null)
        {
            return "Possibly Missing Info";
        }
        if (obj[3].toString().equals(immForm.getImmigrant().getSSN()))
        {
            return "No Errors";
        }
        else
        {
            return "Other Immigrant with " + immForm.getRelative().getName() + " is present";
        }
    }

}
