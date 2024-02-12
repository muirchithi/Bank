package com.bank.entity;

import java.time.LocalDateTime;

public class Transaction {

    public int transactionId;
    private LocalDateTime transactionDateTime;
    private String transactionDescription;
    private double transactionAmount;
    private int senderAccountNumber;
    private int receiverAccountNumber;


    public Transaction(int transactionId,
                       LocalDateTime transactionDateTime,
                       String transactionDescription,
                       double transactionAmount,
                       int senderAccountNumber,
                       int receiverAccountNumber){
        this.transactionId = transactionId;
        this.transactionDateTime = transactionDateTime;
        this.transactionDescription = transactionDescription;
        this.transactionAmount = transactionAmount;
        this.senderAccountNumber = senderAccountNumber;
        this.receiverAccountNumber = receiverAccountNumber;
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

    public int getSenderAccountNumber(){return senderAccountNumber;}

    public int getReceiverAccountNumber(){return receiverAccountNumber;}

    @Override
    public String toString(){
        return "Transaction ID: " + transactionId +
                "\n Sender ID: " +  senderAccountNumber +
                "\n Receiver ID: " + receiverAccountNumber +
                "\nDate and Time: " + transactionDateTime +
                "\nDescription: " +  transactionDescription +
                "\nTransaction amount: " + transactionAmount;
    }
}
