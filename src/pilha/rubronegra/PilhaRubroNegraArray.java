package pilha.rubronegra;

import java.util.Arrays;

public class PilhaRubroNegraArray implements PilhaRubroNegra {
    private Object[] data;
    private int redIndex;
    private int blackIndex;
    private int capacity;

    public PilhaRubroNegraArray(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity must be greater than 0");
        }
        this.data = new Object[capacity];
        this.redIndex = -1;
        this.blackIndex = capacity;
        this.capacity = capacity;
    }

    @Override
    public void pushRed(Object o) {
        redIndex++;
        if ((redIndex + (capacity-blackIndex)) == capacity) {
            increaseCapacity();
        }
        data[redIndex] = o;
    }

    @Override
    public void pushBlack(Object o) {
        blackIndex--;
        if (redIndex + (capacity-blackIndex) == capacity) {
            increaseCapacity();
        }
        data[blackIndex] = o;
    }

    @Override
    public Object popRed() throws PilhaVaziaExcecao {
        if (isEmptyRed()) {
            throw new PilhaVaziaExcecao("Red Stack is empty");
        }

        redIndex--;
        if ((sizeRed() + sizeBlack()) * 3 <= capacity) {
            reduceCapacity();
        }
        
        return data[redIndex+1];
    }

    @Override
    public Object popBlack() throws PilhaVaziaExcecao {
        if (isEmptyBlack()) {
            throw new PilhaVaziaExcecao("Black Stack is empty");
        }

        blackIndex++;
        if ((sizeRed() + sizeBlack()) * 3 <= capacity) {
            reduceCapacity();
        }
        
        return data[blackIndex-1];
    }

    @Override
    public Object topRed() throws PilhaVaziaExcecao {
        if (isEmptyRed()) {
            throw new PilhaVaziaExcecao("Red Stack is empty");
        }
        return data[redIndex];
    }

    @Override
    public Object topBlack() throws PilhaVaziaExcecao {
        if (isEmptyBlack()) {
            throw new PilhaVaziaExcecao("Black Stack is empty");
        }
        return data[blackIndex];
    }

    @Override
    public int sizeAll() {
        return sizeRed() + sizeBlack();
    }

    @Override
    public int sizeRed() {
        return redIndex + 1;
    }

    @Override
    public int sizeBlack() {
        return capacity-blackIndex;
    }

    @Override
    public boolean isEmptyAll() {
        return (sizeRed() == 0 && sizeBlack() == 0);
    }

    @Override
    public boolean isEmptyRed() {
        return sizeRed() == 0;
    }

    @Override
    public boolean isEmptyBlack() {
        return sizeBlack() == 0;
    }

    private void increaseCapacity() {
        Object[] new_data = new Object[capacity *= 2];
        this.data = copyRedAndBlackStacksElementsNewArray(this.data, new_data);
    }

    private void reduceCapacity() {
        Object[] new_data = new Object[capacity /= 2];
        this.data = copyRedAndBlackStacksElementsNewArray(this.data, new_data);
    }

    private Object[] copyRedAndBlackStacksElementsNewArray(Object[] data, Object[] new_data) {
        // Copy elements from the red stack
        for (int i = 0; i < sizeRed(); i++) {
            new_data[i] = data[i];
        }
        // Copy elements from the black stack
        int auxIndex = capacity - sizeBlack();
        int oldBlackIndex = blackIndex;
        for (int i = 0; i < sizeBlack(); i++) {
            new_data[auxIndex++] = data[oldBlackIndex++];
        }
        blackIndex = capacity - sizeBlack();
        return new_data;
    }

    @Override
    public String toString() {
        return "PilhaRubroNegraArray{" +
                "data=" + Arrays.toString(data) +
                '}';
    }
}
