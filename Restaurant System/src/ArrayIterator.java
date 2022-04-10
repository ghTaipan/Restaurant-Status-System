import java.util.NoSuchElementException;

public class ArrayIterator<T> implements IteratorInterface<T> {
    Stack<T> stackIterator;
    public int count;
    private int current;
    private T[] items;
    public ArrayIterator(Stack collection) {
        this.stackIterator = collection;

    }

    public boolean hasNext() {
        return  (current < count);
    }
    public T next() {
        if (! hasNext( ))
            throw new NoSuchElementException();
        current++;
        return stackIterator.pop();
    }

    public void remove() {
    }
}


