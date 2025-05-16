package implementation.dynamic;

import tda.QueueADT;

import java.util.ArrayList;

public class DynamicQueueADT implements QueueADT {
    private ArrayList<Integer> queue;

    public DynamicQueueADT() {
        queue = new ArrayList<>();
    }

    @Override
    public int getElement() {
        if (isEmpty()) {
            return -1; // Indicador de que está vacía (puede ser 0 u otro valor según el contexto)
        }
        return queue.get(0); // Primer elemento agregado
    }

    @Override
    public void add(int value) {
        queue.add(value); // Agrega al final (FIFO)
    }

    @Override
    public void remove() {
        if (!isEmpty()) {
            queue.remove(0); // Elimina el primero
        }
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
