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
    private TextField firstName;
    @FXML
    private TextField lastname;
    @FXML
    private TextField dateOfBirth;
    @FXML
    private TextField address;
    @FXML
    private TextField email;
    @FXML
    private TextField phoneNumber;

    @FXML
    public void handleInputvalidation(){
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
