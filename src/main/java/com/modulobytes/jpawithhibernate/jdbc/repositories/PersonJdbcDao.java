package com.modulobytes.jpawithhibernate.jdbc.repositories;

import com.modulobytes.jpawithhibernate.jdbc.beans.Person;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PersonJdbcDao {
    private final JdbcTemplate jdbcTemplate;

    static class PersonRowMapper implements RowMapper<Person> {
        @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            Person person = new Person();
            person.setId(rs.getInt("id"));
            person.setName(rs.getString("name"));
            person.setLocation(rs.getString("location"));
            person.setBirthDate(rs.getTimestamp("birth_date").toLocalDateTime());
            return person;
        }
    }
    public PersonJdbcDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> findAll() {
        return jdbcTemplate.query("select * from person", new PersonRowMapper());
    }

    public Person findById(Integer id) {
        return jdbcTemplate.queryForObject("select * from person p where p.id=?",
                new PersonRowMapper(), id);
    }

    public List<Person> findByName(String name) {
        String searchName = "%"+name+"%";
        return jdbcTemplate.query("select * from person where name like ?",
                new BeanPropertyRowMapper<>(Person.class), searchName);
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("delete from person where id = ?", id);
    }

    public int insertPerson(Person person) {
        String sql  = """
                insert into person (id, name, location, birth_date)
                values (?, ?, ?, ?)
                """;
        return jdbcTemplate.update(sql, person.getId(), person.getName(), person.getLocation(), person.getBirthDate());
    }

    public int updatePerson(Person person) {
        String sql  = """
                update person
                set name = ?, location = ?, birth_date = ?
                where id = ?
                """;
        return jdbcTemplate.update(sql, person.getName(), person.getLocation(), person.getBirthDate(), person.getId());
    }
}
