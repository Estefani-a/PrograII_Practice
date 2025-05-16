package implementation.dynamic;

import tda.LinkedListADT;

//implementacion dinamica con nodos
public class DynamicLinkedListADT implements LinkedListADT {
    private class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private int size;

    public DynamicLinkedListADT() {
        head = null;
        size = 0;
    }

    @Override
    public void add(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) current = current.next;
            current.next = newNode;
        }
        size++;
    }

    @Override
    public void insert(int index, int value) {
        if (index >= 0 && index <= size) {
            Node newNode = new Node(value);
            if (index == 0) {
                newNode.next = head;
                head = newNode;
            } else {
                Node current = head;
                for (int i = 0; i < index - 1; i++) current = current.next;
                newNode.next = current.next;
                current.next = newNode;
            }
            size++;
        }
    }

    @Override
    public void remove(int index) {
        if (index >= 0 && index < size) {
            if (index == 0) {
                head = head.next;
            } else {
                Node current = head;
                for (int i = 0; i < index - 1; i++) current = current.next;
                current.next = current.next.next;
            }
            size--;
        }
    }

    @Override
    public int get(int index) {
        if (index >= 0 && index < size) {
            Node current = head;
            for (int i = 0; i < index; i++) current = current.next;
            return current.value;
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
