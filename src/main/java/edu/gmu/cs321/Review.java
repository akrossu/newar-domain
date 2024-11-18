package edu.gmu.cs321;
import com.cs321.Workflow;
/**
 * Review is responsible for Review step
 */
public class Review {
    /**
     * object variables
     */
    private ImmForm immForm;
    private Workflow workflow;

    public Review(ImmForm immform,Workflow workflow) {
        this.immForm=immform;
        this.workflow = workflow;
    }

    /**
     * validate Fields
     */
    public int validateFields()
    {
        return -1;
    }
    /**
     * Add the current form to the workflow for review.
     */
    public void addToWorkflow(int FormID) {
        int result = workflow.AddWFItem(FormID, "Review");
        if (result == 0) {
            System.out.println("Form " + FormID + " added to the workflow for review.");
        } else {
            System.out.println("Failed to add Form " + FormID + " to the workflow.");
        }
    }
    /**
     * Process the next form for review.
     */
    public int processNextFormForReview() {
        int formID = workflow.GetNextWFItem("Review");
        if (formID == -3) {
            System.out.println("No more forms to review.");
        } else if (formID == -1) {
            System.out.println("Invalid step specified.");
        } else {
            System.out.println("Processing form " + formID + " for review.");
        }
        return formID;
    }
}
