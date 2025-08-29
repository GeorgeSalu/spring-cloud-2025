package br.com.demo;

import br.com.demo.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private final Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll() {
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    public Person create(Person person) {
        logger.info("create one person");
        return person;
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

    public Person findById(String id){
        logger.info("finding one person");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Leandro");
        person.setLastName("Rodrigo");
        person.setAddress("Uberlandia");
        person.setGender("Male");
        return person;
    }

}
