package fila.trabalho;

public interface FilaReverse {
    void enqueue(Object o);

    Object dequeue();

    void reverse();

    Object first();

    int size();

    boolean isEmpty();
}