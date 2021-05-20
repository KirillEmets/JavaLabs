package com.kirill.Lab6;

public class ViolinComposition extends Song {
    public ViolinComposition(String name, int duration, String text) {
        super(name, duration, text, "Violin");
    }

    @Override
    public void play() {
        System.out.println("\uD83C\uDFBB " + text + " \uD83C\uDFBB");
    }
}
