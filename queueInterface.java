public interface queueInterface<T> {
    public void enqueue(T newEntry);
    // add new entry to the back of the queue

    public T dequeue();
    // remove entry from the front of the queue

    public T getFront();
    // return but dont remove the entry from the front of the queue

    public boolean isEmpty();
    // retunr true if empty or false if not

    public void clear();
    // clears all entries





}
