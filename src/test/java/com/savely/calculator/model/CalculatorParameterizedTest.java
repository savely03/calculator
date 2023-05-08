package com.savely.calculator.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.util.concurrent.ThreadLocalRandom.*;
import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorParameterizedTest {

    private final Calculator calculator = new Calculator();

    private static int number1;
    private static int number2;
    private static int divideNumber1;
    private static int divideNumber2;

    @BeforeAll
    static void init() {
        number1 = current().nextInt(100);
        number2 = current().nextInt(100);
        divideNumber1 = current().nextInt(1, 100);
        divideNumber2 = current().nextInt(1, 100);
    }


    static Stream<Arguments> provideParamsForTests() {
        return Stream.of(
                Arguments.of(number1, number2),
                Arguments.of(number2, number1),
                Arguments.of(divideNumber1, divideNumber2),
                Arguments.of(divideNumber2, divideNumber1)
        );
    }

    static Stream<Arguments> provideParamsForDivideTest() {
        return Stream.of(
                Arguments.of(number1, divideNumber1),
                Arguments.of(number2, divideNumber2),
                Arguments.of(number1, divideNumber2),
                Arguments.of(number2, divideNumber1)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTests")
    void plus(int num1, int num2) {
        assertThat(calculator.plus(num1, num2)).isEqualTo(num1 + num2);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTests")
    void minus(int num1, int num2) {
        assertThat(calculator.minus(num1, num2)).isEqualTo(num1 - num2);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTests")
    void multiply(int num1, int num2) {
        assertThat(calculator.multiply(num1, num2)).isEqualTo(num1 * num2);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForDivideTest")
    void divide(int num1, int num2) {
        assertThat(calculator.divide(num1, num2)).isEqualTo(num1 / num2);
    }

}
