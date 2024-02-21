package com.modulobytes.jpawithhibernate.jdbc.controllers;

import com.modulobytes.jpawithhibernate.jdbc.beans.Person;
import com.modulobytes.jpawithhibernate.jdbc.repositories.PersonJdbcDao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/person")
public class PersonJdbcController {

    private final PersonJdbcDao personJdbcDao;

    public PersonJdbcController(PersonJdbcDao personJdbcDao) {
        this.personJdbcDao = personJdbcDao;
    }

    @GetMapping(path = "/all")
    public List<Person> findAll() {
        return personJdbcDao.findAll();
    }
}
