package com.example.address_book_server.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="emails")
public class Email implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private  int id;
    @Column(name="email")
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "idperson")
    @JsonBackReference
    private Person person;
    public Email() {}

    public Email(int id, String email) {
        this.id = id;
        this.email = email;
    }

    public int getId() {        return id;    }

    public String getEmail() {        return email;    }

    public Person getPerson() {        return person;    }

    public void setId(int id) {        this.id = id;    }

    public void setEmail(String email) {        this.email = email;    }

    public void setPerson(Person person) {        this.person = person;    }
}
