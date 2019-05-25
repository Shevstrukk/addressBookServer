package com.example.address_book_server.dao;

import com.example.address_book_server.entity.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class PersonDAO implements IPersonDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Person getPersonByID (int id) {return entityManager.find(Person.class, id);}



    @SuppressWarnings("unchecked")
    public List<Person> getAllPerson() {
        String str = "FROM Person ORDER BY id ASC";
        return (List<Person>) entityManager.createQuery(str).getResultList();
    }

    @Override
    public void createPerson(Person person) {

        entityManager.persist(person);
    }
    @Override
    public void updatePerson(Person person) {
        Person prs = getPersonByID(person.getId());
        prs.setFirstName(person.getFirstName());
        prs.setLastName(person.getLastName());
        prs.setAddress(person.getAddress());
        prs.setAppeal(person.getAppeal());
        prs.setComment(person.getComment());
        prs.getEmails().clear();
        prs.getEmails().addAll(person.getEmails());
        prs.getPhones().clear();
        prs.getPhones().addAll(person.getPhones());
        prs.setPatronymic(person.getPatronymic());
        prs.setPosition(person.getPosition());

        entityManager.flush();
    }
    @Override
    public void deletePerson(int id) {
        entityManager.remove(getPersonByID( id));
    }

    @Override
    public boolean personExists(String firstname, String lastname) {
        String str = "FROM Person  WHERE firstname = ? and lastname = ?";
        int count = entityManager.createQuery(str).setParameter(1, firstname)
                .setParameter(2, lastname).getResultList().size();
        return count > 0 ? true : false;
    }

}

