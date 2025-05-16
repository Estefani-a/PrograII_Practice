package implementation.dynamic;

import tda.StackADT;

import java.util.ArrayList;

public class DynamicStackADT implements StackADT {
    private ArrayList<Integer> stack;

    public DynamicStackADT() {
        stack = new ArrayList<>();
    }

    @Override
    public int getElement() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila está vacía.");
        }
        return stack.get(stack.size() - 1);
    }

    @Override
    public void add(int value) {
        stack.add(value);
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila está vacía.");
        }
        stack.remove(stack.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
