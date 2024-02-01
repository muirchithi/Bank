package com.bank.ui;


import com.bank.MyApplication;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AccountCreation extends Application{

    @Override
    public void init() throws Exception{
        super.init();
        MyApplication.initSpring();
    }

    @Override
    public void start(Stage primaryStage){
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

        TextField InputFirstname = new TextField();
        grid.add(InputFirstname,1,1);

        Label lastName = new Label("Last name: ");
        grid.add(lastName,0,2);

        TextField InputLastName = new TextField();
        grid.add(InputLastName,1,2);

        Label dateOfBirth = new Label("Date of birth: ");
        grid.add(dateOfBirth,0,3);

        TextField InputDateOfBirth = new TextField();
        grid.add(InputDateOfBirth,1,3);

        Label email = new Label("E-Mail address: ");
        grid.add(email,0,4);

        TextField InputEmail = new TextField();
        grid.add(InputEmail,1,4);

        Label phoneNumber = new Label("Phone number: ");
        grid.add(phoneNumber,0,5);

        TextField inputPhoneNumber = new TextField();
        grid.add(inputPhoneNumber, 1,5);


        final Text actionTarget = new Text();
        grid.add(actionTarget,1,6);

        Scene scene = new Scene(grid,400,300);
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}
