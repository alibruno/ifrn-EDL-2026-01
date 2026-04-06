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
        }

        public Object getElement() {
            return element;
        }

        public void setElement(Object o) {
            element = o;
        }
    }


    @Override
    public void enqueue(Object o) {

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
}
