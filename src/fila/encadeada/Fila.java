package fila.encadeada;

public interface Fila {
    void enqueue(Object o);

    Object dequeue();

    Object first();

    int size();

    boolean isEmpty();
}