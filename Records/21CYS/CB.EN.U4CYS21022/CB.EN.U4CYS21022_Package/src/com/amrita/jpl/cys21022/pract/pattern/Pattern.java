package com.amrita.jpl.cys21022.pract.pattern;
class Pattern {
    public static void main(String[] args) {
        for(int i = 1; i <= 15; ++i) {
            int k;
            if (i >= 9) {
                for(k = 1; k <= 46; ++k) {
                    System.out.print("=");
                }
            } else {
                k = 1;

                label43:
                while(true) {
                    if (k > 6) {
                        k = 1;

                        while(true) {
                            if (k > 34) {
                                break label43;
                            }

                            System.out.print("=");
                            ++k;
                        }
                    }

                    if (i % 2 == 0 && k == 6) {
                        System.out.print(" =");
                    } else {
                        System.out.print("* ");
                    }

                    ++k;
                }
            }

            System.out.println(" ");
        }

    }
}
