package com.example.address_book_server.dao;

import com.example.address_book_server.entity.Person;

import java.util.List;

public interface IPersonDAO {
    List<Person> getAllPerson();
    Person getPersonByID( int person_id);
    void createPerson(Person person);
    void updatePerson (Person person);
    void deletePerson(int person_id);
    boolean personExists(String firstName, String lastName);
}
