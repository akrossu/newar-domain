package edu.gmu.cs321;
public class Main {
    public static void main(String[] args) {
         // Database connection parameters
         String dbUrl = "jdbc:mysql://localhost:3306/cs321";
         String user = "root";
         String pass = "password";
  // Create DatabaseConnection and WorkflowStaging objects
  DatabaseConnection dbConnection = new DatabaseConnection();
  WorkflowStaging workflowStaging = new WorkflowStaging();
  dbConnection.setDbUrl("jdbc:mysql://localhost:3306/path");
  dbConnection.setUser("root");
  dbConnection.setPassword("root");


        // Adding forms for review and approval
        System.out.println("Adding Form 1 to Review queue: " + workflowStaging.addReviewer(1)); // Expected: 0
        System.out.println("Adding Form 2 to Approval queue: " + workflowStaging.addApproval(2)); // Expected: 0

        // Retrieve and process the next form for review
        int nextReviewForm = workflowStaging.getNextReviewerWFItem();
        System.out.println("Next Review Form ID: " + nextReviewForm); // Expected: 1 if queue isn't empty

        // Retrieve and process the next form for approval
        int nextApprovalForm = workflowStaging.getNextApprovalWFItem();
        System.out.println("Next Approval Form ID: " + nextApprovalForm); // Expected: 2 if queue isn't empty
    }
}
