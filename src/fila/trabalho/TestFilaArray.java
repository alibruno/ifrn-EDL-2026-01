package fila.trabalho;

import fila.encadeada.Fila;
import fila.encadeada.FilaEncadeada;
import fila.encadeada.FilaVaziaException;

public class TestFilaArray {
    public static void main(String[] args) {
        System.out.println("==================== Teste enqueue() ====================");
        testEnqueue();
        System.out.println("==================== Teste dequeue() ====================");
        testDequeue();
    }

    private static void testEnqueue() {
        fila.encadeada.Fila fila = new FilaEncadeada();
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

    private static void testDequeue() {
        Fila fila = new FilaEncadeada();
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
