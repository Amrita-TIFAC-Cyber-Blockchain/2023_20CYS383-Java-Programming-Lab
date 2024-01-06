package Com.Amrita.Jpl.cys21082.Practise;

public class flag {
    public static void main(String[] args) {
        printFlagPattern();
    }

    private static void printFlagPattern() {
        int rows = 7;
        int columns = 15;

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                if (i <= 3) {
                    if (j <= 6)
                        System.out.print("*");
                    else
                        System.out.print("=");
                } else {
                    if (j <= 6)
                        System.out.print("=");
                    else
                        System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}
