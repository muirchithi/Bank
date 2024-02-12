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

public class CustomerTransactionsLandingPage extends Application {
    private CustomerServiceImpl customer;
    private Account transactionSender;
    private Account transactionReceiver;
    private Account SenderTransactionHistory;


    @Override
    public void init() throws Exception{
        super.init();
        BankApplication.initSpring();
    }

    @Override
    public void start(Stage primaryStage){

        primaryStage.setTitle("/Customer-Transactions");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));











        Scene scene = new Scene(grid,300,400);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
