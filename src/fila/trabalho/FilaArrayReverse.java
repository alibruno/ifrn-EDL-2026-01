package fila.trabalho;

public class FilaArrayReverse implements Fila {
    private Object[] elements;
    private int head, tail, capacity;
    private final int increment;
    private boolean isReversed;

    public FilaArrayReverse(int capacity, int increment) {
        this.elements = new Object[capacity];
        this.head = 0;
        this.tail = 0;
        this.capacity = capacity;
        this.increment = increment;
        this.isReversed = false;
    }

    public void enqueue(Object o) {
        if (size() == capacity - 1) {
            int newCapacity = increment == 0 ?
                    capacity * 2 :
                    capacity + increment;

            Object[] newArray = new Object[newCapacity];

            int tempHead = head;

            for (int tempTail = 0; tempTail < size(); tempTail++) {
                newArray[tempTail] = elements[tempHead];
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
