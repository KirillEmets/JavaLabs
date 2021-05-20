package com.kirill.Lab7;

import com.kirill.Lab6.JazzSong;
import com.kirill.Lab6.PianoSong;
import com.kirill.Lab6.Song;
import com.kirill.Lab6.ViolinComposition;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class Lab7 {
    public static void main(String[] args) {
        Song[] songs = new Song[]{
                new Song("Where is my mind", 217, "With your feet on the air and your head on the ground...", "Alternative"),
                new ViolinComposition("Violin-1", 145, ""),
                new JazzSong("What a wonderful world", 138, "I see trees so green, red roses too..."),
                new Song("Al ternative", 111, "I forgot the lyrics", "Alternative"),
                new PianoSong("Megalovania", 156, ""),
                new Song("I want to break free", 271, "I want to break free...", "Rock"),
                new ViolinComposition("Violin-2", 154, ""),
                new PianoSong("River flows in you", 215, ""),
                new JazzSong("FooBar Jazz song", 400, "Tuturu")
        };

        SongCollection collection = new SongCollection();

        // проверка add
        collection.add(songs[0]);
        System.out.println(collection.size());

        // копии не добавляются
        collection.add(songs[0]);
        collection.add(songs[1]);
        System.out.println(collection.size());

        // проверка addAll
        collection.addAll(Arrays.asList(songs));
        System.out.println(collection.size());

        // размер массива внутри увеличивается
        for (int i = 0; i < 20; i++) {
            collection.add(new Song(String.valueOf(i), i*i, "", "idk"));
        }
        System.out.println(collection.size());

        // проверка remove
        System.out.println(collection.contains(songs[0]));
        collection.remove(songs[0]);
        System.out.println(collection.contains(songs[0]));

        // проверка removeAll
        collection.removeAll(Arrays.asList(songs));
        System.out.println(collection.size());

        // проверка remove
        collection.clear();
        System.out.println(collection.size());
    }
}

// 9507 mod 2 = 1 (Set)
// 9507 mod 3 = 0 (Array with 15+)

class SongCollection implements Set<Song> {
    Song[] items;

    public SongCollection() {
        items = new Song[15];
    }

    public SongCollection(Song s) {
        items = new Song[15];
        items[0] = s;
    }

    public SongCollection(Collection<Song> songs) {
        items = new Song[15];
        addAll(songs);
    }

    @Override
    public int size() {
        int count = 0;
        for (Song item : items) {
            if(item != null)
                count++;
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        if(!(o instanceof Song))
            return false;

        for (Song song : items) {
            if(song == o)
                return true;
        }

        return false;
    }

    @Override
    public Iterator<Song> iterator() {
        return Arrays.stream(items).iterator();
    }

    @Override
    public Object[] toArray() {
        int s = size();
        int k = 0;
        Song[] res = new Song[s];
        for (Song item : items) {
            if(item != null) {
                res[k] = item;
                k++;
            }
        }
        return res;
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        int s = size();

        if (ts.length < s) {
            return (T[]) toArray();
        }

        else {
            int k = 0;
            for (Song item : items) {
                if(item != null) {
                    ts[k] = (T) item;
                    k++;
                }
            }
            return ts;
        }
    }

    @Override
    public boolean add(Song song) {
        if(contains(song))
            return false;

        int s = size();
        if(s == items.length) {
            Object[] old = toArray();
            items = new Song[Math.round(items.length * 1.3f)];
            int k = 0;
            for (Object item : old) {
                items[k] = (Song) item;
                k++;
            }
        }

        for (int i = 0; i < items.length; i++) {
            if(items[i] == null) {
                items[i] = song;
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < items.length; i++) {
            if(items[i] == o) {
                items[i] = null;
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        for (Object o : collection) {
            if(!contains(o))
                return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends Song> collection) {
        for (Song o : collection) {
            add(o);
        }
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        for (Song item : items) {
            if (!collection.contains(item)) {
                remove(item);
            }
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        for (Song item : items) {
            if (collection.contains(item)) {
                remove(item);
            }
        }
        return true;
    }

    @Override
    public void clear() {
        items = new Song[15];
    }
}
