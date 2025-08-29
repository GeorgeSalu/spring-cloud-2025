package br.com.demo;

import br.com.demo.model.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private final Logger logger = Logger.getLogger(PersonServices.class.getName());

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
