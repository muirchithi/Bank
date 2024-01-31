package com.bank;

import com.bank.ui.LoginUi;
import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyApplication {

        private static String[] savedArgs;

    public static void main(String[] args){
        savedArgs = args;
        Application.launch(LoginUi.class,args);
    }

    public static void initSpring(){
        SpringApplication.run(MyApplication.class, savedArgs);
    }
}
