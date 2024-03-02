package com.bank.ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.time.LocalDate;

import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.support.ScopeNotActiveException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class CustomerCreationController {

    @FXML
    private TextField firstNameInput;
    @FXML
    private Label firstNameError;
    @FXML
    private TextField lastnameInput;
    @FXML
    private Label lastNameError;
    @FXML
    private TextField dateOfBirthInput;
    @FXML
    private Label dateOfBirthError;
    @FXML
    private TextField addressInput;
    @FXML
    private Label addressInputError;
    @FXML
    private TextField emailInput;
    @FXML
    private Label emailError;
    @FXML
    private TextField phoneNumberInput;
    @FXML Label phoneNumberError;

    @FXML
    public void handleInputvalidation(){
        String firstNameText = firstNameInput.getText();
        String lastNameText = lastnameInput.getText();
        String dateOfBirthText = dateOfBirthInput.getText();
        String addressText = addressInput.getText();
        String emailText = emailInput.getText();
        String phoneNumberText = phoneNumberInput.getText();

        //Initial first name validation
        if(firstNameText != null && !firstNameText.trim().isEmpty()) {
            if (!firstNameText.matches("^[A-Za-z]+$")) {
                firstNameError.setText("Invalid first name.");
                firstNameError.setVisible(true);
                firstNameError.setStyle("-fx-border-color: red;");
            }
            else{
                firstNameError.setVisible(false);
                firstNameError.setStyle("");

            }
        } else {
            firstNameError.setText("First name is mandatory.");
            firstNameError.setVisible(true);
            firstNameInput.setStyle("-fx-border-color: red;");
        }
        //Initial last name validation
        if(lastNameText != null && !lastNameText.trim().isEmpty()){
            if(lastNameText.matches("^[A-Za-z]+$")) {
                lastNameError.setText("Invalid last name.");
                lastNameError.setVisible(true);
                lastNameError.setStyle("-fx-border-color: red;");
            }
            else{
                lastNameError.setVisible(false);
                lastNameError.setStyle("");
            }
        } else{
            lastNameError.setText("Last name is mandatory.");
            lastNameError.setVisible(true);
            lastnameInput.setStyle("-fx-border-color: red;");
        }
        // Initial date of birth validation
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate dateOfBirth = LocalDate.parse(dateOfBirthText, formatter);

            LocalDate checkIfAdult = LocalDate.now().minusYears(18);
            if(!dateOfBirth.isAfter(LocalDate.now()) && dateOfBirth.isBefore(checkIfAdult)){
                dateOfBirthError.setVisible(false);
                dateOfBirthError.setStyle("");
            } else {
                dateOfBirthError.setText("You must be at least 18 years old");
                dateOfBirthError.setVisible(true);
                dateOfBirthError.setStyle("-fx-border-color: red;");
            }

        } catch (DateTimeParseException e){
            dateOfBirthError.setText("Invalid date format. Please use DD.MM.YYYY");
            dateOfBirthError.setVisible(true);
            dateOfBirthError.setStyle("-fx-border-color: red;");
        }

        //Initial validation of the address
        if(addressText != null && !addressText.trim().isEmpty()) {
            addressInputError.setVisible(false);
            addressInputError.setStyle("");
        }
        else {
            addressInputError.setText("Please provide a valid address");
            addressInputError.setVisible(true);
            addressInputError.setStyle("-fx-border-color: red;");
        }

        //Initial Email validation
        if(emailText != null && !emailText.trim().isEmpty()){
            if(!emailText.matches("^[A-Za-z0-9]{3,}@[A-Za-z0-9]{2,}\\.[A-Za-z]{2,}$")) {
                emailError.setText("Please provide a valid email");
                emailError.setVisible(true);
                emailError.setStyle("-fx-border-color: red;");
            }
        else{
            emailError.setVisible(false);
            emailError.setStyle("");
        }
        } else{
            emailError.setText("Email is mandatory.");
            emailError.setVisible(true);
            emailError.setStyle("-fx-border-color: red;");
        }
        // Initial phone number validation
        if(phoneNumberText != null && !phoneNumberText.trim().isEmpty()) {
            String digits = phoneNumberText.replace("[^0-9]", "");
            if (digits.length() >= 10) {
                    phoneNumberError.setText("Please provide a valid phone number");
                    phoneNumberError.setVisible(true);
                    phoneNumberError.setStyle("-fx-border-color: red;");
            } else {
                phoneNumberError.setVisible(false);
                phoneNumberError.setStyle("");
            }
        }else{
            phoneNumberError.setText("Phone number is mandatory.");
            phoneNumberError.setVisible(true);
            phoneNumberError.setStyle("-fx-border-color: red;");
        }}

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
