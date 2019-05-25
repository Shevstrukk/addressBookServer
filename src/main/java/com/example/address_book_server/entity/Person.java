package com.example.address_book_server.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="person")
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private int id;
    @Column(name="firstname")
    private String firstname;
    @Column(name="lastname")
    private String lastname;
    @Column(name="patronymic")
     private String patronymic;
    @Column(name="appeal")
     private String appeal;
    @Column(name="position")
     private String position;
    @Column(name="comment")
    private String comment;
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "idaddress")
    @JsonManagedReference
  private Address address;
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Email> emails = new ArrayList<>();
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Phone> phones = new ArrayList<>();

    public Person() {}

    public Person(int id, String firstname, String lastname, String patronymic, String appeal, String position, String comment) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.patronymic = patronymic;
        this.appeal = appeal;
        this.position = position;
        this.comment = comment;
    }

    public String getComment() {        return comment;    }

    public void setComment(String comment) {        this.comment = comment;    }

    public int getId() {
        return id;
    }

    public String getFirstName() {        return firstname;    }

    public String getLastName() {        return lastname;    }

    public String getPatronymic() {        return patronymic;    }

    public String getAppeal() {        return appeal;    }

    public String getPosition() {        return position;    }

    public Address getAddress() {        return address;    }

    public List<Email> getEmails() {        return emails;    }

    public List<Phone> getPhones() {        return phones;    }

    public void setId(int id) {        this.id = id;    }

    public void setFirstName(String firstname) {        this.firstname = firstname;    }

    public void setLastName(String lastname) {        this.lastname = lastname;    }

    public void setPatronymic(String patronymic) {        this.patronymic = patronymic;    }

    public void setAppeal(String appeal) {        this.appeal = appeal;    }

    public void setPosition(String position) {        this.position = position;    }

    public void setAddress(Address address) {        this.address = address;    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }
    public void addEmail(Email email){
        email.setPerson(this);
        emails.add(email);
    }

    public void setPhones(List<Phone> phones) {        this.phones = phones;    }
    public void addPhone(Phone phone){
        phone.setPerson(this);
        phones.add(phone);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (firstname == null) {
            if (other.firstname != null)
                return false;
        } else if (!firstname.equals(other.firstname))
            return false;
        if (lastname == null) {
            if (other.lastname != null)
                return false;
        } else if (!lastname.equals(other.lastname))
            return false;
        if (patronymic == null) {
            if (other.patronymic != null)
                return false;
        } else if (!patronymic.equals(other.patronymic))
            return false;
        if (appeal == null) {
            if (other.appeal != null)
                return false;
        } else if (!appeal.equals(other.appeal))
            return false;
        if (position == null) {
            if (other.position != null)
                return false;
        } else if (!position.equals(other.position))
            return false;
        if (comment == null) {
            if (other.comment != null)
                return false;
        } else if (!comment.equals(other.comment))
            return false;
        if (address == null) {
            if (other.address != null)
                return false;
        } else if (!address.equals(other.address))
            return false;
        if (emails == null) {
            if (other.emails != null)
                return false;
        } else if (!emails.equals(other.emails))
            return false;
        if (phones == null) {
            if (other.phones != null)
                return false;
        } else if (!phones.equals(other.phones))
            return false;
        if (id != other.id)
            return false;
        return true;

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
        result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
        result = prime * result + ((patronymic == null) ? 0 : patronymic.hashCode());
        result = prime * result + ((appeal == null) ? 0 : appeal.hashCode());
        result = prime * result + ((position == null) ? 0 : position.hashCode());
        result = prime * result + ((comment == null) ? 0 : comment.hashCode());
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + ((emails == null) ? 0 : emails.hashCode());
        result = prime * result + ((phones == null) ? 0 : phones.hashCode());
        result = result+ id;
        return result;
    }
}
