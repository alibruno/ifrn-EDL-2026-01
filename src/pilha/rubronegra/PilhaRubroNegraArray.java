package pilha.rubronegra;

import java.util.Arrays;

public class PilhaRubroNegraArray implements PilhaRubroNegra {

    //Atributos da classe
    private Object[] data;
    private int redIndex;
    private int blackIndex;
    private int redSize;
    private int blackSize;
    private int capacity;

    //Construtor
    public PilhaRubroNegraArray(int capacity) {

        // Se a pilha não pode ter uma capacidade menor que 0
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
    // Método para adicionar um objeto na pilha vermelha
    public void pushRed(Object o) {

        // Verifica se a pilha está cheia
        // Se estiver aumenta a capacidade do array
        if (redSize + blackSize == capacity) {
            increaseCapacity();
        }

        //Adiciona o objeto na pilha vermelha
        data[++redIndex] = o;
        redSize++;
    }

    @Override
    // Método para adiconar um objeto na pilha preta
    public void pushBlack(Object o) {

        // Verifica se a pilha está cheia
        // Se estiver cheia aumenta sua capacidade
        if (redSize + blackSize == capacity) {
            increaseCapacity();
        }

        // Adiciona um objeto a pilha preta
        /*A pilha preta tem adição de objetos da esqueda para a direita
        Por isso a adicição é feita decrementando o índice do array */
        data[--blackIndex] = o;
        blackSize++;
    }

    @Override
    // Método para remoção de um objeto da pilha vermelha
    // A remoção ocorre no topo da pilha
    // Esse método pode gerar uma excessão, visto que não é possível remover elementos de uma pilha vazia
    public Object popRed() throws PilhaVaziaExcecao {
        if (isEmptyRed()) {
            throw new PilhaVaziaExcecao("Red Stack is empty");
        }
        // verifica se o tamanho da pilha chegou em 1/3 do seu total
        if (((redSize - 1) + blackSize) * 3 <= capacity) {
            reduceCapacity();
        }
        redSize--;
        return data[redIndex--];
    }

    @Override
    // Método para a remoção de um objeto da pilha preta
    // A remoção ocorre no topo da pilha (da esqueda para a direita)
    // Esse método pode gerar uma excessão, visto que não é possível remover elementos de uma pilha vazia
    public Object popBlack() throws PilhaVaziaExcecao {

        if (isEmptyBlack()) {
            throw new PilhaVaziaExcecao("Black Stack is empty");
        }

        // verifica se o tamanho da pilha chegou em 1/3 do seu total
        if ((redSize + (blackSize - 1)) * 3 <= capacity) {
            reduceCapacity();
        }
        blackSize--;
        return data[blackIndex++];
    }

    @Override
    // Mostra o elemento no topo da pilha VERMELHA
    // Esse método pode gerar uma excessão caso não haja elementos na pilha
    public Object topRed() throws PilhaVaziaExcecao {
        if (isEmptyRed()) {
            throw new PilhaVaziaExcecao("Red Stack is empty");
        }
        return data[redIndex];
    }

    @Override
    // Mostra o elemento no topo da pilha PRETA
    // Esse método pode gerar uma excessão caso não haja elementos na pilha
    public Object topBlack() throws PilhaVaziaExcecao {
        if (isEmptyBlack()) {
            throw new PilhaVaziaExcecao("Black Stack is empty");
        }
        return data[blackIndex];
    }

    @Override
    // Retorna o tamanho completo da pilha
    public int sizeAll() {
        return redSize + blackSize;
    }

    @Override
    // Retorna o tamanho da pilha vermelha
    public int sizeRed() {
        return redSize;
    }

    @Override
    // Retorna o tamanho da pilha preta
    public int sizeBlack() {
        return blackSize;
    }

    @Override
    // Verifica se o array completo está vazio
    public boolean isEmptyAll() {
        return redSize == 0 && blackSize == 0;
    }

    @Override
    // Verifica se a pilha VERMELHA está vazia
    public boolean isEmptyRed() {
        return sizeRed() == 0;
    }

    @Override
    // Verifica se a pilha PRETA está vazia
    public boolean isEmptyBlack() {
        return sizeBlack() == 0;
    }

    // Método que aumente a capacidade do array
    // Usa a estratégia de crescimento de DUPLICAÇÃO
    private void increaseCapacity() {
        Object[] new_data = new Object[capacity *= 2];
        this.data = copyRedAndBlackStacksElementsNewArray(this.data, new_data);
    }

    // Método de diminui a capacidade caso o tamanho de ambas as pilhas somadas sejam menou ou igual a 1/3
    private void reduceCapacity() {
        Object[] new_data = new Object[capacity /= 2];
        this.data = copyRedAndBlackStacksElementsNewArray(this.data, new_data);
    }
    // Método auxiliar para o increaseCapacity e o reduceCapacity
    // Cria um novo array e copia os valores do array antigo
    // Retorna o novo array com ca capacidade modificada e com os antigos elementos posicionados nos seus lugares
    private Object[] copyRedAndBlackStacksElementsNewArray(Object[] data, Object[] new_data) {
        // Copy elements from the red stack
        for (int i = 0; i < redSize; i++) {
            new_data[i] = data[i];
        }
        // Copy elements from the black stack
        int auxIndex = capacity - blackSize;
        int oldBlackIndex = blackIndex;
        for (int i = 0; i < blackSize; i++) {
            new_data[auxIndex++] = data[oldBlackIndex++];
        }
        blackIndex = capacity - blackSize;
        return new_data;
    }

    @Override
    public String toString() {
        return "PilhaRubroNegraArray{" +
                "data=" + Arrays.toString(data) +
                '}';
    }
}
