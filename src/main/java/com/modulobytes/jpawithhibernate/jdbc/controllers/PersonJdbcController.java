package com.modulobytes.jpawithhibernate.jdbc.controllers;

import com.modulobytes.jpawithhibernate.jdbc.beans.Person;
import com.modulobytes.jpawithhibernate.jdbc.repositories.PersonJdbcDao;

import java.util.List;

public class PersonJdbcController {

    private final PersonJdbcDao personJdbcDao;

    public PersonJdbcController(PersonJdbcDao personJdbcDao) {
        this.personJdbcDao = personJdbcDao;
    }

    public List<Person> findAll() {
        return personJdbcDao.findAll();
    }
}
