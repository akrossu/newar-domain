package edu.gmu.cs321;

import com.cs321.Workflow;
import io.github.cdimascio.dotenv.Dotenv;

import java.sql.SQLException;

public class WorkflowStaging {
    private static final Workflow workflow = new Workflow();
    private final String approve = "Approve";
    private final String review = "Review";

    public int addApproval(int id) {
        return WorkflowStaging.workflow.AddWFItem(id, approve);
    }

    public int addReviewer(int id) {
        return WorkflowStaging.workflow.AddWFItem(id, review);
    }

    public int getNextApprovalWFItem() {
        return WorkflowStaging.workflow.GetNextWFItem(approve);
    }

    public int getNextReviewerWFItem() {
        return WorkflowStaging.workflow.GetNextWFItem(review);
    }

    public void createNewWFItem(ImmForm form) {
        Dotenv dotenv = Dotenv.configure().load();
        DatabaseConnection dc = new DatabaseConnection();
        dc.setUser(dotenv.get("USER"));
        dc.setDbUrl(dotenv.get("DB_URL"));
        dc.setPassword(dotenv.get("PASS"));
        dc.insertIntoDatabase(form);
        this.addApproval(form.getId());
    }
}