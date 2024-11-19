package edu.gmu.cs321;

import com.cs321.Workflow;

import io.github.cdimascio.dotenv.Dotenv;

public class WorkflowStaging {
    private static final Workflow workflow = new Workflow();
    private static final String APPROVE = "Approve";
    private static final String REVIEW = "Review";

    public int addApproval(int id) {
        return WorkflowStaging.workflow.AddWFItem(id, APPROVE);
    }

    public int addReviewer(int id) {
        return WorkflowStaging.workflow.AddWFItem(id, REVIEW);
    }

    public int getNextApprovalWFItem() {
        return WorkflowStaging.workflow.GetNextWFItem(APPROVE);
    }

    public int getNextReviewerWFItem() {
        return WorkflowStaging.workflow.GetNextWFItem(REVIEW);
    }

    public void createNewWFItem(ImmForm form) {
        Dotenv dotenv = Dotenv.configure().load();
        DatabaseConnection dc = new DatabaseConnection();
        dc.setUser(dotenv.get("USER"));
        dc.setDbUrl(dotenv.get("DB_URL"));
        dc.setPassword(dotenv.get("PASS"));
        dc.insertIntoDatabase(form);
        this.addReviewer(form.getId());
    }
}