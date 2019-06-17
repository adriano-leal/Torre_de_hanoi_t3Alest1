package lists;
import java.io.Serializable;
import lists.*;

public class Pile<T extends Comparable<T>> implements PileTAD<T>, Serializable {
	private static final long serialVersionUID = 1L;
	private ListTAD<T> lst = new ListDoubleLinked<T>();
	
	public void push(T dado)
	{
		lst.add(0, dado);
	}
	
	public T pop()
	{
		if (!this.isEmpty()) return lst.remove(0);
		return null;
	}
	
	public T top()
	{
		if (!this.isEmpty()) return lst.get(0);
		return null;
	}
	
	public boolean isEmpty()
	{
		return lst.isEmpty();
	}
	
	public int size()
	{
		return lst.size();
	}

	public Pile<T> copy() {
		Pile<T> auxPile = new Pile<T>();
		if (size() == 0) return auxPile;
		for (int i=lst.size()-1; i >= 0; i--) {
			auxPile.push(lst.get(i));
		}
		return auxPile;
	}

	public String toString() {
		return lst.toString();
	}
}
