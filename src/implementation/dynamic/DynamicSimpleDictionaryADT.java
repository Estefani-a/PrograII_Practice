package implementation.dynamic;

import tda.SetADT;
import tda.SimpleDictionaryADT;

public class DynamicSimpleDictionaryADT implements SimpleDictionaryADT {
    private class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node head;

    public DynamicSimpleDictionaryADT() {
        head = null;
    }

    @Override
    public void add(int key, int value) {
        Node current = head;
        while (current != null) {
            if (current.key == key) {
                current.value = value;
                return;
            }
            current = current.next;
        }
        Node newNode = new Node(key, value);
        newNode.next = head;
        head = newNode;
    }

    @Override
    public void remove(int key) {
        Node current = head;
        Node prev = null;
        while (current != null) {
            if (current.key == key) {
                if (prev == null) {
                    head = current.next;
                } else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    @Override
    public int get(int key) {
        Node current = head;
        while (current != null) {
            if (current.key == key) return current.value;
            current = current.next;
        }
        return -1;
    }

    @Override
    public SetADT getKeys() {
        DynamicSetADT result = new DynamicSetADT();
        Node current = head;
        while (current != null) {
            result.add(current.key);
            current = current.next;
        }
        return result;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }
}
