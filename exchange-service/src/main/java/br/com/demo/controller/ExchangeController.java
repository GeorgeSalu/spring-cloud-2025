package br.com.demo.controller;

import br.com.demo.environment.InstanceInformationService;
import br.com.demo.model.Exchange;
import br.com.demo.repository.ExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("exchange-service")
public class ExchangeController {

    @Autowired
    private InstanceInformationService informationService;

    @Autowired
    private ExchangeRepository exchangeRepository;

    @GetMapping(value = "/{amount}/{from}/{to}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Exchange getExchange(@PathVariable("amount") BigDecimal amount,@PathVariable("from") String from,@PathVariable("to") String to) {

        Exchange exchange = exchangeRepository.findByFromAndTo(from, to);

        if (exchange == null) throw new RuntimeException("Currency Unsupported");

        BigDecimal conversionFactor = exchange.getConversionFactor();
        BigDecimal convertedValue = conversionFactor.multiply(amount);
        exchange.setConvertedValue(convertedValue);
        exchange.setEnvironment("PORT "+informationService.retrieveServerPort());

        return exchange;
    }

}
