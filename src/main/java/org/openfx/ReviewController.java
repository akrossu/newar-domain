package org.openfx;

import edu.gmu.cs321.Review;
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
    private TextArea relativeStatusField;

    private boolean isEditable = false;
    private Review review;
    private int formID = 1;

    @FXML
    private void initialize() {
        WorkflowStaging workflow = new WorkflowStaging();
        review = new Review();  // Assuming ImmForm is defined somewhere
        populateFields(formID);
    }

    private void populateFields(int id) {
        Object[] formData = review.getFormData(id);
        petitionerNameField.setText((String) formData[1]);
        petitionerDobField.setText(formData[2].toString());
        petitionerAlienRegField.setText((String) formData[3]);
        relativeStatusField.setText((String) formData[4]);
        relativeNameField.setText((String) formData[5]);
        relativeDobField.setText(formData[6].toString());
        relativeNationalityField.setText((String) formData[7]);
        relativeAlienRegField.setText((String) formData[8]);

    }
    @Override
    public boolean onVerifyButtonClick(ActionEvent event){
    return true;
}

// Helper method to validate date format
private boolean isValidDate(String date) {
    return date.matches("(0[1-9]|1[0-2])/(0[1-9]|[12]\\d|3[01])/\\d{4}");
}

    // Makes text on UI editable
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
    //Update database and upload the item to the next workflow
    public boolean onSaveAndSubmitButtonClick(ActionEvent event) {
        review.updateForm(formID, petitionerNameField.getText(), petitionerDobField.getText(),
        petitionerAlienRegField.getText(), relativeStatusField.getText(), relativeNameField.getText(),
        relativeDobField.getText(), relativeNationalityField.getText(), relativeAlienRegField.getText());
    review.addFormToWorkflow(formID);
    return true;
    }
    //Get and display next item on workflow
    public void onGetNextButtonClick(ActionEvent event) {
        int nextFormID = review.getNextFormInWorkflow();
        if (nextFormID == -3) {
            System.out.println("No more items in the queue.");
        } else if (nextFormID == -1) {
            System.out.println("Invalid step.");
        } else {
            System.out.println("Next form ID: " + nextFormID);
            populateFields(nextFormID);
        }
    }
}
