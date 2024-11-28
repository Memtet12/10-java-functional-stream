package com.example.task02;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Task02Main {

    public static void main(String[] args) {


        cycleGrayCode(2)
                .limit(10)
                .forEach(System.out::println);


    }

    public static IntStream cycleGrayCode(int n) {
        if (n < 1 || n>16) throw new  IllegalArgumentException();
       List<String> grayCode = generateGrayCode(n);
       int[] grayCodeInts = grayCode.stream()
               .mapToInt(s -> Integer.parseInt(s, 2))
               .toArray();
        return IntStream.iterate(0, i -> (i + 1) % grayCodeInts.length)
                .map(i -> grayCodeInts[i]);

    }
    public static List<String> generateGrayCode(int n) {
        if (n == 1)
        {
            List<String> grayCode = new ArrayList<>();
            grayCode.add("0");
            grayCode.add("1");
            return grayCode;
        }
        List<String> prevGrayCode = generateGrayCode(n - 1);
        List<String> grayCode = new ArrayList<>();

        for(String code : prevGrayCode)
        {
            grayCode.add("0"+code);
        }

        for (int i = prevGrayCode.size() - 1; i >= 0; i--) {
            grayCode.add("1" + prevGrayCode.get(i));
        }

        return grayCode;
    }

}

