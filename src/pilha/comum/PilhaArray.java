package pilha.comum;

import java.util.Arrays;

public class PilhaArray implements Pilha {
    private Object[] data;
    private int index;
    private int capacity;
    private int increment;

    public PilhaArray(int capacity, int increment) {
        this.index = -1;
        this.capacity = capacity;
        this.increment = 0;
        if (increment > 0)
            this.increment = increment;
        data = new Object[capacity];
    }

    public void push(Object o) {
        if (index == capacity - 1) {
            increaseCapacity();
        }
        data[++index] = o;
    }

    public Object pop() throws PilhaVaziaExcecao {
        if (isEmpty())
            throw new PilhaVaziaExcecao("A Pilha está vazia");
        return data[index--];
    }

    public Object top() throws PilhaVaziaExcecao {
        if (isEmpty())
            throw new PilhaVaziaExcecao("A Pilha está vazia");
        return data[index];
    }

    public boolean isEmpty() {
        return index == -1;
    }

    public int size() {
        return index + 1;
    }

    private void increaseCapacity() {
        capacity = calculateNewCapacity();
        Object[] new_data = new Object[capacity];
        for (int i = 0; i < data.length; i++)
            new_data[i] = data[i];
        data = new_data;
    }

    private int calculateNewCapacity() {
        if (increment == 0)
            return capacity *= 2;
        else
            return capacity += increment;
    }

    @Override
    public String toString() {
        return "PilhaArray{" +
                "data=" + Arrays.toString(data) +
                '}';
    }
}
