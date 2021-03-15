package com.example.Event;

import com.example.Players.Players;
import org.springframework.context.ApplicationEvent;

public class SalaryChangeEvent extends ApplicationEvent {
    Players player;
    public SalaryChangeEvent(Object s, Players p) {
        super(s);
        this.player = p;
    }

}
