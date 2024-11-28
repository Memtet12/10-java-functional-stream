package com.example.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task04Main {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8))) {

            Map<String, Long> wordFrequency = reader.lines()
                    .flatMap(line -> Arrays.stream(line.split("\\P{L}+")))
                    .map(String::toLowerCase)
                    .filter(word -> !word.isEmpty())
                    .collect(Collectors.groupingBy(word -> word, Collectors.counting()));


            List<String> topWords = wordFrequency.entrySet().stream()
                    .sorted(Map.Entry.<String, Long>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                    .limit(10)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());


            String result = topWords.stream().collect(Collectors.joining("\n"));


            System.out.print(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
