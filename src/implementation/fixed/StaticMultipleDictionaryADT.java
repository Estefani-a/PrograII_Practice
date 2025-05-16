package implementation.fixed;

import tda.MultipleDictionaryADT;
import tda.SetADT;

public class StaticMultipleDictionaryADT implements MultipleDictionaryADT {
    private final int MAX = 100;
    private int[] keys;
    private int[][] values;
    private int[] sizes;
    private int size;

    public StaticMultipleDictionaryADT() {
        keys = new int[MAX];
        values = new int[MAX][MAX];
        sizes = new int[MAX];
        size = 0;
    }

    private int indexOf(int key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key) return i;
        }
        return -1;
    }

    @Override
    public void add(int key, int value) {
        int idx = indexOf(key);
        if (idx == -1) {
            keys[size] = key;
            values[size][0] = value;
            sizes[size] = 1;
            size++;
        } else {
            for (int i = 0; i < sizes[idx]; i++) {
                if (values[idx][i] == value) return; // evitar duplicado
            }
            values[idx][sizes[idx]] = value;
            sizes[idx]++;
        }
    }

    @Override
    public void remove(int key) {
        int idx = indexOf(key);
        if (idx != -1) {
            for (int i = idx; i < size - 1; i++) {
                keys[i] = keys[i + 1];
                sizes[i] = sizes[i + 1];
                for (int j = 0; j < sizes[i]; j++) {
                    values[i][j] = values[i + 1][j];
                }
            }
            size--;
        }
    }

    @Override
    public int[] get(int key) {
        int idx = indexOf(key);
        if (idx != -1) {
            int[] result = new int[sizes[idx]];
            for (int i = 0; i < sizes[idx]; i++) {
                result[i] = values[idx][i];
            }
            return result;
        }
        return new int[0]; // vacío si no existe
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

    @Override
    public void remove(int key, int value) {
        int idx = indexOf(key);
        if (idx != -1) {
            int pos = -1;
            for (int i = 0; i < sizes[idx]; i++) {
                if (values[idx][i] == value) {
                    pos = i;
                    break;
                }
            }
            if (pos != -1) {
                for (int i = pos; i < sizes[idx] - 1; i++) {
                    values[idx][i] = values[idx][i + 1];
                }
                sizes[idx]--;
                if (sizes[idx] == 0) {
                    remove(key);
                }
            }
        }
    }
}
