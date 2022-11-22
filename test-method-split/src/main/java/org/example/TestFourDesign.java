package org.example;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Fork(value = 1, jvmArgs = {"-Xms512m", "-Xmx512m"})
@State(Scope.Benchmark)
@Warmup(iterations = 2, time = 200, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 3, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
@Timeout(time = 1, timeUnit = TimeUnit.MINUTES)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class TestFourDesign {

    final String firstString_1 = "I originally approached Java as just another programming language. But as time passed and I studied it more deeply.";
    final String secondString_1 = "Because of this complexity most of our programming projects fail. And yet of all.";
    final String firstString_2 = "I originally approached Java as just another programming language. But as time passed and I studied it more deeply. " +
            "I began to see that the fundamental intent of this language was different from other languages I had seen up to that point. " +
            "Programming is about managing complexity. The complexity of the problem you " +
            "want to solve. Laid upon the complexity of the machine in which it is solved." + "I originally approached Java as just another programming language. But as time passed and I studied it more deeply. " +
            "I began to see that the fundamental intent of this language was different from other languages I had seen up to that point. " +
            "Programming is about managing complexity. The complexity of the problem you " +
            "want to solve. Laid upon the complexity of the machine in which it is solved." + "I originally approached Java as just another programming language. But as time passed and I studied it more deeply. " +
            "I began to see that the fundamental intent of this language was different from other languages I had seen up to that point. " +
            "Programming is about managing complexity. The complexity of the problem you " +
            "want to solve. Laid upon the complexity of the machine in which it is solved."+ "I originally approached Java as just another programming language. But as time passed and I studied it more deeply. " +
            "I began to see that the fundamental intent of this language was different from other languages I had seen up to that point. " +
            "Programming is about managing complexity. The complexity of the problem you " +
            "want to solve. Laid upon the complexity of the machine in which it is solved." + "I originally approached Java as just another programming language. But as time passed and I studied it more deeply. " +
            "I began to see that the fundamental intent of this language was different from other languages I had seen up to that point. " +
            "Programming is about managing complexity. The complexity of the problem you " +
            "want to solve. Laid upon the complexity of the machine in which it is solved." + "I originally approached Java as just another programming language. But as time passed and I studied it more deeply. " +
            "I began to see that the fundamental intent of this language was different from other languages I had seen up to that point. " +
            "Programming is about managing complexity. The complexity of the problem you " +
            "want to solve. Laid upon the complexity of the machine in which it is solved." + "I originally approached Java as just another programming language. But as time passed and I studied it more deeply. " +
            "I began to see that the fundamental intent of this language was different from other languages I had seen up to that point. " +
            "Programming is about managing complexity. The complexity of the problem you " +
            "want to solve. Laid upon the complexity of the machine in which it is solved." + "I originally approached Java as just another programming language. But as time passed and I studied it more deeply. " +
            "I began to see that the fundamental intent of this language was different from other languages I had seen up to that point. " +
            "Programming is about managing complexity. The complexity of the problem you " +
            "want to solve. Laid upon the complexity of the machine in which it is solved."+ "I originally approached Java as just another programming language. But as time passed and I studied it more deeply. " +
            "I began to see that the fundamental intent of this language was different from other languages I had seen up to that point. " +
            "Programming is about managing complexity. The complexity of the problem you " +
            "want to solve. Laid upon the complexity of the machine in which it is solved.";
    final String secondString_2 = "Because of this complexity most of our programming projects fail. And yet of all " +
            "the programming languages of which I am aware. Almost none have gone all out " +
            "and decided that their main design goal would be to conquer the complexity of " +
            "developing and maintaining programs. Many language design decisions were made " +
            "with complexity in mind. But at some point there were always other issues that " +
            "were considered essential to be added into the mix." + "Because of this complexity most of our programming projects fail. And yet of all " +
            "the programming languages of which I am aware. Almost none have gone all out " +
            "and decided that their main design goal would be to conquer the complexity of " +
            "developing and maintaining programs. Many language design decisions were made " +
            "with complexity in mind. But at some point there were always other issues that " +
            "were considered essential to be added into the mix." + "Because of this complexity most of our programming projects fail. And yet of all " +
            "the programming languages of which I am aware. Almost none have gone all out " +
            "and decided that their main design goal would be to conquer the complexity of " +
            "developing and maintaining programs. Many language design decisions were made " +
            "with complexity in mind. But at some point there were always other issues that " +
            "were considered essential to be added into the mix." + "Because of this complexity most of our programming projects fail. And yet of all " +
            "the programming languages of which I am aware. Almost none have gone all out " +
            "and decided that their main design goal would be to conquer the complexity of " +
            "developing and maintaining programs. Many language design decisions were made " +
            "with complexity in mind. But at some point there were always other issues that " +
            "were considered essential to be added into the mix." + "Because of this complexity most of our programming projects fail. And yet of all " +
            "the programming languages of which I am aware. Almost none have gone all out " +
            "and decided that their main design goal would be to conquer the complexity of " +
            "developing and maintaining programs. Many language design decisions were made " +
            "with complexity in mind. But at some point there were always other issues that " +
            "were considered essential to be added into the mix." + "Because of this complexity most of our programming projects fail. And yet of all " +
            "the programming languages of which I am aware. Almost none have gone all out " +
            "and decided that their main design goal would be to conquer the complexity of " +
            "developing and maintaining programs. Many language design decisions were made " +
            "with complexity in mind. But at some point there were always other issues that " +
            "were considered essential to be added into the mix.";

    @Param({firstString_1, firstString_2})
    String text1;
    @Param({secondString_1, secondString_2})
    String text2;

    @Benchmark
    public void testForFirstDesign(Blackhole bh) {
        for (int i = 0; i < 100_000; i++){
            FirstDesign.concat(text1,text2);
        }


    }

    @Benchmark
    public void testForSecondDesign(Blackhole bh) {
        for (int i = 0; i < 100_000; i++){
            SecondDesign.concat(text1,text2);
        }
    }

    @Benchmark
    public void testForMyFirstDesign(Blackhole bh) {
        for (int i = 0; i < 100_000; i++){
            MyFirstDesign.concat(text1,text2);
        }
    }
}
