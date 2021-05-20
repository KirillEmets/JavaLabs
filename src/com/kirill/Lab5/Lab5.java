package com.kirill.Lab5;

public class Lab5 {
    public static void main(String[] args) {
        final String input = "Lorem ipsum dolor sit amet, consectetur adipiscing elit." +
                " Sed interdum erat dui. Suspendisse semper tincidunt nulla, eget ornare lorem congue quis." +
                " Fusce tempus semper massa a dictum. Aliquam imperdiet elementum lacus, laoreet hendrerit justo." +
                " Praesent congue efficitur mi, vel luctus sem dapibus et. Suspendisse sed leo et massa lobortis malesuada." +
                " Sed quis nunc enim. Vivamus bibendum sapien justo, ac lacinia lectus aliquam nec.";

        Text text = formText(input);
        edit(text);
        System.out.println(text);
    }

    static Text formText(String s) {
        s = s.replace(", ", ",");
        s = s.replace(". ", ".");
        s = s.replace("! ", "!");

        Text text = new Text();
        Sentence currentSentence = new Sentence();
        Word currentWord = new Word();

        for (char c: s.toCharArray()) {
            if(c == ' ') {
                currentSentence.add(currentWord);
                currentWord = new Word();
            }
            else if(c == ',') {
                currentSentence.add(currentWord);
                currentWord = new Word();
                currentSentence.add(new Punctuation(c));
            }

            else if(c == '.' || c == '!') {
                currentSentence.add(currentWord);
                currentWord = new Word();
                currentSentence.add(new Punctuation(c));
                text.add(currentSentence);
                currentSentence = new Sentence();
            }
            else currentWord.add(new Letter(c));
        }
        return text;
    }

    static void edit(Text text) {
        for (Sentence sentence: text.sentences) {
            SentencePart tmp = sentence.parts.get(0);
            sentence.parts.set(0, sentence.parts.get(sentence.parts.size() - 2));
            sentence.parts.set(sentence.parts.size() - 2, tmp);
        }
    }

}
