package br.com.demo.controller;

import br.com.demo.dto.Exchange;
import br.com.demo.enviroment.InstanceInformationService;
import br.com.demo.model.Book;
import br.com.demo.proxy.ExchangeProxy;
import br.com.demo.repository.BookRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Book Endpoint")
@RestController
@RequestMapping("book-service")
public class BookController {

    @Autowired
    private InstanceInformationService informationService;

    @Autowired
    private BookRepository repository;

    @Autowired
    private ExchangeProxy exchangeProxy;

    @Operation(summary = "Find a specific boot by your id")
    @GetMapping(value = "/{id}/{currency}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Book findBook(@PathVariable("id") Long id, @PathVariable("currency") String currency) {
        String port = informationService.retrieveServerPort();

        var book = repository.findById(id).orElseThrow();


        Exchange exchange = exchangeProxy.getExchange(book.getPrice(), "USD", currency);

        //book.setEnvironment(port);
        book.setEnvironment("BOOK PORT: " + port + " EXCHANGE PORT: "+exchange.getEnvironment());
        book.setPrice(exchange.getConvertedValue());
        book.setCurrency(currency);

        return book;
    }

}
