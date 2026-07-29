package datastructures;

import java.util.function.Predicate;

public class CustomQueue<T> {
    private Node<T> front;
    private Node<T> rear;
    private int size;
    private final int capacity;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public CustomQueue(int capacity) {
        this.front = null;
        this.rear = null;
        this.size = 0;
        this.capacity = capacity;
    }

    public CustomQueue() {
        this(Integer.MAX_VALUE);
    }

    public boolean enqueue(T item) {
        if (size >= capacity) {
            System.out.println("[Queue] System full! Cannot add item.");
            return false;
        }
        Node<T> newNode = new Node<>(item);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        return true;
    }

    public T dequeue() {
        if (isEmpty()) {
            System.out.println("[Queue] Queue is empty!");
            return null;
        }
        T data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return data;
    }

    // Flexible removal using a functional predicate (e.g., matching IDs)
    public boolean removeIf(Predicate<T> condition) {
        if (isEmpty()) return false;

        if (condition.test(front.data)) {
            dequeue();
            return true;
        }

        Node<T> current = front;
        while (current.next != null) {
            if (condition.test(current.next.data)) {
                if (current.next == rear) {
                    rear = current;
                }
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public T peek() {
        return isEmpty() ? null : front.data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int getSize() {
        return size;
    }

    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("[Queue] Queue is empty.");
            return;
        }
        Node<T> current = front;
        int position = 1;
        while (current != null) {
            System.out.println(position + ". " + current.data);
            current = current.next;
            position++;
        }
    }
}