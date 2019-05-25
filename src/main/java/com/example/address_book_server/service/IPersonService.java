package com.example.address_book_server.service;

import com.example.address_book_server.entity.Person;

import java.util.List;

public interface IPersonService {
    List<Person> getAllPerson();
    Person getPersonByID( int id);
    boolean createPerson(Person person);
    void updatePerson (Person person);
    void deletePerson(int id);
}

