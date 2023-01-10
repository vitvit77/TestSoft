package com.example.demoLab;

import org.springframework.stereotype.Service;

@Service
public class Calculator {
    public int add(int a, int b){
        return a+b;
    }
    public int sub(int a, int b) {
        return a - b;
    }

    public int mult ( int a, int b){
        return a * b;
    }
    public double div ( int a, int b){
        if (b==0) {b=1; }
        return (double) a / b;
    }


}
