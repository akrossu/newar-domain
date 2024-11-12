package org.openfx;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    private void createScene(ActionEvent event, String file) throws IOException {
        root = FXMLLoader.load(getClass().getResource(file + "-view.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
    }

    @FXML
    public void onDataEntryButtonClick(ActionEvent event) throws IOException {
        createScene(event, "dataEntry");
        stage.setTitle("Data Entry");
        stage.show();
    }

    @FXML
    public void onReviewButtonClick(ActionEvent event) throws IOException {
        createScene(event, "reviewer");
        stage.setTitle("Reviewer");
        stage.show();
    }

    @FXML
    public void onApproveButtonClick(ActionEvent event) throws IOException {
        createScene(event, "approver");
        stage.setTitle("Approver");
        stage.show();
    }

    @FXML
    public void onLogoutButtonClick(ActionEvent event) throws IOException {
        createScene(event, "login");
        stage.setTitle("Login");
        stage.show();
    }

    public boolean onVerifyButtonClick(ActionEvent event) {
        return true;
    }

    public boolean onSaveButtonClick(ActionEvent event) {
        return true;
    }

    public boolean onEmailButtonClick(ActionEvent event) {
        return true;
    }

    public Scene getScene() {
        return scene;
    }
}