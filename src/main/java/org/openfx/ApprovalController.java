
package org.openfx;

import edu.gmu.cs321.ApprovalScreen;
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
    private ApprovalScreen approvalScreen = new ApprovalScreen();

   /**
    * Initialize should populate fields
    */
    public void initialize() {
        populateFields();
    }
    
    private void populateFields()
    {

        appPetitionerInfo.setText(approvalScreen.displayFields(approvalScreen.getApproval().getImmForm()));
        errorInfo.setText("Error Info Goes Here");
        approvalResult.setText("Approval message goes here");
    }

    /**
     * Approval Click uses ApprovalScreen to send an email.
     * Approval Click, confirms that this happens
     */
    //@FXML
    public boolean onAcceptClick(ActionEvent event) {
        String outputText = "";
        boolean isApproved=false;
        approvalResult.setTextFill(Color.BLUE);

        if (approvalScreen.getApproval().getImmForm()==null)
            outputText = "No Form was approved!";
        else
            outputText= "Form was Accepted!";
        
        if (approvalScreen.approveForm()==true)
            outputText= outputText.concat(" Displaying New Form!");
        else
            outputText = outputText.concat(" No new forms!");
        approvalResult.setText(outputText);
        appPetitionerInfo.setText(approvalScreen.displayFields(approvalScreen.getApproval().getImmForm()));
        return true;
    }
    /**
     * Reject Click uses ApprovalScreen to send back to Review
     */
    @FXML
    public boolean onRejectClick(ActionEvent event) {
        approvalResult.setTextFill(Color.RED);
        approvalResult.setText(approvalScreen.rejectForm());
        appPetitionerInfo.setText(approvalScreen.displayFields(approvalScreen.getApproval().getImmForm()));
        return true;
    }
    
}