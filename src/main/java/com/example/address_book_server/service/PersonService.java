package com.example.address_book_server.service;

import com.example.address_book_server.dao.IPersonDAO;
import com.example.address_book_server.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService {
    @Autowired
    private IPersonDAO iPersonDAO;

    @Override
    public Person getPersonByID(int id) {
        Person obj =iPersonDAO.getPersonByID(id);
        return obj;
    }
    @Override
    public List<Person> getAllPerson() {
        return iPersonDAO.getAllPerson();
    }



    @Override
    public void updatePerson(Person person) {
        iPersonDAO.updatePerson(person);
    }


    @Override
    public void deletePerson(int person_id) {
        iPersonDAO.deletePerson(person_id);
    }

    @Override
    public synchronized boolean createPerson(Person person){
        if (iPersonDAO.personExists(person.getFirstName(), person.getLastName())) {
            return false;
        } else {
            iPersonDAO.createPerson(person);
            return true;
        }
    }
}

