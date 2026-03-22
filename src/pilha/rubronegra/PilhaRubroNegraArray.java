package pilha.rubronegra;

import java.util.Arrays;

public class PilhaRubroNegraArray implements PilhaRubroNegra {
    private Object[] data;
    private int indexRed;
    private int indexBlack;
    private int size;
    private int capacity;

    public PilhaRubroNegraArray(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity must be greater than 0");
        }
        this.indexRed = -1;
        this.indexBlack = capacity;
        this.size = 0;
        this.capacity = capacity;
    }

    @Override
    public void pushRed(Object o) {
        if (size == capacity) {
            increaseCapacity();
        }
    }

    @Override
    public void pushBlack(Object o) {
        if (size == capacity) {
            increaseCapacity();
        }

    }

    @Override
    public Object popRed() throws PilhaVaziaExcecao {
        if (size * 3 <= capacity) {
            reduceCapacity();
        }
        return null;
    }

    @Override
    public Object popBlack() throws PilhaVaziaExcecao {
        if (size * 3 <= capacity) {
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
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    private void increaseCapacity() {
        Object[] new_data = new Object[capacity *= 2];
        for (int i = 0; i < data.length; i++)
            new_data[i] = data[i];
        data = new_data;
    }

    private void reduceCapacity() {
        Object[] new_data = new Object[capacity /= 2];
        for (int i = 0; i < data.length; i++)
            new_data[i] = data[i];
        data = new_data;
    }

    @Override
    public String toString() {
        return "PilhaRubroNegraArray{" +
                "data=" + Arrays.toString(data) +
                '}';
    }
}
