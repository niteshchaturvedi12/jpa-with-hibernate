package com.modulobytes.jpawithhibernate.jdbc.controllers;

import com.modulobytes.jpawithhibernate.jdbc.beans.Person;
import com.modulobytes.jpawithhibernate.jdbc.repositories.PersonJdbcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PersonJdbcController {
    private final Logger logger = LoggerFactory.getLogger(PersonJdbcController.class);
    private final PersonJdbcDao personJdbcDao;

    public PersonJdbcController(PersonJdbcDao personJdbcDao) {
        this.personJdbcDao = personJdbcDao;
    }

    public List<Person> findAll() {
        personJdbcDao.findAll().forEach(person ->  logger.info(person.toString()));
        return personJdbcDao.findAll();
    }
}
