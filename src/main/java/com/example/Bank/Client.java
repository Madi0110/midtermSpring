package com.example.Bank;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "clients")
@Component
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surName;
    private String card;
    private String pin;
    private Double cash;



    public Client(String name, String surName, String card, String pin, Double cash, Integer id) {
        this.name = name;
        this.surName = surName;
        this.card = card;
        this.pin = pin;
        this.cash = cash;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
