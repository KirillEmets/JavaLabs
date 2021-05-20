package com.kirill.Lab5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Text {
    ArrayList<Sentence> sentences;
    public Text(ArrayList<Sentence> sentences) {
        this.sentences = sentences;
    }

    public Text() {
        this.sentences = new ArrayList<>();
    }

    public void add(ArrayList<Sentence> sentences) {
        this.sentences.addAll(sentences);
    }

    public void add(Sentence part) {
        this.sentences.add(part);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Sentence s: sentences) {
            res.append(s.toString());
        }
        res.delete(0, 1);
        return res.toString();
    }
}
