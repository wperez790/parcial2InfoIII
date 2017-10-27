package parcial2.infoiii.model;

/**
 * Created by Ramiro on 17/8/2017.
 */
public class Nodo<T> {

    private T dato;
    private Nodo next;

    public Nodo( T dato, Nodo next){

        this.dato = dato;
        this.next = next;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

}
