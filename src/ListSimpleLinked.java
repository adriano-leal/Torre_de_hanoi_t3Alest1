import com.sun.org.apache.bcel.internal.classfile.Node;

public class ListSimpleLinked<E extends Comparable<E>> implements ListTAD<E> {

    private Nodo refHead;
    private Nodo refTail;
    private int qtdElements;

    public E getFirst() {
        return refHead.getElement();
    }

    public E getLast() {
        return refTail.getElement();
    }

    private class Nodo {
        private E element;
        private Nodo refNext;

        public Nodo(E e) {
            element = e;
            refNext = null;
        }

        public void setNext (Nodo n) { refNext = n; }
        public E getElement() { return element; }
        public Nodo getNext() { return refNext; }
        public void setElement(E element){ this.element = element; }
    }

    @Override
    public void add(E element) {
        Nodo n = new Nodo(element);

        if(refHead == null){
            refHead = refTail = n;
        }else{
            refTail.setNext(n);
            refTail = n;
        }
        qtdElements++;
    }

    public void add(int index, E element){
        Nodo n = new Nodo(element);

        if(refHead == null) {
            refHead = refTail = n;
        } else {
            Nodo aux = refHead;

            for(int i = 0; i < index-1; i++) {
                aux = aux.getNext().getNext();
            }

            aux.setNext(aux.getNext());
        }
    }

    @Override
    public void addFirst(E element) {
        Nodo n = new Nodo(element);

        if(refTail == null){
            add(element);
        }else{
            refHead = n;
            n.setNext(refTail);
        }

        qtdElements++;
    }

    @Override
    public E get(int pos) {
        Nodo aux = refHead;

        for (int i = 0; i < pos; i++) {
            aux = aux.getNext();
        }
        return aux.getElement();
    }

    @Override
    public void set(int index, E element) {
        Nodo aux = refHead;

        for (int i = 0; i < index; i++) {
            aux = aux.getNext();
        }

        aux.setElement(element);
    }

    public E removeFirst(){
        E aux = null;

        if(refHead != null){
            aux = refHead.getElement();
            refHead = refHead.getNext();
        }

        qtdElements--;

        return aux;
    }

    public E removeLast() {
        E object = null;
        Nodo aux;

        if (refTail != null) {
            object = refTail.getElement();
            aux = refHead;

            for( ; aux.getNext().getNext() != null; ) {
                aux = aux.getNext();
            }
            aux.setNext(null);
            refTail.setNext(aux);
            refTail = aux;

            qtdElements--;
        }
        return object;
    }
}