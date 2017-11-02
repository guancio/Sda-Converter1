package se.kth.roberto.myapplication.controller;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by guancio on 02/11/2017.
 */

public class ConverterController {
    private String convert(String param, double factor) {
        Double value = Double.parseDouble(param);
        NumberFormat formatter = new DecimalFormat("#0.00");
        String res = formatter.format(value * factor);
        return res;
    }
    public String convertFromGtoKg(String param) {
        return convert(param, 0.001);
    }
    public String convertFromKgToG(String param) {
        return convert(param, 1000);
    }
}
