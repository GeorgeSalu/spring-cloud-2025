package br.com.demo.controlers;

import br.com.demo.exception.UnsupportedMathOperationException;
import br.com.demo.request.converters.NumberConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable("numberOne") String numberOne,@PathVariable("numberTwo") String numberTwo) {

        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberOne)) throw new UnsupportedMathOperationException("Please set a numeric value");
        return NumberConverter.convertToDouble(numberOne) + NumberConverter.convertToDouble(numberTwo);
    }

    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(@PathVariable("numberOne") String numberOne,@PathVariable("numberTwo") String numberTwo) {

        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberOne)) throw new UnsupportedMathOperationException("Please set a numeric value");
        return NumberConverter.convertToDouble(numberOne) - NumberConverter.convertToDouble(numberTwo);
    }

    @RequestMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(@PathVariable("numberOne") String numberOne,@PathVariable("numberTwo") String numberTwo) {

        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberOne)) throw new UnsupportedMathOperationException("Please set a numeric value");
        return NumberConverter.convertToDouble(numberOne) * NumberConverter.convertToDouble(numberTwo);
    }

    @RequestMapping("/division/{numberOne}/{numberTwo}")
    public Double division(@PathVariable("numberOne") String numberOne,@PathVariable("numberTwo") String numberTwo) {

        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberOne)) throw new UnsupportedMathOperationException("Please set a numeric value");
        return NumberConverter.convertToDouble(numberOne) / NumberConverter.convertToDouble(numberTwo);
    }

    @RequestMapping("/mean/{numberOne}/{numberTwo}")
    public Double mean(@PathVariable("numberOne") String numberOne,@PathVariable("numberTwo") String numberTwo) {

        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberOne)) throw new UnsupportedMathOperationException("Please set a numeric value");
        return (NumberConverter.convertToDouble(numberOne) * NumberConverter.convertToDouble(numberTwo)) / 2;
    }

    @RequestMapping("/squareroot/{number}")
    public Double squareRoot(@PathVariable("number") String number) {

        if (!NumberConverter.isNumeric(number)) throw new UnsupportedMathOperationException("Please set a numeric value");
        return Math.sqrt(NumberConverter.convertToDouble(number));
    }

}
