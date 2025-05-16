package implementation.fixed;

import tda.SetADT;
import tda.SimpleDictionaryADT;

public class StaticSimpleDictionaryADT implements SimpleDictionaryADT {
    private final int CAPACITY = 100;
    private int[] keys;
    private int[] values;
    private int size;

    public StaticSimpleDictionaryADT() {
        keys = new int[CAPACITY];
        values = new int[CAPACITY];
        size = 0;
    }

    @Override
    public void add(int key, int value) {
        int pos = findKey(key);
        if (pos != -1) {
            values[pos] = value; // pisa valor si ya existe
        } else if (size < CAPACITY) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    @Override
    public void remove(int key) {
        int pos = findKey(key);
        if (pos != -1) {
            for (int i = pos; i < size - 1; i++) {
                keys[i] = keys[i + 1];
                values[i] = values[i + 1];
            }
            size--;
        }
    }

    @Override
    public int get(int key) {
        int pos = findKey(key);
        return (pos != -1) ? values[pos] : -1;
    }

    @Override
    public SetADT getKeys() {
        StaticSetADT result = new StaticSetADT();
        for (int i = 0; i < size; i++) {
            result.add(keys[i]);
        }
        return result;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private int findKey(int key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key) return i;
        }
        return -1;
    }
}
