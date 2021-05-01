package com.example.controller;

import com.example.entities.User;
import com.example.repositories.CenterRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/centers")
@Api(value = "RepairCenter Controller class", description = "This class allows to interact with RepairCenter object")
public class CenterController {

    @Autowired
    private CenterRepository centerRepository;

    @ApiOperation(value = "LIst of all repairing centers")
    @GetMapping("")
    public List<User> userCenterList(){
        return centerRepository.findAll();
    }


    @ApiOperation(value = "Add new repairing center")
    @PostMapping("")
    public void newCenter(@RequestBody User user){
        if( user.getName() == null){
            throw new RuntimeException("all fields in repair center should be filled (location|name)");
        }
        centerRepository.save(user);
    }

    @ApiOperation(value = "Update user center name")
    @PatchMapping("/{id}/name")
    public void updateCenterName(@PathVariable Long id,
                                     @RequestParam String name){
        if (id == null || name.equals("")){
            throw new RuntimeException("id should not be empty");
        }
        User repairCenter = centerRepository.findById(id).get();
        repairCenter.setName(name);
        centerRepository.save(repairCenter);
    }
}
