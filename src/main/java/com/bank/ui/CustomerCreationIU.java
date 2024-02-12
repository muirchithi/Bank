//packages
package com.bank.ui;

//imports

import com.bank.BankApplication;
import com.bank.entity.CustomerServiceImpl;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.function.Consumer;

public class CustomerCreationIU extends Application{

    //Field definitions
    private final CustomerServiceImpl customer = new CustomerServiceImpl();
    private TextField inputFirstName;
    private TextField inputLastName;
    private TextField inputDateOfBirth;
    private TextField inputAddress;
    private TextField inputEmail;
    private TextField inputPhoneNumber;
    private Text actionTarget;

    private final BooleanProperty firstNameValid = new SimpleBooleanProperty(false);
    private final BooleanProperty lastNameValid = new SimpleBooleanProperty(false);
    private final BooleanProperty dateOfBirthValid = new SimpleBooleanProperty(false);
    private final BooleanProperty addressValid = new SimpleBooleanProperty(false);
    private final BooleanProperty emailValid = new SimpleBooleanProperty(false);
    private final BooleanProperty phoneNumberValid = new SimpleBooleanProperty(false);

    //Overrides
    @Override
    public void init() throws Exception{
        super.init();
        BankApplication.initSpring();
    }

    @Override
    public void start(Stage primaryStage){

        inputFirstName = new TextField();
        inputLastName = new TextField();
        inputDateOfBirth = new TextField();
        inputAddress = new TextField();
        inputEmail = new TextField();
        inputPhoneNumber = new TextField();
        actionTarget = new Text();

        primaryStage.setTitle("/Sign-Up");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));

        Text sceneTitle = new Text("Sign-Up");
        grid.add(sceneTitle, 0, 0, 2,1);

        Label firstName = new Label("First name: ");
        grid.add(firstName, 0,1);
        TextField inputFirstname = new TextField();
        inputFirstname.textProperty().addListener(createValidationListener(inputFirstname, this::validateFirstName, firstNameValid));
        grid.add(inputFirstname,1,1);

        Label lastName = new Label("Last name: ");
        grid.add(lastName,0,2);
        TextField inputLastName = new TextField();
        inputLastName.textProperty().addListener(createValidationListener(inputLastName, this:: validateLastName, lastNameValid));
        grid.add(inputLastName,1,2);

        Label dateOfBirth = new Label("Date of birth: ");
        grid.add(dateOfBirth,0,3);
        TextField inputDateOfBirth = new TextField();
        inputDateOfBirth.textProperty().addListener(createValidationListener(inputDateOfBirth, this:: validateDateOfBirth, dateOfBirthValid));
        grid.add(inputDateOfBirth,1,3);

        Label address = new Label("Address: ");
        grid.add(address,0,4);
        TextField inputAddress = new TextField();
        inputAddress.textProperty().addListener(createValidationListener(inputAddress, this::validateAddress, addressValid));
        grid.add(inputAddress,1,4);

        Label email = new Label("E-Mail address: ");
        grid.add(email,0,5);
        TextField inputEmail = new TextField();
        inputEmail.textProperty().addListener(createValidationListener(inputEmail, this:: validateEmail, emailValid));
        grid.add(inputEmail,1,5);

        Label phoneNumber = new Label("Phone number: ");
        grid.add(phoneNumber,0,6);
        TextField inputPhoneNumber = new TextField();
        inputPhoneNumber.textProperty().addListener(createValidationListener(inputPhoneNumber, this:: validatePhoneNumber, phoneNumberValid));
        grid.add(inputPhoneNumber, 1,6);


        Button signUpButton = new Button("Sign Up");
        signUpButton.disableProperty().bind(
                Bindings.createBooleanBinding(() ->
                                !firstNameValid.get() || !lastNameValid.get() ||
                                        !dateOfBirthValid.get() || !addressValid.get() ||
                                        !emailValid.get() || !phoneNumberValid.get(),
                        firstNameValid, lastNameValid, dateOfBirthValid,
                        addressValid, emailValid, phoneNumberValid)
        );


        signUpButton.setOnAction(e -> handleSignUp());
        grid.add(signUpButton, 2,7);
        actionTarget = new Text();
        grid.add(actionTarget,1,6);


        Scene scene = new Scene(grid,400,300);
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    private void handleSignUp(){

        boolean allInputsValid = true;

        try{
            customer.setFirstName(inputFirstName.getText());
            customer.setLastName(inputLastName.getText());
            customer.setDateOfBirth(LocalDate.parse(inputDateOfBirth.getText()));
            customer.setAddress(inputAddress.getText());
            customer.setEmail(inputEmail.getText());
            customer.setPhoneNumber(inputPhoneNumber.getText());
        } catch (IllegalArgumentException e){
            allInputsValid = false;
            actionTarget.setText(e.getMessage());
        }

        if(allInputsValid) {
            actionTarget.setText("All inputs are valid");
        } else{
            actionTarget.setText("Please correct the highlighted fields.");
        }
    }

    private ChangeListener<String> createValidationListener(TextField field, Consumer<String> validationMethod, BooleanProperty validationProperty){
        return (observable, oldValue, newValue) -> {
            field.setStyle("");
            try {
                validationMethod.accept(newValue);
                validationProperty.set(true);
            } catch(IllegalArgumentException e){
                field.setStyle("-fx-border-color: red;");
                actionTarget.setText(e.getMessage());
            }
        };
    }

    private void validateFirstName(String newValue){
        customer.setFirstName(newValue);
        firstNameValid.set(true);
    }

    private void validateLastName(String newValue){
        customer.setLastName(newValue);
        lastNameValid.set(true);
    }

    private void validateDateOfBirth(String newValue){
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate date = LocalDate.parse(newValue, formatter);
            customer.setDateOfBirth(date);
            dateOfBirthValid.set(true);

        } catch (DateTimeParseException e){
            dateOfBirthValid.set(false);
        }
        customer.setDateOfBirth(LocalDate.parse(newValue));
        dateOfBirthValid.set(true);
    }

    private void validateAddress(String newValue){
        customer.setAddress(newValue);
        addressValid.set(true);
    }

    private void validateEmail(String newValue){
        customer.setEmail(newValue);
        emailValid.set(true);
    }

    private void validatePhoneNumber(String newValue){
        customer.setPhoneNumber(newValue);
        phoneNumberValid.set(true);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
