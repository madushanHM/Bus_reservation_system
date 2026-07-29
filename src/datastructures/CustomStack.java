package datastructures;

import java.util.function.Predicate;

public class CustomStack<T> {
    private Node<T> top;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public CustomStack() {
        this.top = null;
        this.size = 0;
    }

    public void push(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("[Stack] Stack is empty!");
            return null;
        }
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    public T find(Predicate<T> condition) {
        Node<T> current = top;
        while (current != null) {
            if (condition.test(current.data)) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    public T peek() {
        return isEmpty() ? null : top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int getSize() {
        return size;
    }

    public void displayStack() {
        if (isEmpty()) {
            System.out.println("[Stack] Stack is empty.");
            return;
        }
        Node<T> current = top;
        int index = 1;
        while (current != null) {
            System.out.println(index + ". " + current.data);
            current = current.next;
            index++;
        }
    }
}