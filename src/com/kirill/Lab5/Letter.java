package com.kirill.Lab5;

public class Letter {
    char value;
    public Letter(char value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
