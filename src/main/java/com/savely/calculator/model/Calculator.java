package com.savely.calculator.model;

import org.springframework.stereotype.Component;

@Component
public class Calculator {
    public int plus(int num1, int num2) {
        return num1 + num2;
    }

    public int minus(int num1, int num2) {
        return num1 - num2;
    }

    public int multiply(int num1, int num2) {
        return num1 * num2;
    }

    // Деление сделано без приведения к double для упрощения
    public int divide(int num1, int num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("Ошибка деления на 0!");
        }
        return num1 / num2;
    }

}
