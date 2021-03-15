package com.example.Service;
import com.example.Players.Players;
import com.example.Players.PlayersType;
import com.example.Event.SalaryChangeEvent;
import com.example.Players.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import java.util.List;

@org.springframework.stereotype.Service
public class Service implements ServiceInterface, ApplicationEventPublisherAware {
    @Autowired
    private PlayerRepository playersRepository;
    private ApplicationEventPublisher eventPublisher;
    @Override
    public void create(Players players) {
        playersRepository.save(players);
    }

    @Override
    public List<Players> findAll() {
        return playersRepository.findAll();
    }

    @Override
    public List<Players> getByType(PlayersType playersType) {
        return playersRepository.findPlayersByPlType(playersType);
    }

    @Override
    public Players findById(long id) {
        return playersRepository.findPlayersById(id);
    }

    @Override
    public void save(Players players) {
        playersRepository.save(players);
    }

    @Override
    public void changeSalary(long id, double salary) {
        Players players = findById(id);
        players.setFixedSalary(salary);
        playersRepository.save(players);
        this.eventPublisher.publishEvent(new SalaryChangeEvent(this, players));
    }
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }

}
