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
    private ImmForm immFormData;

    private WorkflowStaging ourWorkflow;

    private DatabaseConnection dc;

    private Dotenv dotenv;

    /**
     * For testing, generally to find petitions we need to search for database for pending petitions.
     * In a later sprint, it will be necessary to have one shared workflow staging with review.
     */
    public Approval()
    {
        ourWorkflow= new WorkflowStaging();
        int id = 1;
        ourWorkflow.addApproval(1);
        ourWorkflow.addApproval(2);
        dotenv = Dotenv.configure().load();
        dc = new DatabaseConnection();
        dc.setUser(dotenv.get("USER"));
        dc.setDbUrl(dotenv.get("DB_URL"));
        dc.setPassword(dotenv.get("PASS"));
        //approval should start up and get the first workflow item, when opening.
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
        ImmRelative tempRel;
        Immigrant tempImm;
        Date date1, date2;
        int id = ourWorkflow.getNextApprovalWFItem(); 
        //what happens if we cant get workflow?
        immFormData=null;
        if (id<0)
        {
            return;
        }
        Object[] obj = dc.queryDatabase("SELECT * FROM People WHERE id=" + id);
        date1=(Date)obj[2];
        date2=(Date)obj[6];
        tempImm = new Immigrant.Builder<>()
            .setName(obj[1].toString())
            .setDateOfBirth(date1)
            .setSSN((obj[3].toString()))
            .build();

        tempRel = new ImmRelative.Builder<>()
                .setName(obj[5].toString())
                .setRelationship("Relative")
                .setDateOfBirth(date2)
                .setNationality(obj[7].toString())
                .setAlienRegistrationNumber(obj[8].toString())
                .build();

        String creationDate = LocalDateTime.now().toString();
        String status = obj[4].toString();
        immFormData = new ImmForm(id, tempImm, tempRel, creationDate, status);
    }
    /**
     * add a worflow form, to review.
     * After adding to Review, we should get our new Workflow Form.
     */
    public Boolean updateWorkflowForm()
    {
        if (immFormData==null)
        {
            return false;
        }
        ourWorkflow.addReviewer(immFormData.getId());
        //for now set to null but change to getting next in workflow

        return true;
    }
    /**
     * get immForm
     */
    public ImmForm getImmForm() {
        return immFormData;
    }

    /**
     * display errors
     */
    public String getErrors()
    {
        if (immFormData==null)
        {
            return "No Errors to Display";
        }
        Object[] obj = dc.queryDatabase("SELECT * FROM People WHERE relative_alien_reg=" + immFormData.getRelative().getAlienRegistrationNumber());
        
        if (obj[0]==null)
        {
            return "Possibly Missing Info";
        }
        if (obj[3].toString().equals(immFormData.getImmigrant().getSSN()))
        {
            return "No Errors";
        }
        else
        {
            return "Other Immigrant with " + immFormData.getRelative().getName() + " is present";
        }
    }

}
