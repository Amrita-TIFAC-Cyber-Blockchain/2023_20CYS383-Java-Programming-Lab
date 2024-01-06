package Com.Amrita.Jpl.cys21082.Practise;


import java.util.Scanner;

public class BinarytoHexadecimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        int decimal = scanner.nextInt();

        if (decimal < 0) {
            System.out.println("Error: Only non-negative integers are allowed.");
            return;
        }

        String binary = Integer.toBinaryString(decimal);
        String hexadecimal = Integer.toHexString(decimal);

        System.out.println("Binary equivalent: " + binary);
        System.out.println("Hexadecimal equivalent: " + hexadecimal);
    }
}
