package pilha.rubronegra;

public interface PilhaRubroNegra {
    int size();

    boolean isEmpty();

    Object topRed() throws PilhaVaziaExcecao;

    Object topBlack() throws PilhaVaziaExcecao;

    void pushRed(Object o);

    void pushBlack(Object o);

    Object popRed() throws PilhaVaziaExcecao;

    Object popBlack() throws PilhaVaziaExcecao;
}
