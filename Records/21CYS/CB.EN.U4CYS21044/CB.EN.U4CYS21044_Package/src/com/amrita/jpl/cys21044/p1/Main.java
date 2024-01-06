
package com.amrita.jpl.cys21044.p1;



import java.util.InputMismatchException;
import java.util.Scanner;




public class Main {
    /**
     * @author -Ravi chandra cys21044
     */

    static int reverse_num() {
        Scanner scanner = new Scanner(System.in);
        try {
            int num = scanner.nextInt();
            /**
             * @param num - the number need to be reversed
             */
            String numberStr = Integer.toString(Math.abs(num));
            StringBuilder reversedStr = new StringBuilder(numberStr).reverse();
            int reversedNum = Integer.parseInt(reversedStr.toString());

            return num < 0 ? -reversedNum : reversedNum;
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
            throw e;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
            throw e;
        }
    }






    static int large3num() {
        /**
         * @param x - number1
         * @param y - number2
         * @param z - number3
         */
        Scanner scanner = new Scanner(System.in);
        try {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            int r;

            if (x > y && x > z) {
                r = x;
            } else if (y > x && y > z) {
                r = y;
            } else {
                r = z;
            }

            return r;
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Invalid input. Please enter valid integers.");
        }
    }




    static int perfect_square_check() {
        /**
         * @param p - number need to be checked for perfect square
         */
        Scanner scanner = new Scanner(System.in);
        try {
            int p = scanner.nextInt();

            if (p < 0) {
                throw new IllegalArgumentException("Invalid input. Please enter a non-negative integer.");
            }

            double sqrt = Math.sqrt(p);
            int sqr = (int) sqrt;

            if (sqr * sqr == p) {
                System.out.println(p + " is a perfect square");
            } else {
                System.out.println(p + " is not a perfect square");
            }

            return 0;
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
            return 0;
        }
    }





    static int prime_test() {
        /**
         * @param q - number for prime test
         */
        Scanner scanner = new Scanner(System.in);
        int q= scanner.nextInt();
        int i;
        if(q==0){

            System.out.println("error:enter a correct number");

        } else if (q<0) {
            System.out.println("error:enter a correct number");
        }
        else if(q==1){
            System.out.println("1 is neither a prime number nor a composite number.");
        }
        else if(q==2 || q==3 || q==5){
            System.out.println("is a prime");
        }
        else {
            int b=0;

            for (i = 2; i<=(q/2); i++) {
                if (q % i != 0 && q != i) {
                    b=1;
                }
            }
            if(b==1){
                System.out.println(q+"is a prime");
            }
            else{
                System.out.println(q+"is nonprime");
            }
        }


        return 0;
    }


    public static void main(String[] args) {
        int choice;

        Scanner scanner = new Scanner(System.in);
        System.out.println("1.reverse number");
        System.out.println("2.largestnumber");
        System.out.println("3.perfectsquare test");
        System.out.println("4.prime test");
        System.out.println("Enter your choice: ");
        choice = scanner.nextInt();
        Main obj = new Main();
        if(choice==1){

            int x = obj.reverse_num();
            System.out.println(x+"is reverse of number");

        }
        else if(choice==2){
            int y = obj.large3num();
            System.out.println(y+"is largest number");

        }
        else if(choice==3){
            obj.perfect_square_check();

        }
        else if(choice==4){
            obj.prime_test();

        }

        else{
            System.out.println("enter a valid number from 1,2,3,4");

        }
    }
}
