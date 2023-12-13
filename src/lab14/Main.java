package lab14;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;

interface IWaitList<E> {
    void add(E element);
    E remove();
    boolean contains(E element);
    boolean containsAll(Collection<E> c);
    boolean isEmpty();
}

class WaitList<E> implements IWaitList<E> {
    protected ConcurrentLinkedQueue<E> content;

    public WaitList() {
        this.content = new ConcurrentLinkedQueue<>();
    }

    public WaitList(Collection<E> c) {
        this.content = new ConcurrentLinkedQueue<>(c);
    }

    @Override
    public void add(E element) {
        content.add(element);
    }

    @Override
    public E remove() {
        return content.poll();
    }

    @Override
    public boolean contains(E element) {
        return content.contains(element);
    }

    @Override
    public boolean containsAll(Collection<E> c) {
        return content.containsAll(c);
    }

    @Override
    public boolean isEmpty() {
        return content.isEmpty();
    }

    @Override
    public String toString() {
        return content.toString();
    }
}

class BoundedWaitList<E> extends WaitList<E> {
    private int capacity;

    public BoundedWaitList(int capacity) {
        super();
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public void add(E element) {
        if (content.size() < capacity) {
            super.add(element);
        } else {
            throw new IllegalStateException("WaitList is full");
        }
    }

    @Override
    public String toString() {
        return "BoundedWaitList{" +
                "capacity=" + capacity +
                ", content=" + content +
                '}';
    }

    // Adding a method to remove an item that is not the first in the queue
    public void removeNonFirstOccurrence(E element) {
        content.remove(element);
    }

    // Adding a method to send the first item back to the end of the list
    public void sendFirstToEnd() {
        if (!content.isEmpty()) {
            E first = content.poll();
            content.add(first);
        }
    }
}

class UnfairWaitList<E> extends WaitList<E> {

    public UnfairWaitList() {
        super();
    }

    public void remove(E element) {
        content.remove(element);
    }

    public void moveToBack(E element) {
        if (content.remove(element)) {
            content.add(element);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating a WaitList
        WaitList<Integer> waitList = new WaitList<>();
        waitList.add(10);
        waitList.add(20);
        waitList.add(30);

        System.out.println("WaitList:");
        System.out.println(waitList); // Displaying the content of the wait list

        // Creating a BoundedWaitList with capacity 5
        BoundedWaitList<String> boundedWaitList = new BoundedWaitList<>(5);
        boundedWaitList.add("One");
        boundedWaitList.add("Two");
        boundedWaitList.add("Three");

        System.out.println("\nBoundedWaitList:");
        System.out.println(boundedWaitList); // Displaying the content of the bounded wait list

        // Trying to add more elements than the capacity allows
        try {
            boundedWaitList.add("Four");
            boundedWaitList.add("Five");
            boundedWaitList.add("Six"); // This will throw an IllegalStateException
        } catch (IllegalStateException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // Removing a non-first occurrence from the BoundedWaitList
        boundedWaitList.removeNonFirstOccurrence("Two");
        System.out.println("\nBoundedWaitList after removing non-first occurrence of 'Two':");
        System.out.println(boundedWaitList);

        // Sending the first element to the end of the BoundedWaitList
        boundedWaitList.sendFirstToEnd();
        System.out.println("\nBoundedWaitList after sending the first element to the end:");
        System.out.println(boundedWaitList);

        // Creating an UnfairWaitList
        UnfairWaitList<Character> unfairWaitList = new UnfairWaitList<>();
        unfairWaitList.add('A');
        unfairWaitList.add('B');
        unfairWaitList.add('C');

        System.out.println("\nUnfairWaitList:");
        System.out.println(unfairWaitList); // Displaying the content of the unfair wait list

        // Moving an element to the back of the UnfairWaitList
        unfairWaitList.moveToBack('B');
        System.out.println("\nUnfairWaitList after moving 'B' to the back:");
        System.out.println(unfairWaitList);

        // Removing an element from the UnfairWaitList
        unfairWaitList.remove('C');
        System.out.println("\nUnfairWaitList after removing 'C':");
        System.out.println(unfairWaitList);
    }
}


