package br.com.demo.controlers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    // http://localhost:8080/math/sum/3/5
    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable("numberOne") String numberOne,@PathVariable("numberTwo") String numberTwo) throws Exception {

        if (!isNumeric(numberOne) || !isNumeric(numberOne)) throw new IllegalArgumentException();
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    private Double convertToDouble(String numberOne) {
        return 1D;
    }

    private boolean isNumeric(String strNumber) {
        if(strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",", ".");
        return (number.matches("[-+]?[0-9]*\\.?[0-9]+"));
    }

}
