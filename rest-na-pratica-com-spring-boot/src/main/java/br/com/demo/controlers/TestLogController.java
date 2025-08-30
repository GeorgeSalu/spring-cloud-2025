package br.com.demo.controlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestLogController {

    private final Logger logger = LoggerFactory.getLogger(TestLogController.class.getName());

    @GetMapping("/test")
    public String testLog() {
        logger.debug("this is an debug log");
        logger.info("this is an info log");
        logger.warn("this is an warn log");
        logger.error("this is an error log");
        return "log generator successfuly";
    }

}
