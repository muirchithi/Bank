package com.bank.ui;

import com.bank.ui.view.LoginUi;
import com.bank.ui.view.CustomerCreationIU;
import javafx.application.Application;
import org.springframework.boot.builder.SpringApplicationBuilder;
import com.bank.BankApplication;
import javafx.stage.Stage;

public class JavaFXApplication extends Application {

    private static String[] savedArgs;

    @Override
    public void init() throws Exception{
        SpringApplicationBuilder builder = new SpringApplicationBuilder(BankApplication.class);
        builder.headless(false);
        builder.run(savedArgs);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        //LoginUi loginUi = new LoginUi();
        //loginUi.start(primaryStage);

        CustomerCreationIU customerUi = new CustomerCreationIU();
        customerUi.start(primaryStage);
    }

    public static void main(String[] args){
        savedArgs = args;
        launch(args);
    }

}
