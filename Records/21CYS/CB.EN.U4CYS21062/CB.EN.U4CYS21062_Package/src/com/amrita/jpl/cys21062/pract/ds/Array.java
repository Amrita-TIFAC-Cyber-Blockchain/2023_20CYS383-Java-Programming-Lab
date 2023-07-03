public class Array {
    /**
     * The main method is the entry point of the program.
     * It creates an array of roll numbers and prints each names using a for loop.
     *
     * @param args command line arguments
     */
    public static void main(String args[]) {
        String names[] = new String[5];

        names[0] = "Ruthwik";
        names[1] = "Siva";
        names[2] = "pavan";
        names[3] = "rohit";
        names[4] = "ravi";

        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }
    }
}