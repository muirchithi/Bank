package com.bank.ui;

import com.bank.BankApplication;
import com.bank.entity.Account;
import com.bank.entity.CustomerServiceImpl;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CustomerAccountOverviewLandingPage extends Application {
    private CustomerServiceImpl customer;
    private Account accounts;
    @Override
    public void init() throws Exception{
        super.init();
        BankApplication.initSpring();
    }

    @Override
    public void start(Stage primaryStage){

        primaryStage.setTitle("Account Overview");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(25, 25, 25,25));



        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
