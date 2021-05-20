package com.kirill.Lab6;

public class JazzSong extends Song {
    public JazzSong(String name, int duration, String text) {
        super(name, duration, text, "Jazz");
    }

    @Override
    public void play() {
        System.out.println("\uD83C\uDFB7 " + text + " \uD83C\uDFB7");
    }
}
