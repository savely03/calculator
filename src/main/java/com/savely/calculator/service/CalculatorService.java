package com.savely.calculator.service;

import com.savely.calculator.model.Calculator;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    private final Calculator calculator;

    public CalculatorService(Calculator calculator) {
        this.calculator = calculator;
    }

    public String plus(int num1, int num2) {
        return String.format("%d + %d = %d", num1, num2, calculator.plus(num1, num2));
    }


    public String minus(int num1, int num2) {
        return String.format("%d - %d = %d", num1, num2, calculator.minus(num1, num2));
    }

    public String multiply(int num1, int num2) {
        return String.format("%d * %d = %d", num1, num2, calculator.multiply(num1, num2));
    }

    public String divide(int num1, int num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("Ошибка деления на 0!");
        }
        return String.format("%d / %d = %d", num1, num2, calculator.divide(num1, num2));
    }

}
