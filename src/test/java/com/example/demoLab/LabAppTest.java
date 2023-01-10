package com.example.demoLab;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class LabAppTest {
    NewCalculator newCalculator;
    @BeforeEach
    public void init(){
        //	System.out.println("Run test...");
        newCalculator= new NewCalculator();
    }
    @AfterEach
    public void destroy() {
        System.out.println("Finish test.");
    }

    @Test
    public void whenUseFactorialCorrectValue() {

        Long result = newCalculator.Factorial(3);
        assertEquals(6, result);
        result = newCalculator.Factorial(6);
        assertEquals(720, result);
    }
    @Test
    public void whenUseRootSquareValue() {
        Double result = newCalculator.RootSquare(4);
        assertEquals(2.0, result);
        result = newCalculator.RootSquare(625);
        assertEquals(25.0, result);
    }
    @Test
    public void whenUseAnyFunctionValue() {
        Double result = newCalculator.RootSquare(4);
        assertEquals(2.0, result);
        result = newCalculator.RootSquare(625);
        assertEquals(25.0, result);
    }
}
