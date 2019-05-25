package com.example.address_book_server.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="address")
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
   @Column(name="id")
    private int id;
    @Column(name="state")
    private String state;
    @Column(name="city")
    private String city;
    @Column(name="street")
    private String street;
    @Column(name="home")
    private int home;
    @Column(name="number")
    private int number;

    @OneToOne(optional = false, mappedBy = "address")
    @JsonBackReference
    private Person person;

    public Address() {}

    public Address(int id, String state, String city, String street, int home, int number) {
        this.id = id;
        this.state = state;
        this.city = city;
        this.street = street;
        this.home = home;
        this.number = number;
    }

    public int getId() {        return id;    }

    public String getState() {        return state;    }

    public String getCity() {        return city;    }

    public String getStreet() {        return street;    }

    public int getHome() {        return home;    }

    public int getNumber() {        return number;    }

    public Person getPerson() {        return person;    }

    public void setId(int id) {        this.id = id;    }

    public void setState(String state) {        this.state = state;    }

    public void setCity(String city) {        this.city = city;    }

    public void setStreet(String street) {        this.street = street;    }

    public void setHome(int home) {        this.home = home;    }

    public void setNumber(int number) {        this.number = number;    }

    public void setPerson(Person person) {        this.person = person;    }
}
