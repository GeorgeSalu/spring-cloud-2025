package br.com.demo.controller;

import br.com.demo.enviroment.InstanceInformationService;
import br.com.demo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("book-service")
public class BookController {

    @Autowired
    private InstanceInformationService informationService;

    @GetMapping(value = "/{id}/{currency}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Book findBook(@PathVariable("id") String id, @PathVariable("currency") String currency) {
        String port = informationService.retrieveServerPort();
        return new Book(
                1L,
                "Nigel Poulton",
                "Docker Deep Dive",
                new Date(),
                15.8,
                "BRL",
                port
        );
    }

}
