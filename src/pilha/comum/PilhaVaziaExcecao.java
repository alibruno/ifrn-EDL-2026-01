package pilha.comum;

public class PilhaVaziaExcecao extends RuntimeException {
    public PilhaVaziaExcecao(String err) {
        super(err);
    }
}