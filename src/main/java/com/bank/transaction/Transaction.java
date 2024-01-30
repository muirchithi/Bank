package com.bank.transaction;

import jdk.jfr.Description;

import javax.management.Descriptor;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Transaction {

    public int transactionId;
    private LocalDateTime transactionDateTime;
    private String transactionDescription;
    private double transactionAmount;


    public Transaction(int transactionId, LocalDateTime transactionDateTime, String transactionDescription, double transactionAmount){
        this.transactionId = transactionId;
        this.transactionDateTime = transactionDateTime;
        this.transactionDescription = transactionDescription;
        this.transactionAmount = transactionAmount;
    }

    public int getTransactionId(){
        return transactionId;
    }

    public LocalDateTime getTransactionDateTime(){
        return transactionDateTime;
    }

    public String getTransactionDescription(){
        return transactionDescription;
    }

    public double getTransactionAmount(){
        return transactionAmount;
    }

    @Override
    public String toString(){
        return "Transaction ID: " + transactionId +
                "\nDate and Time: " + transactionDateTime +
                "\nDescription: " +  transactionDescription +
                "\nTransaction amount: " + transactionAmount;
    }
}
