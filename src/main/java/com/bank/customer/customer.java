package com.bank.customer;

import java.time.LocalDate;

public class customer {
    // person related information
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    // contact related information
    private String address;
    private String email;
    private String phoneNumber;
    // account related information
    private int customerNumber;
    private boolean restricted;
    private boolean frozen;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName.matches("^[A-Za-z]+$")) {
            this.firstName = firstName;
        }
        else{
            throw new IllegalArgumentException("Invalid first name. \n The first name can only consist of roman letters.");
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName.matches("^[A-Za-z]+$")) {
            this.lastName = lastName;
        }
        else{
            throw new IllegalArgumentException("Invalid last name. \n The last name can only consist of roman letters");
        }
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        if(!dateOfBirth.isAfter(LocalDate.now())){
        this.dateOfBirth = dateOfBirth;
        }
        else{
            throw new IllegalArgumentException("Invalid date of birth. \n Please enter a valid date of birth.");
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        if(email.matches("^[A-Za-z0-9]{3,}@[A-Za-z0-9]{2,}\\.[A-Za-z]{2,}$"))
        this.email = email;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public int getCustomerNumber(){
        return customerNumber;
    }

    public boolean getRestricted(){
        return restricted;
    }

    public void setRestricted(boolean restricted){
        this.restricted = restricted;
    }

    public boolean getFrozen(){
        return frozen;
    }

    public void setFrozen(boolean frozen){
        this.frozen = frozen;
    }
}



