package implementation.dynamic;

import tda.SetADT;

import java.util.ArrayList;

public class DynamicSetADT implements SetADT {
    private ArrayList<Integer> set;

    public DynamicSetADT() {
        set = new ArrayList<>();
    }

    @Override
    public boolean exist(int value) {
        for (int i = 0; i < set.size(); i++) {
            if (set.get(i) == value) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int choose() {
        if (isEmpty()) {
            return -1; // Indicador de estructura vacía
        }
        int randomIndex = (int) (Math.random() * set.size());
        return set.get(randomIndex);
    }

    @Override
    public void add(int value) {
        if (!exist(value)) {
            set.add(value);
        }
    }

    @Override
    public void remove(int element) {
        for (int i = 0; i < set.size(); i++) {
            if (set.get(i) == element) {
                set.remove(i);
                break;
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return set.isEmpty();
    }
}
