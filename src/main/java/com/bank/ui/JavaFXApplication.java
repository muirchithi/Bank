package com.bank.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JavaFXApplication extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        StackPane root = new StackPane();

        Button btn = new Button("click me");

        root.getChildren().add(btn);

        Scene scene = new Scene(root, 900, 650);

        primaryStage.setScene(scene);

        primaryStage.setTitle("My App");

        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
