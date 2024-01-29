package com.bank.customer;

import com.sun.xml.internal.bind.v2.TODO;

import java.time.LocalDate;
import java.util.Locale;

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
    private boolean restricted = false;
    private boolean frozen = false;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName != null && !firstName.trim().isEmpty()) {
            if (firstName.matches("^[A-Za-z]+$")) {
                this.firstName = firstName;
            } else {
                throw new IllegalArgumentException("Invalid first name. \n The first name can only consist of roman letters.");
            }
        } else{
            throw new IllegalArgumentException("First name is mandatory. Please provide a first name.");
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName != null && !lastName.trim().isEmpty()){
        if(lastName.matches("^[A-Za-z]+$")) {
            this.lastName = lastName;
        }
        else{
            throw new IllegalArgumentException("Invalid last name. \n The last name can only consist of roman letters");
        }}
        else{
            throw new IllegalArgumentException("Last name is mandatory. Please provide a last name.");
        }
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        if(dateOfBirth != null && !dateOfBirth.toString().trim().isEmpty()){
        LocalDate checkIfAdult = LocalDate.now().minusYears(18);
        if(!dateOfBirth.isAfter(LocalDate.now()) && (dateOfBirth.isBefore(checkIfAdult))){
        this.dateOfBirth = dateOfBirth;
        }
        else{
            throw new IllegalArgumentException("Invalid date of birth. \n Please enter a valid date of birth.");
        }}
        else{
            throw new IllegalArgumentException("Date of birth is mandatory. Please provide a date of birth.");
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if(address != null && !address.trim().isEmpty()){
        this.address = address;}
        else{
            throw new IllegalArgumentException("An address is required. Please provide an address.");
        }
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        if(email != null && !email.trim().isEmpty()){
        if(email.matches("^[A-Za-z0-9]{3,}@[A-Za-z0-9]{2,}\\.[A-Za-z]{2,}$")){
        this.email = email;}
        else{
            throw new IllegalArgumentException("The format of the email is not valid. \n Please provide an email with a valid format.");
        }}
        else{
            throw new IllegalArgumentException("An email address is required. Please provide an email address.");
            }
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if(phoneNumber != null && !phoneNumber.trim().isEmpty()){
        String digits = phoneNumber.replace("[^0-9]","");
        if (digits.length() >= 10) {
            this.phoneNumber = phoneNumber;
        }
        else{
            throw new IllegalArgumentException("This phone number is not valid. Please enter a valid phone number.");
        }}
        else{
            throw new IllegalArgumentException("A phone number is required. Please provide a phone number.");
        }
    }

    // Todo customerNumber needs to be created when creating the customers account
    // Todo there should be no possibility to adjust the customer number after
    public int getCustomerNumber() {
        return customerNumber;
    }


    public boolean getRestricted(){
        return restricted;
    }

    public void setRestricted(boolean restricted){
        // Todo what would be requirements for the restriction?
        this.restricted = restricted;
    }

    public boolean getFrozen(){
        return frozen;
    }

    public void setFrozen(boolean frozen){
        // Todo what would be requirements to freeze an account?
        this.frozen = frozen;
    }
}



