package com.modulobytes.jpawithhibernate.jpa.repositories;

import com.modulobytes.jpawithhibernate.jpa.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDAO extends JpaRepository<Person, Integer> {
}
