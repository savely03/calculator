package com.savely.calculator.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private final static Calculator calculator = new Calculator();
    private int num1;
    private int num2;
    private int divideNumber1;
    private int divideNumber2;


    @BeforeEach
    void setUp() {
        num1 = ThreadLocalRandom.current().nextInt(100);
        num2 = ThreadLocalRandom.current().nextInt(100);
        divideNumber1 = ThreadLocalRandom.current().nextInt(1, 100);
        divideNumber2 = ThreadLocalRandom.current().nextInt(1, 100);
    }

    @Test
    void plus() {
        assertAll(
                () -> assertThat(calculator.plus(num1, num2)).isEqualTo(num1 + num2),
                () -> assertThat(calculator.plus(divideNumber1, divideNumber2)).isEqualTo(divideNumber1 + divideNumber2)
        );
    }

    @Test
    void minus() {
        assertAll(
                () -> assertThat(calculator.minus(num1, num2)).isEqualTo(num1 - num2),
                () -> assertThat(calculator.minus(divideNumber1, divideNumber2)).isEqualTo(divideNumber1 - divideNumber2)
        );
    }

    @Test
    void multiply() {
        assertAll(
                () -> assertThat(calculator.multiply(num1, num2)).isEqualTo(num1 * num2),
                () -> assertThat(calculator.multiply(divideNumber1, divideNumber2)).isEqualTo(divideNumber1 * divideNumber2)
        );
    }

    @Test
    void divide() {
        assertAll(
                () -> assertThat(calculator.divide(num1, divideNumber1)).isEqualTo(num1 / divideNumber1),
                () -> assertThat(calculator.divide(num1, divideNumber2)).isEqualTo(num1 / divideNumber2)
        );
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(1, 0));
    }

}