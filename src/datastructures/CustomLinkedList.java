package datastructures;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class CustomLinkedList<T> implements Iterable<T> {
    private Node<T> head;
    private int size;

    public CustomLinkedList() {
        this.head = null;
        this.size = 0;
    }

    // Add element to the end of the list
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    // Linear Search Implementation (Member 1 Assignment)
    public T linearSearch(Predicate<T> condition) {
        Node<T> current = head;
        while (current != null) {
            if (condition.test(current.getData())) {
                return current.getData(); // Found
            }
            current = current.getNext();
        }
        return null; // Not found
    }

    // NEW: Remove a specific item from the list
    public boolean remove(T data) {
        if (head == null) return false;

        // Case 1: Removing head node
        if ((data == null && head.getData() == null) || (data != null && data.equals(head.getData()))) {
            head = head.getNext();
            size--;
            return true;
        }

        // Case 2: Removing middle or tail node
        Node<T> current = head;
        while (current.getNext() != null) {
            T nextData = current.getNext().getData();
            if ((data == null && nextData == null) || (data != null && data.equals(nextData))) {
                current.setNext(current.getNext().getNext());
                size--;
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    // NEW: Check if list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // NEW: Allows for-each loops (e.g., for (Entry entry : bucketList))
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                T data = current.getData();
                current = current.getNext();
                return data;
            }
        };
    }

    // Display all items in the linked list
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node<T> current = head;
        while (current != null) {
            System.out.println(" -> " + current.getData());
            current = current.getNext();
        }
    }

    public int getSize() {
        return size;
    }
}