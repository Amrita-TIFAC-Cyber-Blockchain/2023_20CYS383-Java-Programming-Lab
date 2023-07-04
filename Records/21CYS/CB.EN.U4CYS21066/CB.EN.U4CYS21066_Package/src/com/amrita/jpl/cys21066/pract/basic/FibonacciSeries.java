package com.amrita.jpl.cys21066.pract.basic;

class FibonacciSeries {
    public static void main(String[] args) {
        int n = 10; // Number of terms in the series

        System.out.println("Fibonacci Series:");
        for (int i = 0; i < n; i++) {
            int fibonacciNumber = fibonacci(i);
            System.out.print(fibonacciNumber + " ");
        }
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}

