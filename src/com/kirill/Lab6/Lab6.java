package com.kirill.Lab6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lab6 {
    // 9507 mod 13 = 4
    public static void main(String[] args) {
        Album first = new Album("My First Album");
        first.recordSongs(new Song[]{
                new Song("Where is my mind", 217, "With your feet on the air and your head on the ground...", "Alternative"),
                new ViolinComposition("Violin-1", 145, ""),
                new JazzSong("What a wonderful world", 138, "I see trees so green, red roses too..."),
                new Song("Al ternative", 111, "I forgot the lyrics", "Alternative"),
                new PianoSong("Megalovania", 156, ""),
                new Song("I want to break free", 271, "I want to break free...", "Rock"),
                new ViolinComposition("Violin-2", 154, ""),
                new PianoSong("River flows in you", 215, ""),
                new JazzSong("FooBar Jazz song", 400, "Tuturu")
        });
        System.out.println(first.toString());

        System.out.println("Duration: " + first.getDuration());

        System.out.println("\nGrouped:");
        first.groupByStyle();
        System.out.println(first.toString());

        System.out.println("\nFiltered:");
        System.out.println(first.findSongsByDuration(100, 200).toString());
        System.out.println(first.findSongsByDuration(250, 400).toString());
    }
}

class Album {
    Song[] songs = {};
    String name;
    public Album(String name) {
        this.name = name;
    }

    public int getDuration() {
        int res = 0;
        for (Song song : songs) {
            res += song.duration;
        }
        return res;
    }

    public void recordSongs(Song[] songs) {
        this.songs = songs;
    }

    public void groupByStyle() {
        Comparator<Song> comp = Comparator.comparing(s -> s.style);
        Arrays.sort(songs, comp);
    }

    public List<Song> findSongsByDuration(int from, int to) {
        return Arrays.stream(songs).filter((Song s) -> s.duration >= from && s.duration <= to).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder(name + ":\n");
        for (Song song : songs) {
            res.append("\n").append(song.toString());
        }
        return res.toString();
    }
}