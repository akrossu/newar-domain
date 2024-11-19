package edu.gmu.cs321;

import com.cs321.Workflow;

public class WorkflowStaging {
    private Workflow workflow;
    WorkflowStaging() {
        this.workflow = new Workflow();
    }

    public int addApproval(int id) {
        return this.workflow.AddWFItem(id, "Approve");
    }

    public int addReviewer(int id) {
        return this.workflow.AddWFItem(id, "Review");
    }

    public int getNextApprovalWFItem() {
        return this.workflow.GetNextWFItem("Approve");
    }

    public int getNextReviewerWFItem() {
        return this.workflow.GetNextWFItem("Review");
    }
}