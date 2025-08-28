package br.com.demo.request.converters;

import br.com.demo.exception.UnsupportedMathOperationException;

public class NumberConverter {

    private Double convertToDouble(String strNumber) throws IllegalArgumentException {
        if(strNumber == null || strNumber.isEmpty()) throw new UnsupportedMathOperationException("Please set a numeric value");
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }

    private boolean isNumeric(String strNumber) {
        if(strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",", ".");
        return (number.matches("[-+]?[0-9]*\\.?[0-9]+"));
    }

}
