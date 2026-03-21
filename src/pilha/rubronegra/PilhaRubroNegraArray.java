package pilha.rubronegra;

import java.util.Arrays;

public class PilhaRubroNegraArray implements PilhaRubroNegra {
    private Object[] data;
    private int index;
    private int capacity;

    @Override
    public Object topRed() throws PilhaVaziaExcecao {
        return null;
    }

    @Override
    public Object topBlack() throws PilhaVaziaExcecao {
        return null;
    }

    @Override
    public void pushRed(Object o) {

    }

    @Override
    public void pushBlack(Object o) {

    }

    @Override
    public Object popRed() throws PilhaVaziaExcecao {
        return null;
    }

    @Override
    public Object popBlack() throws PilhaVaziaExcecao {
        return null;
    }

    public boolean isEmpty() {
        return index == -1;
    }

    public int size() {
        return index + 1;
    }

    private void increaseCapacity() {
        Object[] new_data = new Object[capacity *= 2];
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
