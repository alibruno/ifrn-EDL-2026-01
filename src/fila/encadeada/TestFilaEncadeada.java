package fila.encadeada;

public class TestFilaEncadeada {
    public static void main(String[] args) {
        System.out.println("==================== Teste enqueue() ====================");
        testEnqueue();
    }

    private static void testEnqueue() {
        Fila fila = new FilaEncadeada();
        System.out.println("Is Empty? " + fila.isEmpty());
        System.out.println("First? " + fila.first());
        System.out.println(fila);
        fila.enqueue(10);
        fila.enqueue(20);
        fila.enqueue(30);
        fila.enqueue(40);
        System.out.println(fila);
        System.out.println("Is Empty? " + fila.isEmpty());
        System.out.println("First? " + fila.first());
    }
}
