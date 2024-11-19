package edu.gmu.cs321;

import com.cs321.Workflow;

public class WorkflowStaging {
    private static Workflow workflow;

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