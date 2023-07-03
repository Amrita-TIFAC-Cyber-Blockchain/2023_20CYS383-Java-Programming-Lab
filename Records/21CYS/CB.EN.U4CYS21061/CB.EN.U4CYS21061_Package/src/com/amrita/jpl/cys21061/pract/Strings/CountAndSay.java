package com.amrita.jpl.cys21061.pract.Strings;
public class CountAndSay {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(CountAndSay(11));

    }

    public static String CountAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        String myans = CountAndSay(n - 1);
        int i = 0;
        StringBuilder finalans = new StringBuilder();
        while (i < myans.length()) {
            int count = 0;
            char c = myans.charAt(i);
            while (i < myans.length() && myans.charAt(i) == c) {
                i++;
                count++;
            }
            finalans.append(count);
            finalans.append(c);
        }
        return finalans.toString();

    }

}