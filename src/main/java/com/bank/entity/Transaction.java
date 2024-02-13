package com.bank.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int transactionId;

    private int senderAccountNumber;
    private int receiverAccountNumber;
    private double transactionAmount;
    private LocalDateTime transactionDateTime;
    private String transactionDescription;

    @ManyToOne
    @JoinColumn(name = "accountNumber", insertable = false, updatable = false)
    private Account account;
}