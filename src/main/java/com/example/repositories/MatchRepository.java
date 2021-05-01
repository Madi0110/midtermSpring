package com.example.repositories;


import com.example.entities.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MatchRepository extends JpaRepository<Match,Long> {
    List<Match> findByIsDoneFalse();
    List<Match> findByIsDoneTrue();
}
