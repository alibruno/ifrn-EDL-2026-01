package fila.array;

public class FilaArray implements Fila {
    private Object[] elements;
    private int head, tail, capacity;
    private final int increment;

    public FilaArray(int capacity, int increment) {
        this.elements = new Object[capacity];
        this.head = 0;
        this.tail = 0;
        this.capacity = capacity; //Tamanho
        this.increment = increment;
    }

    public void enqueue(Object o) {
        if (size() == capacity - 1) { // encheu coleguinha
            int newCapacity = increment == 0 ? capacity * 2 : capacity + increment;
            Object[] newArray = new Object[newCapacity];
            int tempHead = head;

            for (int i = 0; i < size(); i++) {
                newArray[i] = elements[tempHead];
                tempHead = (tempHead + 1) % capacity;
            }

            tail = size(); // definir o novo final
            head = 0; // definir o novo inicio
            capacity = newCapacity;
            elements = newArray;
        }
        elements[tail] = o;
        tail = (tail + 1) % capacity;
    }


    public Object dequeue() {
        if (isEmpty()) {
            throw new FilaVaziaException("Queue is empty");
        }
        Object temp = elements[head];
        head = (head + 1) % capacity;
        return temp;
    }

    @Override
    public Object first() {
        if (isEmpty()) {
            throw new FilaVaziaException("Queue is empty");
        }
        return elements[head];
    }


    public int size() {
        return (capacity - head + tail) % capacity;
    }

    public boolean isEmpty() {
        return tail == head;
    }
}