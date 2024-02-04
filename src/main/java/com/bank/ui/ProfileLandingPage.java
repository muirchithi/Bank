//packages
package com.bank.ui;

//imports

import com.bank.MyApplication;
import com.bank.customer.Customer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ProfileLandingPage extends Application {
    private Customer customer;
    private Text actionTarget;

    @Override
    public void init() throws Exception{
        super.init();
        MyApplication.initSpring();
    }

    @Override
    public void start(Stage primaryStage){

        primaryStage.setTitle("Customer Profile");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text sceneTitle = new Text("Customer");
        grid.add(sceneTitle,0,0,2,1);

        Label firstName = new Label("First name");
        Label firstNameValue = new Label();
        if(customer != null){
            firstNameValue.setText(customer.getFirstName());
        }
        else{
            firstNameValue.setText("N/A");

        }
        grid.add(firstName, 0,1);
        grid.add(firstNameValue,1,1);

        Label lastName = new Label("Last name");
        Label lastNameValue = new Label();
        if(customer != null){
        lastNameValue.setText(customer.getLastName());}
        else{
            lastNameValue.setText("N/A");
        }
        grid.add(lastName,0,2);
        grid.add(lastNameValue,1,2);

        Label dateOfBirth = new Label("Date of birth");
        Label dateOfBirthValue = new Label();
        if(customer != null){
        dateOfBirthValue.setText(String.valueOf(customer.getDateOfBirth()));}
        else{
            dateOfBirthValue.setText("N/A");
        }
        grid.add(dateOfBirth,0,3);
        grid.add(dateOfBirthValue,1,3);

        Label address = new Label("Address");
        Label addressValue = new Label();
        if(customer != null){
        addressValue.setText(customer.getAddress());}
        else{
            addressValue.setText("N/A");
        }
        grid.add(address,0,4);
        grid.add(addressValue,1,4);

        Label email = new Label("Email");
        Label emailValue = new Label();
        if(customer != null){
        emailValue.setText(customer.getEmail());}
        else{
            emailValue.setText("N/A");
        }
        grid.add(email,0,5);
        grid.add(emailValue,1,5);

         Label phoneNumber = new Label("Phone number");
         Label phoneNumbervalue = new Label();
         if(customer != null){
         phoneNumbervalue.setText(customer.getPhoneNumber());}
         else {
             phoneNumbervalue.setText("N/A");
         }
         grid.add(phoneNumber,0,6);
         grid.add(phoneNumbervalue,1,6);

         final Text actionTarget = new Text();
         Scene scene = new Scene(grid,400,300);
         primaryStage.setScene(scene);
         primaryStage.show();
    }


}
