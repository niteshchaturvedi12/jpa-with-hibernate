package com.modulobytes.jpawithhibernate;

import com.modulobytes.jpawithhibernate.jdbc.beans.Person;
import com.modulobytes.jpawithhibernate.jdbc.repositories.PersonJdbcDao;
import com.modulobytes.jpawithhibernate.jpa.repositories.PersonDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class JpaWithHibernateApplication {
    private final Logger logger = LoggerFactory.getLogger(JpaWithHibernateApplication.class);

    @Autowired
    private PersonJdbcDao personJdbcDao;
    @Autowired
    private PersonDAO personDAO;
    public static void main(String[] args) {
        SpringApplication.run(JpaWithHibernateApplication.class, args);
    }

    public void run() {
        logger.info("person with id 10001 is {}", personJdbcDao.findById(10001));
        personJdbcDao.findByName("Nite").forEach(person -> logger.info("name with Nite {}", person));
        logger.info("{} records are deleted", personJdbcDao.deleteById(10003));
        Person person = new Person(10006, "Beera", "Deoli", LocalDateTime.now());
        Person updatePerson = new Person(10002, "Khubu", "Jaipur", LocalDateTime.of(1994, 4, 5, 5, 30));
        logger.info("{} records inserted in DB", personJdbcDao.insertPerson(person));
        logger.info("{} records are updated in DB", personJdbcDao.updatePerson(updatePerson));
        logger.info("person with id 10001 is {}", personDAO.findById(10001));
    }
}
