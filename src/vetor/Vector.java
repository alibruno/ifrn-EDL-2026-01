package vetor;

public interface Vector {
    void insertAtRank(int r, Object o);

    Object replaceAtRank(int r, Object o);

    Object removeAtRank(int r);

    Object elemAtRank(int r);

    int size();

    boolean isEmpty();
}
