package vetor;

public class VectorLinked implements Vector {
    // head e tail -> nós sentinelas
    private Node head;
    private Node tail;
    private int size;

    public VectorLinked() {
        this.head = new Node(null);
        this.tail = new Node(null);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.size = 0;
    }

    private static class Node {
        private Object element;
        private Node next;
        private Node prev;

        public Node(Object element) {
            this.element = element;
        }
    }

    // Busca baseando-se na proximidade dos extremos do começo e final
    private Node nodeAt(int r) {
        if (r < 0 || r >= size) {
            throw new IndexOutOfBoundsException("Index: " + r + ", Size: " + size);
        }
        Node current;
        if (r < size / 2) {
            current = head.next;
            for (int i = 0; i < r; i++) {
                current = current.next;
            }
        } else {
            current = tail.prev;
            for (int i = size - 1; i > r; i--) {
                current = current.prev;
            }
        }
        return current;
    }

    @Override
    public void insertAtRank(int r, Object o) {
        if (r < 0 || r > size) {
            throw new IndexOutOfBoundsException("Index: " + r + ", Size: " + size);
        }

        Node current;
        if (r == size) {
            current = tail; // Inserir no final -> antes do tail
        } else {
            current = nodeAt(r);
        }

        Node newNode = new Node(o);
        newNode.prev = current.prev;
        newNode.next = current;
        current.prev.next = newNode;
        current.prev = newNode;

        size++;
    }

    @Override
    public Object replaceAtRank(int r, Object o) {
        Node target = nodeAt(r);

        Object replaced = target.element;
        target.element = o;

        return replaced;
    }

    @Override
    public Object removeAtRank(int r) {
        if (isEmpty()) {
            throw new EmptyVectorException("Vector is empty");
        }
        Node target = nodeAt(r);
        Object removed = target.element;

        target.prev.next = target.next;
        target.next.prev = target.prev;
        size--;

        return removed;
    }

    @Override
    public Object elemAtRank(int r) {
        return nodeAt(r).element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public String toString() {
        return "VectorLinked{" +
                "Nodes=" + allNodes() +
                ", size=" + size +
                '}';
    }

    private String allNodes() {
        if (isEmpty()) return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node current = head.next;

        while (current != tail) {
            sb.append(current.element);
            if (current.next != tail) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}