package edu.gmu.cs321;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;
/**
 * Review is responsible for Review step
 */
public class Review {
    /**
     * object variables
     */
    private ImmForm immForm;
    public WorkflowStaging workflow = new WorkflowStaging();
    public DatabaseConnection dbConnection;
    private int formID = 1;
    private Dotenv dotenv=Dotenv.configure().load();

    //Constructor
    public Review() {
        this.immForm = immForm;
        dotenv = Dotenv.configure().load();
        dbConnection = new DatabaseConnection();
        dbConnection.setUser(dotenv.get("USER"));
        dbConnection.setDbUrl(dotenv.get("DB_URL"));
        dbConnection.setPassword(dotenv.get("PASS"));

    }

    // Method to populate form fields with data from the database
    public Object[] getFormData(int formID) {
        String query = "SELECT * FROM People WHERE id ="+formID;
        return dbConnection.queryDatabase(query);
    }

    // Method to update the form in the database
    public void updateForm(int formID, String petitionerName, String petitionerDob, String petitionerAlienReg,
                           String relativeStatus, String relativeName, String relativeDob, String relativeNationality,
                           String relativeAlienReg) {

        String updateQuery = "UPDATE People SET " +
                "petitioner_name = ?, " +
                "petitioner_dob = ?, " +
                "petitioner_ssn = ?, " +
                "relative_status = ?, " +
                "relative_name = ?, " +
                "relative_dob = ?, " +
                "relative_nationality = ?, " +
                "relative_alien_reg = ? " +
                "WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(dotenv.get("DB_URL"), dotenv.get("USER"), dotenv.get("PASS"));
             PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

            preparedStatement.setString(1, petitionerName);
            preparedStatement.setString(2, petitionerDob);
            preparedStatement.setString(3, petitionerAlienReg);
            preparedStatement.setString(4, relativeStatus);
            preparedStatement.setString(5, relativeName);
            preparedStatement.setString(6, relativeDob);
            preparedStatement.setString(7, relativeNationality);
            preparedStatement.setString(8, relativeAlienReg);
            preparedStatement.setInt(9, formID);

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Record updated successfully.");
            } else {
                System.out.println("No records found with the given ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to add form to the workflow for approval
    public void addFormToWorkflow(int formID) {
        int result = workflow.addApproval(formID);
        if (result == 0) {
            System.out.println("Form successfully added to workflow.");
        } else {
            System.out.println("Error adding form to workflow: " + result);
        }
    }
    // Method to get the next form in the workflow
    public int getNextFormInWorkflow() {
        formID++;
        return formID;
         // return workflow.getNextReviewerWFItem();
    }
}