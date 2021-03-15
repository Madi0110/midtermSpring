package com.example.Players;


import javax.persistence.*;

@Entity
@Table(name = "players")
public class Players {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    @Enumerated(EnumType.STRING)
    private PlayersType plType;
    private double fixedSalary;

    public Players(Long id, String name, String surname, PlayersType plType,Double fixedSalary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.plType = plType;
        this.fixedSalary = fixedSalary;
    }
    public Players(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public PlayersType getPlType() {
        return plType;
    }

    public void setPlType(PlayersType plType) {
        this.plType = plType;
    }
    public double getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }
}
