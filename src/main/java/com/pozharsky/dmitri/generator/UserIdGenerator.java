package com.pozharsky.dmitri.generator;

public final class UserIdGenerator {
    private static long count = 1;

    private UserIdGenerator() {}

    public static long generate() {
        return count++;
    }
}
