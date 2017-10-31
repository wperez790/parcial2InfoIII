package parcial2.infoiii.model;

/**
 * Created by Ramiro on 17/8/2017.
 */
public class Nodo<Email> {

    private Email dato;
    private Nodo next;

    public Nodo( Email dato, Nodo next){

        this.dato = dato;
        this.next = next;
    }

    public Email getDato() {
        return dato;
    }

    public void setDato(Email dato) {
        this.dato = dato;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

}
