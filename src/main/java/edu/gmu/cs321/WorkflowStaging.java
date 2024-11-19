package edu.gmu.cs321;

import com.cs321.Workflow;

public class WorkflowStaging {
<<<<<<< HEAD
    private static Workflow workflow;
        WorkflowStaging() {
            this.workflow = new Workflow();
        }
    
=======
    private static Workflow workflow=new Workflow();

>>>>>>> 6998efe850edce94ed4b7ce6e44f2d962e5655b5
    public int addApproval(int id) {
            return WorkflowStaging.workflow.AddWFItem(id, "Approve");
    }

    public int addReviewer(int id) {
        return WorkflowStaging.workflow.AddWFItem(id, "Review");
    }

    public int getNextApprovalWFItem() {
        return WorkflowStaging.workflow.GetNextWFItem("Approve");
    }

    public int getNextReviewerWFItem() {
        return WorkflowStaging.workflow.GetNextWFItem("Review");
    }
}