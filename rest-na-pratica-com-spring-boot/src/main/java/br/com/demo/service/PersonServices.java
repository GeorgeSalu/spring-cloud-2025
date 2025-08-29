package br.com.demo.service;

import br.com.demo.exception.ResourceNotFoundException;
import br.com.demo.model.Person;
import br.com.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private final Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    private PersonRepository personRepository;

    public List<Person> findAll() {
        logger.info("finding all person");
        return personRepository.findAll();
    }

    public Person create(Person person) {
        logger.info("create one person");

        return personRepository.save(person);
    }

    public Person update(Person person) {
        logger.info("update one person");

        Person entity = personRepository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("no records found for this"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return personRepository.save(entity);
    }

    public void delete(String id) {
        logger.info("delete one person");
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person " + i);
        person.setLastName("LastName " + i);
        person.setAddress("Uberlandia");
        person.setGender("Male");
        return person;
    }

    public Person findById(Long id){
        logger.info("finding one person");

        return personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("no records found for this"));
    }

}
