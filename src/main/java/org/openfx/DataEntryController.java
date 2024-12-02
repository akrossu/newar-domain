package org.openfx;

import edu.gmu.cs321.DataEntry;
import edu.gmu.cs321.ImmForm;
import edu.gmu.cs321.ImmRelative;
import edu.gmu.cs321.Immigrant;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.sql.Date;
import java.time.ZonedDateTime;

public class DataEntryController extends LoginController {
    @FXML
    private TextArea petitionerIdField;
    @FXML
    private TextArea petitionerNameField;
    @FXML
    private DatePicker petitionerDobField;
    @FXML
    private TextArea petitionerSSNField;
    @FXML
    private TextArea relativeNameField;
    @FXML
    private DatePicker relativeDobField;
    @FXML
    private TextArea relativeNationalityField;
    @FXML
    private TextArea relativeAlienRegField;
    @FXML
    private TextArea relativeRelationshipField;
    @FXML
    private Label formError;
    @FXML
    private Label formSuccess;
    @FXML
    private Button verifyButton;
    @FXML
    private Button saveButton;

    @Override
    public boolean onSaveButtonClick(ActionEvent event) {
        ImmForm immForm = null;
        try {
            Immigrant immigrant = new Immigrant.Builder<>()
                    .setName(petitionerNameField.getText())
                    .setDateOfBirth(Date.valueOf(petitionerDobField.getValue()))
                    .setSSN(petitionerSSNField.getText())
                    .build();
            ImmRelative immRelative = new ImmRelative.Builder<>()
                    .setAlienRegistrationNumber(relativeAlienRegField.getText())
                    .setNationality(relativeNationalityField.getText())
                    .setRelationship(relativeRelationshipField.getText())
                    .setDateOfBirth(Date.valueOf(relativeDobField.getValue()))
                    .setName(relativeNameField.getText())
                    .setCitizenshipStatus("Pending")
                    .build();
            immForm = new ImmForm(
                    Integer.parseInt(petitionerIdField.getText()),
                    immigrant,
                    immRelative,
                    ZonedDateTime.now().toString(),
                    immRelative.getCitizenshipStatus()
                );

            new DataEntry().addItemToWorkflow(immForm);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            formError.setVisible(true);
            return false;
        }

        if (!immForm.validateForm()) return false;

        if (formError.visibleProperty().get()) formError.setVisible(false);
        formSuccess.setVisible(true);

        petitionerIdField.setDisable(true);
        petitionerNameField.setDisable(true);
        petitionerDobField.setDisable(true);
        petitionerSSNField.setDisable(true);
        relativeAlienRegField.setDisable(true);
        relativeNationalityField.setDisable(true);
        relativeDobField.setDisable(true);
        relativeNameField.setDisable(true);
        relativeRelationshipField.setDisable(true);
        verifyButton.setDisable(true);
        saveButton.setDisable(true);

        return true;
    }

    public void onNewForm(ActionEvent event) throws IOException {
        this.onDataEntryButtonClick(event);
    }
}
