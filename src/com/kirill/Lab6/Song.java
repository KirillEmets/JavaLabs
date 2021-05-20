package com.kirill.Lab6;

//enum class Style
public class Song {
    String name;
    int duration;
    String text;
    String style;

    public Song(String name, int duration, String text, String style) {
        this.duration = duration;
        this.text = text;
        this.name = name;
        this.style = style;
    }

    public void play() {
        System.out.println("♫ " + text + " ♫");
    }

    @Override
    public String toString() {
        return "{ " + name + ", " + duration + "s, " + style + " }";
    }
}

