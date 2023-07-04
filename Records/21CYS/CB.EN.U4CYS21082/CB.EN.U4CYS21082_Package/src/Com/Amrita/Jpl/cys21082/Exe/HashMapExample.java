package Com.Amrita.Jpl.cys21082.Exe;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {

    public static void main(String[] args) {
        // Create a HashMap object called rollName
        Map<String, String> rollName = new HashMap<>();

        // Add keys and values (roll numbers and names) to the HashMap using the put() method
        rollName.put("CB.EN.U4CYS21001", "kavya");
        rollName.put("CB.EN.U4CYS21061", "Arjun");
        rollName.put("CB.EN.U4CYS21029", " KoushikReddy");
        rollName.put("CB.EN.U4CYS21090", "Kiran");
        rollName.put("CB.EN.U4CYS21063", "Navanith");
        rollName.put("CB.EN.U4CYS21015", "Nishanth");
        rollName.put("CB.EN.U4CYS21009", "Roshni");
        rollName.put("CB.EN.U4CYS21008", "Sourabh");
        rollName.put("CB.EN.U4CYS21089", "Navya");

        // Retrieve and print the name associated with a specific roll number
        System.out.println(rollName.get("CB.EN.U4CYS21011"));
    }
}
