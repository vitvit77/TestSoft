package com.example.demoLab;

import org.springframework.stereotype.Service;

@Service
public class NewCalculator {
    public double AnyFunction (double x, double y){
        return x*x*x+5*y-x/y;
    }
    public  long Factorial (long x)
    {
        long result = 1;
        for (long i = 1; i <=x; i ++){
            result = result*i;
        }
        return result;
    }
    public  double RootSquare (int x){
        return Math.sqrt(x);
    }

}
