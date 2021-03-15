package com.example.Service;

import com.example.Bank.Client;
import com.example.Bank.ClientRepository;
import com.example.Players.Players;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface ClientService  {
    List<Client> findAll();
    void save(Client client);
    void withdraw(Client client, Double price);

}
