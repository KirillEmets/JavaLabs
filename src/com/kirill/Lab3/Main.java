package com.kirill.Lab3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

//        final String input = "Hello world. What time is it. How Are You.";
        final String input = "Lorem ipsum dolor sit amet, consectetur adipiscing elit." +
                " Sed interdum erat dui. Suspendisse semper tincidunt nulla, eget ornare lorem congue quis." +
                " Fusce tempus semper massa a dictum. Aliquam imperdiet elementum lacus, laoreet hendrerit justo." +
                " Praesent congue efficitur mi, vel luctus sem dapibus et. Suspendisse sed leo et massa lobortis malesuada." +
                " Sed quis nunc enim. Vivamus bibendum sapien justo, ac lacinia lectus aliquam nec.";


        StringBuilder s = new StringBuilder(input);
        MyClassL3.editS(s);
        System.out.println(s.toString());

    }
}

// 9507
// C3 = 0  (StringBuilder)
// C17 = 4  В кожному реченні заданого тексту змінити місцями перше та останнє слово, не змінивши довжини речення.

class MyClassL3 {
    public static void editS(StringBuilder stringBuilder) {
        String text = stringBuilder.toString();

        boolean hasDotInTheEnd = false;
        if (text.endsWith(".")) {
            text = text.substring(0, text.length() - 1);
            hasDotInTheEnd = true;
        }

        String[] sentences = text.split("\\. ");

        int firstEnd; // first end
        int lastStart; // last start

        String s;
        stringBuilder.delete(0, stringBuilder.length());

        for (String sentence : sentences) {
            s = sentence;

            firstEnd = s.indexOf(" ");
            lastStart = s.lastIndexOf(" ");

            s = s.substring(lastStart + 1) +
                    s.substring(firstEnd, lastStart + 1) +
                    s.substring(0, firstEnd) + ". ";

            stringBuilder.append(s);
        }

        int length = stringBuilder.length();
        stringBuilder.delete(length - (hasDotInTheEnd ? 1 : 2), length);
    }
}