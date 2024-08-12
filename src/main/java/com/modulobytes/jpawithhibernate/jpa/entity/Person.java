package com.modulobytes.jpawithhibernate.jpa.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "location")
    private String location;
    @Column(name = "birth_date")
    private LocalDateTime birthdate;
    public Person() {

    }
    public Person(int id, String name, String location, LocalDateTime birthdate) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.birthdate = birthdate;
    }
    public Person(String name, String location, LocalDateTime birthdate) {
        this.name = name;
        this.location = location;
        this.birthdate = birthdate;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public LocalDateTime getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(LocalDateTime birthdate) {
        this.birthdate = birthdate;
    }
}