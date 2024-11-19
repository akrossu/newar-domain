package org.openfx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
    private TextArea relativeStatusField;

    private boolean isEditable = false;
    public WorkflowStaging workflow = new WorkflowStaging();
    public DatabaseConnection dbConnection;
    private int formID=1;
    //private int formID = workflow.getNextReviewerWFItem();

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
        // Petitioner Name
        petitionerNameField.setText((String) formData[1]);

// Petitioner Date of Birth
        petitionerDobField.setText(formData[2].toString()); // Assuming formData[2] is a java.sql.Date

// Petitioner SSN
        petitionerAlienRegField.setText((String) formData[3]);

// Relative Status
        relativeStatusField.setText((String) formData[4]);

// Relative Name
        relativeNameField.setText((String) formData[5]);

// Relative Date of Birth
        relativeDobField.setText(formData[6].toString()); // Assuming formData[6] is a java.sql.Date

// Relative Nationality
        relativeNationalityField.setText((String) formData[7]);

// Relative Alien Registration Number
        relativeAlienRegField.setText((String) formData[8]);

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
    @Override
    public boolean onSaveButtonClick(ActionEvent event) {
        updateDatabase();
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
    public void updateDatabase() {
    // Define the SQL UPDATE query with placeholders for the data to be updated
    String updateQuery = "UPDATE People SET " +
            "petitioner_name = ?, " +
            "petitioner_dob = ?, " +
            "petitioner_ssn = ?, " +
            "relative_status = ?, "+
            "relative_name = ?, " +
            "relative_dob = ?, " +
            "relative_nationality = ?, " +
            "relative_alien_reg = ? " +
            "WHERE id = ?"; // Include the WHERE clause
            

    // Establish the database connection (using your dbConnection object)
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
        // Get the connection object
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cs321", "root", "root");

        // Prepare the SQL statement
        preparedStatement = connection.prepareStatement(updateQuery);

        // Set the parameters (bind the values to the placeholders)

        preparedStatement.setString(1, petitionerNameField.getText());   // Set Petitioner Name
        preparedStatement.setString(2, petitionerDobField.getText());    // Set Petitioner Date of Birth
        preparedStatement.setString(3, petitionerAlienRegField.getText()); // Set Petitioner Alien Registration Number
        preparedStatement.setString(4, relativeStatusField.getText());
        preparedStatement.setString(5, relativeNameField.getText());    // Set Relative Name
        preparedStatement.setString(6, relativeDobField.getText());     // Set Relative Date of Birth
        preparedStatement.setString(7, relativeNationalityField.getText()); // Set Relative Nationality
        preparedStatement.setString(8, relativeAlienRegField.getText()); // Set Relative Alien Registration Number
        preparedStatement.setInt(9, formID);    
          // Set Relative Status

        // Execute the update query
        int rowsUpdated = preparedStatement.executeUpdate();

        if (rowsUpdated > 0) {
            System.out.println("Record updated successfully.");
        } else {
            System.out.println("No records found with the given ID.");
        }
    } catch (SQLException e) {
        // Handle SQL exceptions (e.g., connection issues, query errors)
        e.printStackTrace();
    } finally {
        // Close resources to prevent memory leaks
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

}
