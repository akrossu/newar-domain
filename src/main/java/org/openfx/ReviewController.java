package org.openfx;

import edu.gmu.cs321.DatabaseConnection;
import edu.gmu.cs321.WorkflowStaging;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class ReviewController extends LoginController {
    @FXML
    private TextArea petitionerNameField;
    
    @FXML
    private TextArea petitionerDobField;
    
    @FXML
    private TextArea petitionerAlienRegField;
    
    @FXML
    private TextArea relativeNameField;
    
    @FXML
    private TextArea relativeDobField;
    
    @FXML
    private TextArea relativeNationalityField;
    
    @FXML
    private TextArea relativeAlienRegField;

    @FXML
    private TextArea relativeStatus;
    
    private boolean isEditable = false; 
    public WorkflowStaging workflow= new WorkflowStaging();
    public DatabaseConnection dbConnection;
    private int formID=1;
    @FXML
    private void initialize() {
        dbConnection = new DatabaseConnection(); 
        dbConnection.setDbUrl("jdbc:mysql://localhost:3306/cs321");
        dbConnection.setUser("root");
        dbConnection.setPassword("root");
        populateFields(formID);
    }

    private void populateFields(int id) {
        String query = "SELECT * FROM People WHERE id = " + formID;
        Object[] formData = dbConnection.queryDatabase(query);
        petitionerNameField.setText((String) formData[1]); // Petitioner Name

    }

    public boolean onEditButtonClick(ActionEvent event) {
        isEditable = !isEditable;
        petitionerNameField.setEditable(isEditable);
        petitionerDobField.setEditable(isEditable);
        petitionerAlienRegField.setEditable(isEditable);

        relativeNameField.setEditable(isEditable);
        relativeDobField.setEditable(isEditable);
        relativeNationalityField.setEditable(isEditable);
        relativeAlienRegField.setEditable(isEditable);
        return true;
    }
    public void onNextButtonClick(ActionEvent event) {
        String nextStep = "Approval"; // Example next step, could be dynamic.

        // Add the form to the workflow queue
        int result = workflow.addApproval(formID);
        if (result == 0) {
            System.out.println("Form successfully added to workflow as " + nextStep);
        } else {
            System.out.println("Error adding form to workflow: " + result);
        }
    }
    // public void onGetNextButtonClick(ActionEvent event) {
    //     String nextStep = "Review"; // Step to fetch from workflow (can be dynamic).
    //     int nextFormID = workflow.getNextReviewerWFItem();
    //     if (nextFormID == -3) {
    //         System.out.println("No more items in the queue.");
    //     } else if (nextFormID == -1) {
    //         System.out.println("Invalid step.");
    //     } else {
    //         System.out.println("Next form ID for " + nextStep + ": " + nextFormID);
    //         populateFields(nextFormID);  // Populate the fields with the form data retrieved.
    //     }
    // }
}    
