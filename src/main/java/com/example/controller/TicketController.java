package com.example.controller;

import com.example.entities.Match;
import com.example.entities.Ticket;
import com.example.entities.User;
import com.example.repositories.MatchRepository;
import com.example.repositories.TicketRepository;
import com.example.repositories.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/finishedDevices")
@Api(value = "FinishedDevice Controller class", description = "This class allows to interact with FinishedDevice object")
public class TicketController {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private UserRepository userRepository;

    @ApiOperation(value = "List of all ticket")
    @GetMapping("")
    public List<Ticket> repairCenterList(){
        return ticketRepository.findAll();
    }


    @ApiOperation(value = "End of repairing")
    @PostMapping("/{matchId}/{repId}")
    public void ticket( @PathVariable Long matchId, @PathVariable Long userId){


        Match match = matchRepository.findById(matchId).get();
        User user = userRepository.findById(userId).get();
        Ticket ticket = new Ticket();
        ticket.setMatch(match);

    }

    @ApiOperation(value = "Take finished ticket")
    @PatchMapping("/{id}")
    public void takeFinishedDevice(@PathVariable Long id){
        Ticket ticket = ticketRepository.findById(id).get();
        ticketRepository.save(ticket);
    }


}
