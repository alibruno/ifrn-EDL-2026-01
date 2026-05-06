package vetor;

import java.util.Arrays;

public class VectorArray implements Vector {
    private Object[] elements;
    private int head, tail, capacity;
    private final int increment;

    public VectorArray(int capacity, int increment) {
        this.elements = new Object[capacity];
        this.head = 0;
        this.tail = 0;
        this.capacity = capacity;
        this.increment = increment;
    }

    private int nextIndex(int currentIndex) {
        return (currentIndex + 1) % capacity;
    }

    private int previousIndex(int currentIndex) {
        return (currentIndex - 1 + capacity) % capacity;
    }

    private int physicalIndex(int r) {
        return (head + r) % capacity;
    }

    @Override
    public void insertAtRank(int r, Object o) {
        if (r < 0 || r > size()) {
            throw new ArrayIndexOutOfBoundsException(r);
        }
        if (size() == capacity - 1) {
            grow();
        }
        // if() e else if() -> O(1); else -> O(n)
        if (r == 0) {
            head = previousIndex(head);
            elements[head] = o;
        } else if (r == size()) {
            elements[tail] = o;
            tail = nextIndex(tail);
        } else {
            copyAndInsertAt(r, o);
        }
    }

    @Override
    public Object replaceAtRank(int r, Object o) {
        if (r < 0 || r >= size()) {
            throw new ArrayIndexOutOfBoundsException(r);
        }
        int index = physicalIndex(r);
        Object replaced = elements[index];
        elements[index] = o;
        return replaced;
    }

    @Override
    public Object removeAtRank(int r) {
        if (isEmpty()) {
            throw new EmptyVectorException("Vector is empty");
        }
        if (r < 0 || r >= size()) {
            throw new ArrayIndexOutOfBoundsException(r);
        }
        Object removed;
        // if() e else if() -> O(1); else -> O(n)
        if (r == 0) {
            removed = elements[head];
            head = nextIndex(head);
        } else if (r == size() - 1) {
            tail = previousIndex(tail);
            removed = elements[tail];
        } else {
            removed = elements[physicalIndex(r)];
            copyAndRemoveAt(r);
        }
        return removed;
    }

    @Override
    public Object elemAtRank(int r) {
        if (r < 0 || r >= size()) {
            throw new ArrayIndexOutOfBoundsException(r);
        }
        int index = physicalIndex(r);
        return elements[index];
    }

    @Override
    public int size() {
        return (capacity - head + tail) % capacity;
    }

    @Override
    public boolean isEmpty() {
        return tail == head;
    }

    private void grow() {
        int newCapacity = increment == 0 ? capacity * 2 : capacity + increment;
        Object[] newArray = new Object[newCapacity];
        int tempHead = head;

        for (int i = 0; i < size(); i++) {
            newArray[i] = elements[tempHead];
            tempHead = nextIndex(tempHead);
        }

        tail = size(); // definir o novo final
        head = 0; // definir o novo inicio
        capacity = newCapacity;
        elements = newArray;
    }

    private void copyAndInsertAt(int r, Object o) {
        Object[] newArray = new Object[capacity];
        int tempHead = head;

        for (int i = 0; i < r; i++) {
            newArray[i] = elements[tempHead];
            tempHead = nextIndex(tempHead);
        }

        newArray[r] = o;

        for (int i = r; i < size(); i++) {
            newArray[i + 1] = elements[tempHead];
            tempHead = nextIndex(tempHead);
        }

        tail = size() + 1; // definir o novo final
        head = 0; // definir o novo inicio
        elements = newArray;
    }

    private void copyAndRemoveAt(int r) {
        Object[] newArray = new Object[capacity];
        int tempHead = head;

        for (int i = 0; i < r; i++) {
            newArray[i] = elements[tempHead];
            tempHead = nextIndex(tempHead);
        }

        tempHead = nextIndex(tempHead);

        for (int i = r; i < size() - 1; i++) {
            newArray[i] = elements[tempHead];
            tempHead = nextIndex(tempHead);
        }

        tail = size() - 1; // definir o novo final
        head = 0; // definir o novo inicio
        elements = newArray;
    }

    @Override
    public String toString() {
        return "VectorArray{" +
                "elements=" + Arrays.toString(elements) +
                ", head=" + elemAtRank(0) +
                ", tail=" + elemAtRank(size() - 1) +
                ", size=" + size() +
                '}';
    }
}
