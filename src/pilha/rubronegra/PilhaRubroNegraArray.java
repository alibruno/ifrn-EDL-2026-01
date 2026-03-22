package pilha.rubronegra;

import java.util.Arrays;

public class PilhaRubroNegraArray implements PilhaRubroNegra {
    private Object[] data;
    private int redIndex;
    private int blackIndex;
    private int redSize;
    private int blackSize;
    private int capacity;

    public PilhaRubroNegraArray(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity must be greater than 0");
        }
        this.data = new Object[capacity];
        this.redIndex = -1;
        this.blackIndex = capacity;
        this.redSize = 0;
        this.blackSize = 0;
        this.capacity = capacity;
    }

    @Override
    public void pushRed(Object o) {
        if (redSize + blackSize == capacity) {
            increaseCapacity();
        }
        data[++redIndex] = o;
        redSize++;
    }

    @Override
    public void pushBlack(Object o) {
        if (redSize + blackSize == capacity) {
            increaseCapacity();
        }
        data[--blackIndex] = o;
        blackSize++;
    }

    @Override
    public Object popRed() throws PilhaVaziaExcecao {
        if ((redSize + blackSize) * 3 <= capacity) {
            reduceCapacity();
        }
        return null;
    }

    @Override
    public Object popBlack() throws PilhaVaziaExcecao {
        if ((redSize + blackSize) * 3 <= capacity) {
            reduceCapacity();
        }
        return null;
    }

    @Override
    public Object topRed() throws PilhaVaziaExcecao {
        return null;
    }

    @Override
    public Object topBlack() throws PilhaVaziaExcecao {
        return null;
    }

    @Override
    public int size() {
        return redSize + blackSize;
    }

    @Override
    public boolean isEmpty() {
        return redSize == 0 && blackSize == 0;
    }

    private void increaseCapacity() {
        Object[] new_data = new Object[capacity *= 2];
        // Cópia da pilha vermelha
        for (int i = 0; i < redSize; i++) {
            new_data[i] = data[i];
        }
        // Cópia da pilha preta
        int auxIndex = capacity - blackSize;
        for (int i = 0; i < blackSize; i++) {
            new_data[auxIndex++] = data[blackIndex++];
        }
        blackIndex = capacity - blackSize;
        data = new_data;
    }

    private void reduceCapacity() {

    }

    @Override
    public String toString() {
        return "PilhaRubroNegraArray{" +
                "data=" + Arrays.toString(data) +
                '}';
    }
}
