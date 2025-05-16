package implementation.fixed;

import tda.StackADT;

public class StaticStackADT implements StackADT {
    private int[] stack;
    private int top;
    private final int capacity;

    //constructor
    public StaticStackADT(int capacity) {
        this.capacity = capacity;
        this.stack = new int[capacity];
        this.top = -1; // Pila vacía
    }

    @Override
    public int getElement() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila está vacia.");
        }
        return stack[top];
    }

    @Override
    public void add(int value) {
        if (top >= capacity - 1) {
            throw new StackOverflowError("La pila está llena.");
        }
        stack[++top] = value;
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila está vacía.");
        }
        top--;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }
}
