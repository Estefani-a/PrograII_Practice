package implementation.fixed;

import tda.QueueADT;

public class StaticQueueADT implements QueueADT {
    int[] queue;
    int index;
    public StaticQueueADT() {
        queue = new int[100];
        index = 0;
    }
    @Override
    public int getElement() {
        return queue[index - 1];
    }

    @Override
    public void add(int value) {
        for (int i = index - 1; i >= 0; i--) {
            queue[i + 1] = queue[i];
        }
        queue[0] = value;
        index++;
    }


    @Override
    public void remove() {
        index--;
    }

    @Override
    public boolean isEmpty() {
        return index == 0;
    }
}
