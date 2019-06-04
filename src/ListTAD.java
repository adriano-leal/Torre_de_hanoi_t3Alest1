public interface ListTAD <E extends Comparable<E>> {
    public void add(E element);
    public void addFirst(E element);
    public E get(int pos);
    public void set(int index, E element);
}
