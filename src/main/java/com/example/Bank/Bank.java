package com.example.Bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.*;
import java.util.List;
import java.util.Scanner;

@Component
public class Bank implements Proxy {
    private List<Client> clients;
    private Connection connection;
    private Statement statement;

    public Bank(Bank bank, ch.qos.logback.core.net.server.Client client) {
    }


    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    Client client;
    Bank bank;


    @Override
    public void withdraw(int cash) {
//        if (checkPin(client.getPin())) {
//            if (client.getCash() >= cash) {
//                try {
//                    Double total = client.getCash() - cash;
//                    String query = "update acc set cash = '" + total + "' where id = " + client.getId();
//                    statement = connection.createStatement();
//                    statement.executeUpdate(query);
//                }
//                catch (Exception e){
//                    System.out.println(e);
//                }
//                System.out.println("Please collect your money");
//                client.setCash(client.getCash() - cash);
//            }
//
//        } else{
//            System.out.println("Incorrect PIN");
//        }
    }
    public boolean checkPin(String pin){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the pin:");
        String pin2 = scan.next();

        if (pin.equals(pin2)){
            return true;
        } else{
            return false;
        }
    }




}
