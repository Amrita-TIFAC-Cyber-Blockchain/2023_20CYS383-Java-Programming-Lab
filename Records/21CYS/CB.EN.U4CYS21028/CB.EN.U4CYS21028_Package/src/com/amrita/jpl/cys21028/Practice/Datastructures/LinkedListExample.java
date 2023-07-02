import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<Integer> u21cys = new LinkedList<Integer>();

        u21cys.add(3);
        u21cys.add(4);
        u21cys.add(46);
        u21cys.add(7);
        u21cys.add(31);

        // Print the contents of the LinkedList
        System.out.println("LinkedList: " + u21cys);

        // Remove an element from the LinkedList
        u21cys.removeFirst();
        System.out.println("Updated LinkedList: " + u21cys);
    }
}
