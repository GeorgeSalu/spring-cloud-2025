package br.com.demo.controlers;

import br.com.demo.service.PersonServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class TestLogController {

    private Logger logger = LoggerFactory.getLogger(PersonServices.class.getName());

    @GetMapping("/test")
    public String testLog() {
        logger.debug("this is an info log");
        logger.info("this is an info log");
        logger.warn("this is an info log");
        logger.error("this is an info log");
        return "log generator successfuly";
    }

}
