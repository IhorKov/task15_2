package com.company;

public class Reader implements Runnable{
    private String[] arr;
    private int from;
    private int to;

    public Reader(String[] arr, int from, int to) {
        this.arr = arr;
        this.from = from;
        this.to = to;
    }

    @Override
    public void run() {

        for (int i = from; i < to; i++) {
            if (i % 5 == 0 && i % 3 == 0) {
                arr[i] = "FizzBuzz";
            }
            else if(i % 3 == 0) {
                arr[i] = "Buzz";
            }
            else if(i % 5 == 0) {
                arr[i] = "Fizz";
            }
            else {
                arr[i] = String.valueOf(i);
            }

        }
    }
}
