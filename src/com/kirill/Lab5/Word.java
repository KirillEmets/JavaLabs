package com.kirill.Lab5;

import java.util.ArrayList;

public class Word implements SentencePart {
    ArrayList<Letter> letters;
    public Word(ArrayList<Letter> letters) {
        this.letters = letters;
    }

    public Word() {
        this.letters = new ArrayList<>();
    }

    public void add(ArrayList<Letter> letters) {
        this.letters.addAll(letters);
    }

    public void add(Letter letter) {
        this.letters.add(letter);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Letter l: letters) {
            res.append(l.toString());
        }
        return res.toString();
    }
}
