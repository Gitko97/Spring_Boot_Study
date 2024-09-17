package com.example.calculator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@RequiredArgsConstructor
public class DollarCalculator implements ICalculator {
    private int market = 100;
    private final MarketServer marketServer;

    @Override
    public int sum(int x, int y) {
        x *= marketServer.price();
        y *= marketServer.price();
        return x + y;
    }

    @Override
    public int minus(int x, int y) {
        x *= marketServer.price();
        y *= marketServer.price();
        return x - y;
    }

    @Override
    public int multiply(int x, int y) {
        x *= marketServer.price();
        y *= marketServer.price();
        return x * y;
    }

    @Override
    public int division(int x, int y) {
        x *= marketServer.price();
        y *= marketServer.price();
        return x / y;
    }
}
