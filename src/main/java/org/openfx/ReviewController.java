package org.openfx;

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
    public void initialize() {
        populateFields();
    }

    private void populateFields() {
        petitionerNameField.setText("John Doe");
        petitionerDobField.setText("01/01/1980");
        petitionerAlienRegField.setText("A123456789");

        relativeNameField.setText("Jane Smith");
        relativeDobField.setText("02/02/1990");
        relativeNationalityField.setText("Canadian");
        relativeAlienRegField.setText("A987654321");
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
}
