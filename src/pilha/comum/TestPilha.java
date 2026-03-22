package pilha.comum;

public class TestPilha {

    public static void main(String[] args) {
        Pilha pilhaArray = new PilhaArray(1, 0);

        System.out.println("Inserindo");
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
            pilhaArray.push(i);
        }
        System.out.println();
        System.out.println("Elementos atuais: " + pilhaArray);

        System.out.println();
        System.out.println("Retirando");
        for (int i = 0; i < 10; i++) {
            System.out.println("Indice: " + i + " - Elemento removido: " + pilhaArray.pop());
        }
    }
}
