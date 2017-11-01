package parcial2.infoiii.model;

/**
 * Created by Ramiro on 17/8/2017.
 */
public class NodeList {

    private Email dato;
    private NodeList next;

    public NodeList( Email dato, NodeList next){

        this.dato = dato;
        this.next = next;
    }

    public Email getDato() {
        return dato;
    }

    public void setDato(Email dato) {
        this.dato = dato;
    }

    public NodeList getNext() {
        return next;
    }

    public void setNext(NodeList next) {
        this.next = next;
    }

}
