package implementation.dynamic;

import tda.MultipleDictionaryADT;
import tda.SetADT;

public class DynamicMultipleDictionaryADT implements MultipleDictionaryADT {
    private Node head;

    private class Node {
        int key;
        ValueNode values;
        Node next;
    }

    private class ValueNode {
        int value;
        ValueNode next;
    }

    @Override
    public void add(int key, int value) {
        Node current = head;
        while (current != null) {
            if (current.key == key) {
                ValueNode v = current.values;
                while (v != null) {
                    if (v.value == value) return; // evitar duplicado
                    v = v.next;
                }
                ValueNode newValue = new ValueNode();
                newValue.value = value;
                newValue.next = current.values;
                current.values = newValue;
                return;
            }
            current = current.next;
        }

        // nuevo key
        Node newNode = new Node();
        newNode.key = key;
        newNode.next = head;

        ValueNode newValue = new ValueNode();
        newValue.value = value;

        newNode.values = newValue;
        head = newNode;
    }

    @Override
    public void remove(int key) {
        Node current = head, prev = null;
        while (current != null) {
            if (current.key == key) {
                if (prev == null) head = current.next;
                else prev.next = current.next;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    @Override
    public int[] get(int key) {
        Node current = head;
        while (current != null) {
            if (current.key == key) {
                int count = 0;
                ValueNode v = current.values;
                while (v != null) {
                    count++;
                    v = v.next;
                }
                int[] result = new int[count];
                v = current.values;
                for (int i = 0; i < count; i++) {
                    result[i] = v.value;
                    v = v.next;
                }
                return result;
            }
            current = current.next;
        }
        return new int[0];
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

    @Override
    public void remove(int key, int value) {
        Node current = head;
        while (current != null) {
            if (current.key == key) {
                ValueNode v = current.values, prev = null;
                while (v != null) {
                    if (v.value == value) {
                        if (prev == null) current.values = v.next;
                        else prev.next = v.next;
                        break;
                    }
                    prev = v;
                    v = v.next;
                }

                if (current.values == null) {
                    remove(key);
                }
                return;
            }
            current = current.next;
        }
    }
}
