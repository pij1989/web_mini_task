package com.pozharsky.dmitri.service.impl;

public class CircleService {
    public static final CircleService INSTANCE = new CircleService();

    private CircleService() {
    }

    public double defineSquare(double radius) {
        return Math.PI * radius * radius;
    }
}
