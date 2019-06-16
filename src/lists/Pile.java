package lists;
import java.io.Serializable;
import lists.*;

public class Pile<T extends Comparable<T>> implements PileTAD<T>, Serializable {
	private ListTAD<T> lst = new ListDoubleLinked<T>();
	
	public void push(T dado)
	{
		lst.add(0, dado);
	}
	
	public T pop()
	{
		if (!this.isEmpty()) return lst.remove(0);
		else return null;
	}
	
	public T top()
	{
		return lst.get(0);
	}
	
	public boolean isEmpty()
	{
		return lst.isEmpty();
	}
	
	public int size()
	{
		return lst.size();
	}

	public String toString() {
		return lst.toString();
	}
}
