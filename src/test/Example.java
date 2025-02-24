package test;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Example {
    public static int x = 3;
    public static void main(String[] args) {

        long i = 100_00_00_000;

//        long startTime = System.currentTimeMillis();
//        for(int j = 0; j < i; j++) {
//
//        }
//        long stringTime = System.currentTimeMillis() - startTime;
//        System.out.println(stringTime + "ms");

        long startTime = System.currentTimeMillis();

        LongStream.range(0, i).forEach(j -> { /* No operation */ });

        long streamTime = System.currentTimeMillis() - startTime;
        System.out.println(streamTime + "ms");



    }
}
