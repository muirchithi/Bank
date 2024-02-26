package com.bank.ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.beans.factory.support.ScopeNotActiveException;

public class CustomerCreationController {

    @FXML
    private TextField firstNameInput;
    @FXML
    private TextField lastnameInput;
    @FXML
    private TextField dateOfBirthInput;
    @FXML
    private TextField addressInput;
    @FXML
    private TextField emailInput;
    @FXML
    private TextField phoneNumberInput;

    @FXML
    public void handleInputvalidation(){
        String firstNameText = firstNameInput.getText();
        String lastNameText = lastnameInput.getText();
        String dateOfBirthText = dateOfBirthInput.getText();
        String addressText = addressInput.getText();
        String emailText = emailInput.getText();
        String phoneNumberText = phoneNumberInput.getText();

        if(firstNameText != null && !firstNameText.trim().isEmpty()) {
            if (firstNameText.matches("^[A-Za-z]+$")) {

            } else {
                throw new IllegalArgumentException("Invalid first name. \n The first name can only consist of roman letters.");
            }
        } else{
            throw new IllegalArgumentException("First name is mandatory. Please provide a first name.");
        }

    }

    @FXML
    public void routeToLogIn(ActionEvent event){
        try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/bank/ui/view/LoginUi.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        } catch (Exception e){
        e.printStackTrace();
        }
    }

}
