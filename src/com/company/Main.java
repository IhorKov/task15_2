package com.company;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        String[] arrOne = new String[20_000_000];
        String[] arrTwo = new String[20_000_000];

        Reader r1 = new Reader(arrOne, 0, 5_000_000);
        Reader r2 = new Reader(arrOne, 5_000_000, 10_000_000);
        Reader r3 = new Reader(arrOne, 10_000_000, 15_000_000);
        Reader r4 = new Reader(arrOne, 15_000_00, 20_000_000);
        Reader singleReader = new Reader(arrTwo, 0, 20_000_000);

        long startOne = System.currentTimeMillis();

        new Thread(r1).start();
        new Thread(r2).start();
        new Thread(r3).start();
        new Thread(r4).start();

        long endOne = System.currentTimeMillis();

        long startTwo = System.currentTimeMillis();

        new Thread(singleReader).start();

        long endTwo = System.currentTimeMillis();

        long msDelayOne = endOne - startOne;
        long msDelayTwo = endTwo - startTwo;

        System.out.println("Time distance is: " + msDelayOne + " in ms");
        System.out.println("Time distance is: " + msDelayTwo + " in ms");
    }
}
