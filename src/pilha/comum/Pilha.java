package pilha.comum;

public interface Pilha {
    int size();

    boolean isEmpty();

    Object top() throws PilhaVaziaExcecao;

    void push(Object o);

    Object pop() throws PilhaVaziaExcecao;
}
