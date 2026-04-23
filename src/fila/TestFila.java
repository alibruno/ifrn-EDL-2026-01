package fila;

public class TestFila {
    public static void main(String[] args) {
        System.out.println("ARRAY");
        Fila filaArray = new FilaArray(10, 0);
        System.out.println("-------------------- Teste enqueue() --------------------");
        testEnqueue(filaArray);
        System.out.println("-------------------- Teste dequeue() --------------------");
        testDequeue(filaArray);

        System.out.println("==========================================================");

        System.out.println("ENCADEADA");
        Fila filaEncadeada = new FilaEncadeada();
        System.out.println("-------------------- Teste enqueue() --------------------");
        testEnqueue(filaEncadeada);
        System.out.println("-------------------- Teste dequeue() --------------------");
        testDequeue(filaEncadeada);
    }

    private static void testEnqueue(Fila fila) {
        System.out.println("Is Empty? " + fila.isEmpty());
        System.out.println(fila);
        fila.enqueue(10);
        fila.enqueue(20);
        fila.enqueue(30);
        fila.enqueue(40);
        System.out.println(fila);
        System.out.println("Is Empty? " + fila.isEmpty());
        System.out.println("First? " + fila.first());
    }

    private static void testDequeue(Fila fila) {
        fila.enqueue(10);
        fila.enqueue(20);
        fila.enqueue(30);
        System.out.println(fila);
        for (int i = 0; i < 3; i++) {
            System.out.println("Remoção " + fila.dequeue());
            System.out.println(fila);
        }
        try {
            fila.dequeue();
        } catch (FilaVaziaException e) {
            System.out.println(e.getMessage());
        }
    }
}
