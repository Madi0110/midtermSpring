package com.example.Service;

import com.example.Players.Players;
import com.example.Players.PlayersType;

import java.util.List;

public interface ServiceInterface {
    void create(Players player);
    List<Players> findAll();
    List<Players> getByType(PlayersType playersType);
    Players findById(long id);
    void save(Players employee);
    void changeSalary(long id, double salary);

}
