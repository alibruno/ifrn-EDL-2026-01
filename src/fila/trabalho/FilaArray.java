package fila.trabalho;

public class FilaArray implements Fila {
    private Object[] elements;
    private int head;
    private int tail;
    private int capacity;
    private int increment;

    public FilaArray(int capacity, int increment) {
        this.elements = new Object[capacity];
        this.head = 0;
        this.tail = 0;
        this.capacity = capacity; //Tamanho
        this.increment = increment;
    }

    public void enqueue(Object o) {
        if (size() == capacity - 1) { // encheu coleguinha
            int newCapacity;
            if (increment == 0) {
                newCapacity = capacity * 2;
            } else {
                newCapacity = capacity + increment;
            }
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
        if (isEmpty())
            throw new FilaVaziaException("A Pilha está vazia");
        Object temp = elements[head];
        head = (head + 1) % capacity;
        return temp;
    }

    @Override
    public Object first() {
        return elements[head];
    }


    public int size() {
        return (capacity - head + tail) % capacity;
    }

    public boolean isEmpty() {
        return tail == head;
    }
}
