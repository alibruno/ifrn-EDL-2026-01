package fila.encadeada;

import java.util.Deque;

public interface Fila {
    void enqueue(Object o);

    Object dequeue();

    Object first();

    int size();

    boolean isEmpty();
}