package com.amrita.jpl.cys21083.Practise.DataStructures;

import java.util.HashMap;
public class HashMapEx {
    public HashMapEx() {
    }

    public static void main(String[] args) {
        HashMap<String, String> rollName = new HashMap();
        rollName.put("CB.EN.U4CYS21001", "Abinesh G");
        rollName.put("CB.EN.U4CYS21011", "A S Deepan");
        rollName.put("CB.EN.U4CYS21021", "Gundala Kushal Bhavani Reddy");
        rollName.put("CB.EN.U4CYS21031", "Kishanth K");
        rollName.put("CB.EN.U4CYS21041", "Middivari Charan Kumar Reddy");
        rollName.put("CB.EN.U4CYS21051", "Nithin S");
        rollName.put("CB.EN.U4CYS21061", "Roshni V");
        rollName.put("CB.EN.U4CYS21071", "Sourabh Sasikanthan");
        rollName.put("CB.EN.U4CYS21081", "Koti Venkatadinesh Reddy");
        System.out.println((String)rollName.get("CB.EN.U4CYS21011"));
        System.out.println((String)rollName.get("CB.EN.U4CYS21021"));

        rollName.remove("CB.EN.U4CYS21001");
        System.out.println((String)rollName.get("CB.EN.U4CYS21001"));


    }
}
