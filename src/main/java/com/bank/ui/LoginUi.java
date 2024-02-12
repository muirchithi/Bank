package com.bank.ui;

import com.bank.BankApplication;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginUi extends Application {

    @Override
    public void init() throws Exception{
        super.init();
        BankApplication.initSpring();
    }

    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("/Login");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text sceneTitle = new Text("Login ");
        grid.add(sceneTitle, 0, 0, 2, 1);

        Label username = new Label("Username: ");
        grid.add(username, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1,1);

        Label pw = new Label("Password: ");
        grid.add(pw, 0,2 );

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox,1,2);

        Button btnSignIn = new Button("Sign in");
        Button btnSignUp =  new Button("Sign up");

        HBox hbBtn = new HBox(10);

        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().addAll(btnSignIn, btnSignUp);
        grid.add(hbBtn,1,4);



        final Text actionTarget = new Text();
        grid.add(actionTarget,1,6);
         // handle login
        btnSignIn.setOnAction(e ->{

        });

        btnSignUp.setOnAction(e ->{});
        Scene scene = new Scene(grid,400,300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
