public interface BSTInterface<T>{

    boolean isEmpty();

    void add(T anEntry);

    void delete(T x);

    int countNodes();

    boolean search(T value);

    void DescendingInOrder();

    void AscendingInOrder();

    void preorder();

    void postorder();

}
