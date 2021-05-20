package com.kirill.Lab5;

public class Punctuation implements SentencePart {
    char value;
    public Punctuation(char value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
