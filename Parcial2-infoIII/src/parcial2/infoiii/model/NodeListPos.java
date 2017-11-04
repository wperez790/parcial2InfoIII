package parcial2.infoiii.model;

/**
 * Created by Ramiro on 17/8/2017.
 */
public class NodeListPos {

    private ContenedorMail dato;
    private NodeListPos next;

    public NodeListPos( ContenedorMail dato, NodeListPos next){

        this.dato = dato;
        this.next = next;
    }

    public ContenedorMail getDato() {
        return dato;
    }

    public void setDato(ContenedorMail dato) {
        this.dato = dato;
    }

    public NodeListPos getNext() {
        return next;
    }

    public void setNext(NodeListPos next) {
        this.next = next;
    }

}
