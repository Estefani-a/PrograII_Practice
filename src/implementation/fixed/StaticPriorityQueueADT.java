package implementation.fixed;

import tda.PriorityQueueADT;

public class StaticPriorityQueueADT implements PriorityQueueADT {
    private int[] elements;
    private int[] priorities;
    private int size;
    private final int CAPACITY = 100;

    public StaticPriorityQueueADT() {
        elements = new int[CAPACITY];
        priorities = new int[CAPACITY];
        size = 0;
    }

    @Override
    public int getElement() {
        if (isEmpty()) return -1;
        return elements[0];
    }

    @Override
    public int getPriority() {
        if (isEmpty()) return -1;
        return priorities[0];
    }

    @Override
    public void add(int value, int priority) {
        if (size >= CAPACITY) return;

        int i = size;
        while (i > 0 && priorities[i - 1] > priority) {
            elements[i] = elements[i - 1];
            priorities[i] = priorities[i - 1];
            i--;
        }
        elements[i] = value;
        priorities[i] = priority;
        size++;
    }

    @Override
    public void remove() {
        if (!isEmpty()) {
            for (int i = 0; i < size - 1; i++) {
                elements[i] = elements[i + 1];
                priorities[i] = priorities[i + 1];
            }
            size--;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
