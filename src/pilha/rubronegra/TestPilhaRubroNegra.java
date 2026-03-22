package pilha.rubronegra;

public class TestPilhaRubroNegra {
    public static void main(String[] args) {
        System.out.println("Teste push()");
        testarPush();
        System.out.println("------------------------");
        System.out.println("Teste increaseCapacity()");
        testIncreaseCapacity();
    }

    private static void testarPush() {
        PilhaRubroNegra pilha = new PilhaRubroNegraArray(10);
        for (int i = 0; i < 3; i++) {
            pilha.pushRed(i);
        }
        for (int i = 0; i < 3; i++) {
            pilha.pushBlack(i);
        }
        System.out.println(pilha);
    }

    private static void testIncreaseCapacity() {
        System.out.println("Capacidade = 3, Inserções = 4");
        PilhaRubroNegra pilha = new PilhaRubroNegraArray(3);
        pilha.pushRed('r');
        pilha.pushRed('r');
        pilha.pushBlack('b');
        pilha.pushBlack('b');
        System.out.println(pilha);
        System.out.println("Capacidade = 10, Inserções = 15");
        pilha = new PilhaRubroNegraArray(10);
        for (int i = 0; i < 5; i++) {
            pilha.pushRed('r');
        }
        for (int i = 9; i > 4 ; i--) {
            pilha.pushBlack('b');
        }
        System.out.println(pilha);

        for (int i = 0; i < 2; i++) {
            pilha.pushRed('R');
        }
        for (int i = 0; i < 3; i++) {
            pilha.pushBlack('B');
        }
        System.out.println(pilha);
    }
}
