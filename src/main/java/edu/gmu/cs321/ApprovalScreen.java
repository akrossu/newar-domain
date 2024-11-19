package edu.gmu.cs321;
/**
 * ApprovalScreen is GUI for Approval.
 */
public class ApprovalScreen
{
    private Approval approval = new Approval();
    /**
     * Display fields for approval.
     */
    public String displayFields(ImmForm curForm)
    {
        
        if (curForm==null)
        {
            return "No forms to display";
        }
        else if (curForm.getImmigrant()==null || curForm.getRelative()==null)
        {
            return "Form Informatimation Missing\n";
        }

        String toDisplay = "";
        Immigrant imm =curForm.getImmigrant();
        toDisplay = toDisplay.concat("Petitioner Name: " +imm.getName() + "\n");
        toDisplay = toDisplay.concat("Petitioner ID: " + imm.getSSN() + "\n");
        toDisplay = toDisplay.concat("Petitioner Relative: "+ curForm.getRelative().getName() +"\n");

        toDisplay = toDisplay.concat("Petitioner Email: Not Implemented\n");
        return toDisplay;


        //to display errors we simply look at the database for people who share the same id as the relative.
    }

    /**
     * rejects form for Approval
     * returns the approval message
     */
    public String rejectForm()
    {
        approval.updateWorkflowForm();
        approval.getWorkflowForm();
        if (approval.getImmForm()!=null)
            return "Form was rejected";
        else
            return "Form was rejected, no more petitioners to display";
    }

    /**
     * approves form for Approval.
     * if there is no form to approve returns false,
     * else returns true.
     */
    public Boolean approveForm()
    {
        approval.sendEmail();
        approval.getWorkflowForm();
        if (approval.getImmForm()!=null)
            return true;
        else
            return false;
        //after completing we should change/Update ImmForm
        //approval.
    }

    public Approval getApproval() {
        return approval;
    }
}