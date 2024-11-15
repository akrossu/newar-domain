
package org.openfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
public class ApprovalController extends LoginController {
    @FXML
    private TextArea appPetitionerInfo;
    @FXML
    private TextArea errorInfo;

   @FXML
    private Label approvalResult;

   // @FXML
    // Text


   // private boolean isEditiable=false;
    public void initialize() {
        populateFields();
    }
    
    private void populateFields()
    {
        appPetitionerInfo.setText("Petitioner Info Goes Here");
        errorInfo.setText("Error Info Goes Here");
        approvalResult.setText("Approval message goes here");
    }

    /**
     * Approval Click uses ApprovalScreen to send an email.
     * Approval Click, confirms that this happens
     */
    //@FXML
    public boolean onAcceptClick(ActionEvent event) {
        approvalResult.setTextFill(Color.BLUE);
        approvalResult.setText("Form was Accepted, Redunant Button!");
        return true;
    }
    /**
     * Reject Click uses ApprovalScreen to send back to Review
     */
    @FXML
    public boolean onRejectClick(ActionEvent event) {
        approvalResult.setTextFill(Color.RED);
        approvalResult.setText("Form was Denied, Sent to Reviewer");
        return true;
    }
    
}