package lists;
import java.util.*;

public interface ListTAD<E extends Comparable<E>> {
    public void add(E element);
    public void add(int index, E element);
    public E remove(int pos);
    public E remove(E element);
    public E get(int pos);
    public void set(int index, E element);
    public E search(E element);
    public boolean isEmpty();
    public int size();
    public int count(E element);
    public void clean();
    public Iterator<E> iterator();
    public void addFirst(E element);
    public void addLast(E element);
    public E removeFirst();
    public E removeLast();
    public E getFirst();
    public E getLast();
}