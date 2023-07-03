package com.amrita.jpl.cys21067.practice.interface1;
import java.util.ArrayList;
import java.util.List;

/**
 * This interface represents a list operation.
 */
interface ListOperation {

    /**
     * Adds an element to the list.
     *
     * @param element the element to add
     */
    void addElement(String element);

    /**
     * Removes an element from the list.
     *
     * @param element the element to remove
     */
    void removeElement(String element);

    /**
     * Retrieves the elements in the list.
     *
     * @return a list of elements
     */
    List<String> getElements();
}

/**
 * This class implements the ListOperation interface.
 */
class MyList implements ListOperation {
    private List<String> elements;

    /**
     * Constructs a new MyList object.
     */
    public MyList() {
        elements = new ArrayList<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addElement(String element) {
        elements.add(element);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeElement(String element) {
        elements.remove(element);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> getElements() {
        return elements;
    }
}

/**
 * This class is used to demonstrate the usage of the MyList class.
 */
public class ine4 {
    public static void main(String[] args) {
        ListOperation myList = new MyList();
        myList.addElement("Apple");
        myList.addElement("Banana");
        System.out.println(myList.getElements());   // Output: [Apple, Banana]
        myList.removeElement("Apple");
        System.out.println(myList.getElements());   // Output: [Banana]
    }
}
