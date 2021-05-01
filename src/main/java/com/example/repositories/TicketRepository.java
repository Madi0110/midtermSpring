package com.example.repositories;


import com.example.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {

    Ticket findByDevice(Ticket ticket);
}
