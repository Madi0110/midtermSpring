package com.example.Players;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Players, Long> {
    List<Players> findPlayersByPlType(PlayersType playersType);
    Players findPlayersById(long id);
    List<Players> findAll();

}
