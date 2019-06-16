package lists;
import java.util.EmptyStackException;

public interface PileTAD<E extends Comparable<E>> {
  public int size();

  public boolean isEmpty();

  public E top() throws EmptyStackException;

  public void push(E element);

  public E pop() throws EmptyStackException;
}