package com.amrita.jpl.cys21033.pract;
/**
 * @author Suhitha K
 * @param //calculating factorial in java
 * @version 0.5
 */
public class Factorial {
    public static void main(String[] args) {

        int num = 10;
        long factorial = 1;
        for (int i = 1; i <= num; ++i) {
            // factorial = factorial * i;
            factorial *= i;
        }
        System.out.printf("Factorial of %d = %d", num, factorial);
    }
}
