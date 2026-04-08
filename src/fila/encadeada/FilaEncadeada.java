package fila.encadeada;

public class FilaEncadeada implements Fila {
    private No head;
    private No tail;
    private int size;

    public FilaEncadeada() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // No só poderá ser acessado dentro dessa estrutura
    // No é estático pois não precisa de uma instância da fila para existir.
    private static class No {
        private Object element;
        private No next;

        public No(Object element) {
            this.element = element;
            this.next = null;
        }

        @Override
        public String toString() {
            return element.toString();
        }
    }


    @Override
    public void enqueue(Object o) {
        No no = new No(o);
        if (head == null) {
            head = no;
        } else {
            tail.next = no;
        }
        tail = no;
        size++;
    }

    @Override
    public Object dequeue() {
        return null;
    }

    @Override
    public Object first() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public String toString() {
        return "FilaEncadeada{" +
                "head=" + head +
                ", tail=" + tail +
                ", size=" + size +
                ", No{" + allNodeElements() + "}" +
                '}';
    }

    public String allNodeElements() {
        if (head == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        No no = head;
        while (no != null) {
            sb.append(no.element).append(',').append(' ');
            no = no.next;
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }
}
