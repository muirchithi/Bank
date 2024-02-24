package com.bank.ui.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginUi extends Application {

    @Override
    public void init() throws Exception{
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws  Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/bank/ui/view/LoginUi.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args){
        launch(args);
    }
}
