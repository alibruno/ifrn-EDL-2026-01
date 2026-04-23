package pilha.rubronegra;

import pilha.PilhaVaziaExcecao;

public interface PilhaRubroNegra {
    int sizeAll();

    int sizeRed();

    int sizeBlack();

    boolean isEmptyAll();

    boolean isEmptyRed();

    boolean isEmptyBlack();

    Object topRed() throws PilhaVaziaExcecao;

    Object topBlack() throws PilhaVaziaExcecao;

    void pushRed(Object o);

    void pushBlack(Object o);

    Object popRed() throws PilhaVaziaExcecao;

    Object popBlack() throws PilhaVaziaExcecao;
}
