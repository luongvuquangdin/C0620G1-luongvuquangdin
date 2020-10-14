package services.impl;

import org.springframework.stereotype.Service;
import services.CalculatorService;
@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public double addition(double number1, double number2) {
        return number1+number2;
    }

    @Override
    public double subtraction(double number1, double number2) {
        return number1-number2;
    }

    @Override
    public double multiplication(double number1, double number2) {
        return number1*number2;
    }

    @Override
    public double division(double number1, double number2) {
        return number1/number2;
    }
}
