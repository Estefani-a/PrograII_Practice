package implementation.dynamic;

import tda.PriorityQueueADT;

import java.util.ArrayList;

public class DynamicPriorityQueueADT implements PriorityQueueADT {
    private ArrayList<Integer> elements;
    private ArrayList<Integer> priorities;

    public DynamicPriorityQueueADT() {
        elements = new ArrayList<>();
        priorities = new ArrayList<>();
    }

    @Override
    public int getElement() {
        if (isEmpty()) return -1;
        return elements.get(0);
    }

    @Override
    public int getPriority() {
        if (isEmpty()) return -1;
        return priorities.get(0);
    }

    @Override
    public void add(int value, int priority) {
        int i = 0;
        while (i < priorities.size() && priorities.get(i) <= priority) {
            i++;
        }
        elements.add(i, value);
        priorities.add(i, priority);
    }

    @Override
    public void remove() {
        if (!isEmpty()) {
            elements.remove(0);
            priorities.remove(0);
        }
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }
}
