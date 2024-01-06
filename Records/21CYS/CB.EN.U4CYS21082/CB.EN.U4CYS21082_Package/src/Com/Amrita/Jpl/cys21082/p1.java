import java.util.Scanner;

public class p1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int choice = input.nextInt();

        switch (choice) {
            case 1:
                System.out.println("You chose factorial.");
                System.out.print("Enter a number: ");
                int numFact = input.nextInt();
                if (numFact < 0) {
                    System.out.println("Error: Number must be non-negative.");
                } else {
                    int resultFact = fact(numFact);
                    System.out.println("Factorial of " + numFact + " is " + resultFact + ".");
                }
                break;
            case 2:
                System.out.println("You chose Fibonacci.");
                System.out.print("Enter a number: ");
                int numFibo = input.nextInt();
                if (numFibo < 0) {
                    System.out.println("Error: Number must be non-negative.");
                } else {
                    fibo(numFibo);
                }
                break;
            case 3:
                System.out.println("You chose sum n no.");
                System.out.print("Enter a number: ");
                int numSum = input.nextInt();
                if (numSum < 0) {
                    System.out.println("Error: Number must be non-negative.");
                } else {
                    int resultSum = sum(numSum);
                    System.out.println("Sum of first " + numSum + " numbers is " + resultSum + ".");
                }
                break;
            case 4:
                System.out.println("You chose prime test.");
                System.out.print("Enter a number: ");
                int numPrime = input.nextInt();
                if (numPrime < 2) {
                    System.out.println("Error: Number must be greater than or equal to 2.");
                } else {
                    boolean resultPrime = isPrime(numPrime);
                    if (resultPrime) {
                        System.out.println(numPrime + " is a prime number.");
                    } else {
                        System.out.println(numPrime + " is not a prime number.");
                    }
                }
                break;
            default:
                System.out.println("Error: Invalid choice.");
                break;
        }
    }

    public static int fact(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * fact(n-1);
        }
    }

    public static void fibo(int n) {
        int a = 0;
        int b = 1;
        System.out.print("Fibonacci series up to " + n + " terms: ");
        for (int i = 1; i <= n; i++) {
            System.out.print(a + " ");
            int c = a + b;
            a = b;
            b = c;
        }
        System.out.println();
    }

    public static int sum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
