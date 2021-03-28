package com.kirill.Lab1;

public class Main {
    public static void main(String[] args) {
        double res = MyClassL1.calculate((short) 06, (short) 4, (short) 6, (short) 5);

//        double res = MyClassL1.calculate((short) 0, (short) 4, (short) 6, (short) 5);
//        double res = MyClassL1.calculate((short) 5, (short) -2, (short) 6, (short) 5);
//        double res = MyClassL1.calculate((short) 6, (short) 4, (short) 3, (short) 5);

        System.out.println(res);
    }
}

// 9507
// C2 = 1  - (O1)
// C3 = 0  0 (C)
// C5 = 2  % (O2)
// C7 = 1  short

class MyClassL1 {
    private static final int C = 0;
    public static double calculate(short a, short b, short n, short m) {
        if(a <= 0) {
            System.out.println("'a' must be > 0");
            throw new ArithmeticException();
        }
        if(b < 0) {
            System.out.println("'b' must be >= 1");
            throw new ArithmeticException();
        }
        if(n < a) {
            return 0;
        }
        if(m < b) {
            return 0;
        }

        double sum = 0;
        for (short i = a; i <= n; i++) {
            for (short j = b; j <= m; j++) {
                double num = i % j;
                double den =  i - C; // always i

                sum += num / den;
            }
        }
        return sum;
    }
}