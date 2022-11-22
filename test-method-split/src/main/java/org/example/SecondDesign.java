package org.example;

public class SecondDesign {

    /*public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String firstString = "I originally approached Java as just another programming language. But as time passed and I studied it more deeply. " +
                "I began to see that the fundamental intent of this language was different from other languages I had seen up to that point. " +
                "Programming is about managing complexity. The complexity of the problem you " +
                "want to solve. Laid upon the complexity of the machine in which it is solved.";
        String secondString = "Because of this complexity most of our programming projects fail. And yet of all " +
                "the programming languages of which I am aware. Almost none have gone all out " +
                "and decided that their main design goal would be to conquer the complexity of " +
                "developing and maintaining programs. Many language design decisions were made " +
                "with complexity in mind. But at some point there were always other issues that " +
                "were considered essential to be added into the mix.";
        for (int i = 0; i < 1_000_000; i++){
            concat(firstString, secondString);
        }
        System.out.println(concat(firstString, secondString));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }*/

    public static double averageLength (String text) {
        int sentences = 0;
        int words = 0;

        for (int i = 0; i < text.length(); i++){
            if (text.charAt(i) == ' ') {
                words++;
            } else if (text.charAt(i) == '.'){
                sentences++;
                words++;
                i++;
            }
        }

        return (double) words / sentences;
    }

    public static String concat (String text1, String text2){
        double averageText1 = averageLength(text1);
        double averageText2 = averageLength(text2);

        if (averageText1 > averageText2) {
            return firstTwoWords(text1).concat(finalTwoWords(text2));
        } else {
            return firstTwoWords(text2).concat(finalTwoWords(text1));
        }
    }

    private static String firstTwoWords (String text) {
        boolean findFirstWord = true;
        int i = 0;
        for (; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                if (findFirstWord) {
                    findFirstWord = false;
                } else {
                    break;
                }
            }
        }
        return text.substring(0,i);
    }

    private static String finalTwoWords (String text) {
        boolean findFirstWord = true;
        int i = text.length()-1;
        for (; i > -1; i--) {
            if (text.charAt(i) == ' ') {
                if (findFirstWord) {
                    findFirstWord = false;
                } else {
                    break;
                }
            }
        }
        return text.substring(i);
    }
}
