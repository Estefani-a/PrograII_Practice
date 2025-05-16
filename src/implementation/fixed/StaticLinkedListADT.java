package implementation.fixed;

import tda.LinkedListADT;

public class StaticLinkedListADT implements LinkedListADT {
    private final int CAPACITY = 100;
    private int[] list;
    private int size;

    public StaticLinkedListADT() {
        list = new int[CAPACITY];
        size = 0;
    }

    @Override
    public void add(int value) {
        if (size < CAPACITY) {
            list[size++] = value;
        }
    }

    @Override
    public void insert(int index, int value) {
        if (index >= 0 && index <= size && size < CAPACITY) {
            for (int i = size; i > index; i--) {
                list[i] = list[i - 1];
            }
            list[index] = value;
            size++;
        }
    }

    @Override
    public void remove(int index) {
        if (index >= 0 && index < size) {
            for (int i = index; i < size - 1; i++) {
                list[i] = list[i + 1];
            }
            size--;
        }
    }

    @Override
    public int get(int index) {
        if (index >= 0 && index < size) {
            return list[index];
        }
        return -1; // Valor inválido para indicar error sin excepciones
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
