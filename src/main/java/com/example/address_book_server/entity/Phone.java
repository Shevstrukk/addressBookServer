package com.example.address_book_server.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="phone")
public class Phone implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private int id;
    @Column(name="line")
    private int line;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "personid")
    @JsonBackReference
    private Person person;
    public Phone() {}

    public Phone(int id,  int line) {
        this.id = id;
        this.line = line;
    }

    public int getId() {        return id;    }

    public int getLine() {        return line;    }

    public Person getPerson() {        return person;    }

    public void setId(int id) {        this.id = id;    }

    public void setLine(int line) {        this.line = line;    }

    public void setPerson(Person person) {        this.person = person;    }
}
