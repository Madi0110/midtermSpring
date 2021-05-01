package com.example.controller;

import com.example.entities.Match;
import com.example.repositories.MatchRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
@Api(value = "Device Controller class", description = "This class allows to interact with Device object")
public class MatchController {
    @Autowired
    private MatchRepository matchRepository;

    @ApiOperation(value = "LIst of all devices")
    @GetMapping("")
    public List<Match> matchList(){
        return matchRepository.findAll();
    }

    @ApiOperation(value = "LIst of all repaired devices")
    @GetMapping("/repairedMatches")
    public List<Match> repairedMatches(){
        return matchRepository.findByIsDoneTrue();
    }

    @ApiOperation(value = "LIst of all devices that waiting repairing")
    @GetMapping("/matchesBeforeRepairing")
    public List<Match> matchesBeforeRepairing()
    {
        return matchRepository.findByIsDoneFalse();
    }

    @ApiOperation(value = "Add new device")
    @PostMapping("")
    public Match newDevice(@RequestBody Match match){
        if (match.getName().isEmpty()){
            throw new RuntimeException("fields of matches must be filled");
        }
        matchRepository.save(match);
        return match;
    }

}
