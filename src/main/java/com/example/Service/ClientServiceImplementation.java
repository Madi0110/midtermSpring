package com.example.Service;

import com.example.Bank.Client;
import com.example.Bank.ClientRepository;
import com.example.Players.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientServiceImplementation implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public void save(Client client) {
        clientRepository.save(client);
    }

    @Override
    public void withdraw(Client client, Double price) {
        client.setCash(client.getCash() - price);
        this.save(client);
    }
}
