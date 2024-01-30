package com.bank.account;

import com.bank.customer.Customer;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class Account {

    private int accountNumber;
    private int accountType;
    private double accountBalance;
    private int customerNumber;
    private double interestRate = 0.01;
    private ArrayList<Transaction> transactions;
    private LocalDate dateOpened;
    private boolean accountFrozen;
    private boolean accountRestricted;

    public Account(int accountNumber, double balance, Customer customer, Customer frozen, int accountType){
        this.dateOpened = LocalDate.now();
        this.accountNumber = accountNumber;
        this.accountBalance = balance;
        this.customerNumber = customer.getCustomerNumber();
        this.transactions = new ArrayList<>();
        this.accountFrozen = customer.getFrozen();
        this.accountRestricted = customer.getRestricted();

    }

    public int getAccountNumber(){
        return accountNumber;
    }

    public int getAccountType(){
        return accountType;
    }

    public double getAccountBalance(){
        return accountBalance;
    }

    public double getInterestRate(){
        return interestRate;
    }

    public ArrayList getTransactions(){
        return transactions;
    }

    public boolean getAccountFrozen(){
        return accountFrozen;
    }

    public boolean getAccountRestricted(){
        return accountRestricted;
    }

    public LocalDate getDateOpened(){
        return dateOpened;
    }



}
