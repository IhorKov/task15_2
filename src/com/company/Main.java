package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        String[] arrOne = new String[20_000_000];
        String[] arrTwo = new String[20_000_000];

        Reader r1 = new Reader(arrOne, 0, 5_000_000);
        Reader r2 = new Reader(arrOne, 5_000_000, 10_000_000);
        Reader r3 = new Reader(arrOne, 10_000_000, 15_000_000);
        Reader r4 = new Reader(arrOne, 15_000_00, 20_000_000);
        Reader singleReader = new Reader(arrTwo, 0, 20_000_000);

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);
        Thread t4 = new Thread(r4);
        Thread tSingle = new Thread(singleReader);

        long startOne = System.currentTimeMillis();

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        long endOne = System.currentTimeMillis();

        long startTwo = System.currentTimeMillis();

        tSingle.start();
        tSingle.join();

        long endTwo = System.currentTimeMillis();

        long msDelayOne = endOne - startOne;
        long msDelayTwo = endTwo - startTwo;

        System.out.println("Time distance is: " + msDelayOne + " in ms");
        System.out.println("Time distance is: " + msDelayTwo + " in ms");
    }
}
