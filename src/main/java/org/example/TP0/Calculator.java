package org.example.TP0;


import java.util.stream.DoubleStream;



public class Calculator {
    public static double add(double... operands) {
        return DoubleStream.of(operands)
                .sum();
    }
    public static double multiply(double... operands) {
        return DoubleStream.of(operands)
                .reduce(1, (a, b) -> a * b);
    }
}
