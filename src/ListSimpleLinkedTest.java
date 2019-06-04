import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListSimpleLinkedTest {

    @Test
    void add() {
        ListSimpleLinked<Integer> lista = new ListSimpleLinked();
        lista.add(25);
        lista.add(55);
        lista.add(47);
        lista.add(35);

        int esperado = 25;
        int obtido = lista.getFirst();

        assertEquals(esperado, obtido);

        esperado = 35;
        obtido = lista.getLast();

        assertEquals(esperado, obtido);
    }

    @Test
    void addFirst(){
        ListSimpleLinked<Integer> lista = new ListSimpleLinked();
        lista.addFirst(25);
        lista.addFirst(35);
        lista.addFirst(96);
        lista.add(65);

        int esperado = 65;
        int obtido = lista.getLast();

        assertEquals(esperado, obtido);

        esperado = 96;
        obtido = lista.getFirst();

        assertEquals(esperado, obtido);
    }

    @Test
    void get(){
        ListSimpleLinked<Integer> lista = new ListSimpleLinked();
        lista.add(25);
        lista.add(35);
        lista.add(96);
        lista.add(65);

        int esperado = 96;
        int obtido = lista.get(2);

        assertEquals(esperado, obtido);
    }

    @Test
    void set(){
        ListSimpleLinked<Integer> lista = new ListSimpleLinked();
        lista.add(25);
        lista.add(35);
        lista.add(96);
        lista.add(65);

        lista.set(2, 100);

        int esperado = 100;
        int obtido = lista.get(2);

        assertEquals(esperado, obtido);
    }

    @Test
    void removeFirst(){
        ListSimpleLinked<Integer> lista = new ListSimpleLinked();
        lista.add(25);
        lista.add(35);
        lista.add(96);
        lista.add(65);

        int esperado = 25;
        int obtido = lista.removeFirst();

        assertEquals(esperado, obtido);

        esperado = 35;
        obtido = lista.removeFirst();

        assertEquals(esperado, obtido);


    }

    @Test
    void removeLast(){
        ListSimpleLinked<Integer> lista = new ListSimpleLinked();
        lista.add(25);
        lista.add(35);
        lista.add(96);
        lista.add(65);

        int esperado = 65;
        int obtido = lista.removeLast();

        assertEquals(esperado, obtido);

        esperado = 96;
        obtido = lista.removeLast();

        assertEquals(esperado, obtido);
    }
}