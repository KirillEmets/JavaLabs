package com.kirill.Lab2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        byte[][] a = new byte[][] {{1, 2}, {3, 53}, {5, 6}};
        byte[][] b = new byte[][] {{1, 22}, {32, 74}, {55, 6}};
        MyClassL2.calculate(a, b);
    }
}

// 9507
// C5 = 2  C = A + B
// C7 = 1  byte
// C11 = 3 Обчислити суму найбільших елементів кожного рядка матриці

class MyClassL2 {
    public static void calculate(byte[][] a, byte[][] b) {
        if(a == null) {
            System.out.println("a is null");
            return;
        }
        if(b == null) {
            System.out.println("b is null");
            return;
        }
        if(a.length != b.length) {
            System.out.println("sizes don't match");
            return;
        }
        if(a[0] == null) {
            return;
        }

        int h = a.length;
        int w = a[0].length;

        byte[][] res = new byte[h][w];
        int t;

        byte max;
        int maxSum = 0;

        for (int i = 0; i < h; i++) {
            if(a[i] == null || b[i] == null) {
                System.out.println("some of the values are null");
                return;
            }
            if(a[i].length != b[i].length) {
                System.out.println("sizes don't match");
                return;
            }

            max = -128;

            for (int j = 0; j < w; j++) {
                t = a[i][j] + b[i][j];
                if(t <= -128 || t > 127) {
                    System.out.println("sum of numbers is out of byte's bounds");
                    return;
                }

                res[i][j] = (byte) t;

                if(t > max)
                    max = (byte) t;

            }

            maxSum += max;
        }
        System.out.println("A = " + Arrays.deepToString(a));
        System.out.println("B = " + Arrays.deepToString(b));
        System.out.println("A + B = " + Arrays.deepToString(res));
        System.out.println("Сума найбільших елементів кожного рядка: " + maxSum);
    }
}
