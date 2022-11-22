package org.example;

public class MyFirstDesign {
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

    public static double averageLength(String paragraph){
        String[] sentences = paragraph.split("[.]");
        int[] countWordsInSentence = new int[sentences.length];
        int sumAllWords = 0;
        for (int i = 0 ; i < sentences.length; i++){
            countWordsInSentence[i] = sentences[i].trim().split(" ").length;
            sumAllWords += countWordsInSentence[i];
            //System.out.println("There are " + countWordsInSentence[i] + " words in " + (i+1) + " sentence" );
        }
        return (double) sumAllWords / sentences.length;
    }

    public static String concat(String paragraph1, String paragraph2){
        double average1 = averageLength(paragraph1);
        double average2 = averageLength(paragraph2);
        String newSentence;
        if (average1 - average2 > 0.001) {
            int countWordsInLastSentence = paragraph2.split("[.]")[paragraph2.split("[.]").length-1].trim().split(" ").length;
            newSentence = paragraph1.split("[.]")[0].trim().split(" ")[0] +
                    " " + paragraph1.split("[.]")[0].trim().split(" ")[1] +
                    " " + paragraph2.split("[.]")[paragraph2.split("[.]").length-1].trim().split(" ")[countWordsInLastSentence-2] +
                    " " + paragraph2.split("[.]")[paragraph2.split("[.]").length-1].trim().split(" ")[countWordsInLastSentence-1] + ".";
            ;
        } else {
            int countWordsInLastSentence = paragraph1.split("[.]")[paragraph1.split("[.]").length-1].trim().split(" ").length;
            newSentence = paragraph2.split("[.]")[0].trim().split(" ")[0] +
                    " " + paragraph2.split("[.]")[0].trim().split(" ")[1] +
                    " " + paragraph1.split("[.]")[paragraph1.split("[.]").length-1].trim().split(" ")[countWordsInLastSentence-2] +
                    " " + paragraph1.split("[.]")[paragraph1.split("[.]").length-1].trim().split(" ")[countWordsInLastSentence-1] + ".";
        }
        return newSentence;
    }
}

