package com.kirill.Lab5;

import java.util.ArrayList;

public class Sentence {
    ArrayList<SentencePart> parts;
    public Sentence(ArrayList<SentencePart> parts) {
        this.parts = parts;
    }

    public Sentence() {
        this.parts = new ArrayList<>();
    }

    public void add(ArrayList<SentencePart> parts) {
        this.parts.addAll(parts);
    }

    public void add(SentencePart part) {
        this.parts.add(part);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (SentencePart s: parts) {
            if(s instanceof Word) res.append(' ');
            res.append(s.toString());
        }
        return res.toString();
    }
}
