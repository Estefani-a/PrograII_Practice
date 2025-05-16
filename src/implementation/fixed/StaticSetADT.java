package implementation.fixed;

import tda.SetADT;

public class StaticSetADT implements SetADT {
    private int[] set;
    private int size;
    private final int CAPACITY = 100;

    public StaticSetADT() {
        set = new int[CAPACITY];
        size = 0;
    }

    @Override
    public boolean exist(int value) {
        for (int i = 0; i < size; i++) {
            if (set[i] == value) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int choose() {
        if (isEmpty()) {
            return -1; // Valor especial para indicar vacío
        }
        int randomIndex = (int) (Math.random() * size);
        return set[randomIndex];
    }

    @Override
    public void add(int value) {
        if (size < CAPACITY && !exist(value)) {
            set[size] = value;
            size++;
        }
    }

    @Override
    public void remove(int element) {
        for (int i = 0; i < size; i++) {
            if (set[i] == element) {
                // Mover los elementos a la izquierda para cubrir el hueco
                for (int j = i; j < size - 1; j++) {
                    set[j] = set[j + 1];
                }
                size--;
                break;
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

}
