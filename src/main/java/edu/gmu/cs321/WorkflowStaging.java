package edu.gmu.cs321;

import com.cs321.Workflow;

import java.sql.Date;
import java.time.ZonedDateTime;
import java.util.List;

public class WorkflowStaging {
    private final Workflow workflow = new Workflow();
    private final String approve = "Approve";
    private final String review = "Review";

    public int addApproval(int id) {
        return this.workflow.AddWFItem(id, approve);
    }

    public int addReviewer(int id) {
        return this.workflow.AddWFItem(id, review);
    }

    public int getNextApprovalWFItem() {
        return this.workflow.GetNextWFItem(approve);
    }

    public int getNextReviewerWFItem() {
        return this.workflow.GetNextWFItem(review);
    }

    public void createNewWFItem(ImmForm form) {
        DatabaseConnection dc = new DatabaseConnection();
        dc.insertIntoDatabase(form);
        this.addReviewer(form.getId());
    }

    public void populateWFItems() {
        List<Object[]> list = new DatabaseConnection().getIDs();
        for (Object[] items : list) {
            if (items[1].toString().equals("Pending")) this.addApproval((Integer) items[0]);
            else if (items[1].toString().equals("Created")) this.addReviewer((Integer) items[0]);
        }
    }

    public ImmForm getWFId(int id) {
        Object[] obj = new DatabaseConnection().queryID(id);
        try {
            Immigrant immigrant = new Immigrant.Builder<>()
                    .setName(obj[1].toString())
                    .setDateOfBirth(Date.valueOf((String) obj[2]))
                    .setSSN((String) obj[3])
                    .build();
            ImmRelative immRelative = new ImmRelative.Builder<>()
                    .setAlienRegistrationNumber((String) obj[8])
                    .setNationality((String) obj[7])
                    .setRelationship("Relation")
                    .setDateOfBirth(Date.valueOf((String) obj[6]))
                    .setName((String) obj[5])
                    .setCitizenshipStatus((String) obj[4])
                    .build();
            return new ImmForm(
                    (Integer) obj[0],
                    immigrant,
                    immRelative,
                    ZonedDateTime.now().toString(),
                    immRelative.getCitizenshipStatus()
            );
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}