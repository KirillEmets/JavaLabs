package com.kirill.Lab6;

public class PianoSong extends Song {
    public PianoSong(String name, int duration, String text) {
        super(name, duration, text, "Piano");
    }

    @Override
    public void play() {
        System.out.println("\uD83C\uDFB9 " + text + " \uD83C\uDFB9");
    }
}
