package com.example.address_book_server.controller;

import com.example.address_book_server.entity.Person;
import com.example.address_book_server.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Controller
@RequestMapping({"user"})
@CrossOrigin(origins = {"http://localhost:4200"})
public class PersonController {
    @Autowired
    private IPersonService iPersonService;

    @GetMapping({"person"})
    public ResponseEntity<Person> getPersonByID(@RequestParam("id") String id) {
        Person person = this.iPersonService.getPersonByID(Integer.parseInt(id));
        return new ResponseEntity(person, HttpStatus.OK);
    }

    @GetMapping({"all-person"})
    public ResponseEntity<List<Person>> getAllPerson() {
        List<Person> list = this.iPersonService.getAllPerson();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @PostMapping({"person"})
    public ResponseEntity<Void> createPerson(@RequestBody Person person, UriComponentsBuilder builder) {

        boolean flag = this.iPersonService.createPerson(person);
        if (!flag) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        } else {
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(builder.path("/person?id={id}").buildAndExpand(person.getId()).toUri());
            return new ResponseEntity(headers, HttpStatus.CREATED);
        }
    }
    @PutMapping({"person"})
    public ResponseEntity<Person> updatePerson(@RequestBody Person person) {
        iPersonService.updatePerson(person);
        return new ResponseEntity<Person>(person, HttpStatus.OK);
    }
    @DeleteMapping({"person"})
        public ResponseEntity<Void> deletePerson(@RequestParam("id") String id) {
        iPersonService.deletePerson(Integer.parseInt(id));
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
