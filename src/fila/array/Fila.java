package fila.array;

public interface Fila {
    void enqueue(Object o);

    Object dequeue();

    Object first();

    int size();

    boolean isEmpty();
}
