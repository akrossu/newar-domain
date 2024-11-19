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
    
    private boolean isEditable = false; 
    public WorkflowStaging workflow;
    public DatabaseConnection dbConnection;
    private int formID;

    private void initialize() {
        workflow= new WorkflowStaging();
        dbConnection = new DatabaseConnection(); 
        dbConnection.setDbUrl("jdbc:mysql://localhost:3306/cs321");
        dbConnection.setUser("username");
        dbConnection.setPassword("password");
        formID=workflow.getNextReviewerWFItem();
        populateFields(formid);
    }

    private void populateFields(int formID) {
        String query = "FormID = " + formID;
        Object[] formData = dbConnection.queryDatabase(query);
        if (formData != null && formData.length > 0) {
            // Populate the fields using the data retrieved from the database.
            petitionerNameField.setText((String) formData[2]);  // Petitioner Name
            petitionerDobField.setText((String) formData[3]);   // Petitioner DOB
            petitionerAlienRegField.setText(String.valueOf(formData[4])); // Petitioner Alien Reg # or SSN

            relativeNameField.setText((String) formData[5]); // Relative Name
            relativeDobField.setText((String) formData[6]);  // Relative DOB
            relativeNationalityField.setText((String) formData[7]); // Relative Nationality
            relativeAlienRegField.setText(String.valueOf(formData[4])); // Relative Alien Reg #
        }
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
    public void onGetNextButtonClick(ActionEvent event) {
        String nextStep = "Review"; // Step to fetch from workflow (can be dynamic).
        int nextFormID = workflow.getNextReviewerWFItem();
        if (nextFormID == -3) {
            System.out.println("No more items in the queue.");
        } else if (nextFormID == -1) {
            System.out.println("Invalid step.");
        } else {
            System.out.println("Next form ID for " + nextStep + ": " + nextFormID);
            populateFields(nextFormID);  // Populate the fields with the form data retrieved.
        }
    }
}    
