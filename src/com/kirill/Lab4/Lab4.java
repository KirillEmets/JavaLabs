package com.kirill.Lab4;

import java.util.Arrays;
import java.util.Comparator;

class Lab4 {
    public static void main(String[] args) {
        Plane[] planes = new Plane[] {
                new Plane("A", 1000, 200, 100, 300),
                new Plane("B", 2000, 300, 120, 300),
                new Plane("C", 500, 500, 80, 0),
                new Plane("D", 100, 400, 60, 100),
                new Plane("E", 10000, 600, 200, 500),
        };
        Arrays.sort(planes, Plane.ByCostComparator);
        System.out.println("Sorted by cost:");
        System.out.println(Arrays.toString(planes));

        Arrays.sort(planes, Plane.BySpeedComparator.reversed());
        System.out.println("Sorted by speed (reversed):");
        System.out.println(Arrays.toString(planes));

    }
}

// 9507 mod 11 = 3
class Plane {
    static Comparator<Plane> ByCostComparator = Comparator.comparingInt(plane -> plane.cost);
    static Comparator<Plane> BySpeedComparator = new Comparator<Plane>() {
        @Override
        public int compare(Plane plane, Plane t1) {
            return plane.speed - t1.speed;
        }
    };

    String name;
    int cost;
    int speed;
    int weight;
    int capacity;

    public Plane(String name, int cost, int speed, int weight, int capacity) {
        this.name = name;
        this.cost = cost;
        this.speed = speed;
        this.weight = weight;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "\n Plane {" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", speed=" + speed +
                ", weight=" + weight +
                ", capacity=" + capacity +
                "}";
    }
}