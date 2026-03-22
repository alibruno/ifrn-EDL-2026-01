package pilha.rubronegra;

public class TestPilhaRubroNegra {
    public static void main(String[] args) {
        System.out.println("Teste push()");
        testPush();
        System.out.println("------------------------");
        System.out.println("Teste increaseCapacity()");
        testIncreaseCapacity();
        System.out.println("------------------------");
        System.out.println("Teste top()");
        testTop();
    }

    private static void testPush() {
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
        for (int i = 5; i < 10; i++) {
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

    private static void testTop() {
        PilhaRubroNegra pilha = new PilhaRubroNegraArray(10);
        System.out.println(pilha);

        System.out.println("topRed() sem inserção");
        try {
            pilha.topRed();
        } catch (PilhaVaziaExcecao e) {
            System.out.println(e.getMessage());
        }

        System.out.println("topBlack() sem inserção");
        try {
            pilha.topBlack();
        } catch (PilhaVaziaExcecao e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Inserção somente na pilha red");
        for (int i = 0; i < 5; i++) {
            pilha.pushRed(i);
        }
        System.out.println(pilha);

        System.out.println("tentativa de topBlack()");
        try {
            pilha.topBlack();
        } catch (PilhaVaziaExcecao e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Inserção na pilha black");
        for (int i = 9; i > 4; i--) {
            pilha.pushBlack(i);
        }
        System.out.println(pilha);
        System.out.println("topRed = " + pilha.topRed() + " topBlack = " + pilha.topBlack());

        System.out.println("Mais inserções - increaseCapacity()");
        for (int i = 20; i < 22; i++) {
            pilha.pushRed(i);
        }
        for (int i = 30; i < 32; i++) {
            pilha.pushBlack(i);
        }
        System.out.println(pilha);
        System.out.println("topRed = " + pilha.topRed() + " topBlack = " + pilha.topBlack());
    }
}
