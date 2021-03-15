package com.example;

import ch.qos.logback.core.net.server.Client;
import com.example.Bank.Bank;
import com.example.Bank.Proxy;
import com.example.Players.Players;
import com.example.Players.PlayersType;
import com.example.Service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        context.scan("com.example");
//        context.refresh();
//        Bank bank = context.getBean("bankService1", Bank.class);
//        Random rand = new Random();
//
//        Client client = (Client) bank.getClients().get(rand.nextInt(bank.getClients().size()));
//        Proxy Bank = new Bank(bank, client);
//        ((AnnotationConfigApplicationContext) context).close();
    }

 Scanner scan = new Scanner(System.in);

    int withdraw;
    @Autowired
    ServiceInterface ServiceInterface;

    @PostConstruct
    public void showMenu() {
        int choice = 0;
        while (choice != 5) {
            int i = 0;
            System.out.println("Welcome to football club Liverpool!");
            System.out.println("1. Transfer");
            System.out.println("2. List of players");
            System.out.println("3. Buy ticket");
            System.out.println("4. Change salary of player");
            System.out.println("5. Exit");
            choice = scan.nextInt();

            switch (choice) {
                case 1: {
                    System.out.println("Choose one: ");
                    System.out.println("1.On rent ");
                    System.out.println("2.Future purchase");
                    System.out.println("3. Current player");

                    Scanner sc = new Scanner(System.in);
                    int x = sc.nextInt();

                    if (x == 1) {
                        List<Players> players = ServiceInterface.getByType(PlayersType.ONRENT);
                        for (Players player : players) {
                            System.out.println(player.getName() + ": " + player.getFixedSalary() + "$");
                            i++;
                        }
                    } else if (x == 2) {
                        List<Players> players;
                        players = ServiceInterface.getByType(PlayersType.FUTUREBUY);
                        for (Players player : players) {
                            System.out.println(player.getName() + ": " + player.getFixedSalary() + "$");
                            i++;
                        }
                    } else if (x == 3) {
                        List<Players> players;
                        players = ServiceInterface.getByType(PlayersType.CURRENTPL);
                        for (Players player : players) {
                            System.out.println(player.getName() + ": " + player.getFixedSalary() + "$");
                            i++;
                        }
                    }
                }
            break;

                case 2: {
                    List<Players> players = ServiceInterface.findAll();
                    for (Players player : players) {
                        String name = player.getName();
                        long id = player.getId();
                        System.out.println("id:" + id + " " + name + " " + player.getSurname() + " Type : " + player.getPlType());
                        System.out.println();
                    }
                }
                break;

                case 3: {

                    System.out.println("The next match of Liverpool will be vs Arsenal");
                    System.out.println("The ticket cost 20$");
                    System.out.println("To buy a ticket go to ATM system");

                    System.out.println("Welcome to ATM " );
                    System.out.println("1.Withdraw");
                    System.out.println("2.Check Balance");
                    System.out.println("3.EXIT");

                    System.out.print("Choose the operation you want to perform:");

                   int n = scan.nextInt();

                    switch (n) {

                        case 1:
                            System.out.print("Enter money to be withdrawn:");

                            withdraw = scan.nextInt();
                           // Bank.withdraw(withdraw);

                            break;
                        case 2:

                            System.out.println("Balance : ");

                            System.out.println("");

                            break;
                        case 4:

                            System.exit(0);
                    }

         }
                break;

                case 4: {

                    System.out.println("id: ");
                    int id = scan.nextInt();
                    System.out.println("New salary: ");
                    double salary = scan.nextDouble();
                    ServiceInterface.changeSalary(id,salary);
                }
                break;

                default: {
                }







            }


                }
            }

        }


