package com.bank;

import com.bank.ui.AccountCreationIU;
//import com.bank.ui.LoginUi;
import com.bank.ui.ProfileLandingPage;
import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyApplication {

        private static String[] savedArgs;

    public static void main(String[] args){
        savedArgs = args;
        Application.launch(ProfileLandingPage.class,args);
    }

    public static void initSpring(){
        SpringApplication.run(MyApplication.class, savedArgs);
    }
}
