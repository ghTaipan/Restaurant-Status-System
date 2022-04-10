public interface QueueInterface<T>{
    void enqueue(T newEntry);
    T getFront();
    T dequeue();
    boolean isEmpty();
}
