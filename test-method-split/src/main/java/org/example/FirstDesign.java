package org.example;

import java.util.Date;

public class FirstDesign {

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

    public static double averageLength(String text) {
        double averageLength = 0;
        int sentenceCounter = 0;
        for (String currentSentence : text.split(" ")) {
            if (currentSentence.charAt(currentSentence.length() - 1) == '.') {
                sentenceCounter++;
            }
            averageLength++;
        }
        return averageLength / sentenceCounter;
    }

    public static String concat(String firstString, String secondString) {
        String result = "";
        String[] firstArray = firstString.split(" ");
        String[] secondArray = secondString.split(" ");
        if (averageLength(firstString) > averageLength(secondString)) {
            for (int pointer = 0; pointer < 2; pointer++) {
                result = result + firstArray[pointer] + " ";
            }
            for (int pointer = secondArray.length - 2; pointer < secondArray.length; pointer++) {
                result = result + secondArray[pointer] + " ";
            }
        } else {
            for (int pointer = 0; pointer < 2; pointer++) {
                result = result + secondArray[pointer]  + " ";
            }
            for (int pointer = firstArray.length - 2; pointer < firstArray.length; pointer++) {
                result = result + firstArray[pointer] + " ";
            }
        }
        return result;
    }

}