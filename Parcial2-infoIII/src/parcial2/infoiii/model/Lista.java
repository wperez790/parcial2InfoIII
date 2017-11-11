package parcial2.infoiii.model;

/**
 * Created by Ramiro on 17/8/2017.
 */
public class Lista<T> {

    private NodeList inicio;
    private NodeListPos inicioLP;
    private int tamanio;

    public NodeListPos getInicioLP() {
        return inicioLP;
    }

    public void setInicioLP(NodeListPos inicioLP) {
        this.inicioLP = inicioLP;
    }

    public NodeList getInicio() {
        return inicio;
    }

    public void setInicio(NodeList inicio) {
        this.inicio = inicio;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public void insertar(Email dat) throws Exception {

        NodeList aux = inicio;

        if (inicio == null) {
            NodeList nuevo = new NodeList(dat, inicio);
            tamanio = 1;
            inicio = nuevo;
            return;
        }

        while (aux.getNext()!= null) {

            aux = aux.getNext();
        }

        NodeList nuevo = new NodeList(dat, aux.getNext());
        aux.setNext(nuevo);
        tamanio++;
    }
    void insertarContenedor(ContenedorMail dat) {
        
        NodeListPos aux = inicioLP;

        if (inicioLP== null) {
            NodeListPos nuevo = new NodeListPos( dat, inicioLP);
            tamanio = 1;
            inicioLP = nuevo;
            return;
        }

        while (aux.getNext() != null) {

            aux = aux.getNext();
        }

        NodeListPos nuevo = new NodeListPos(dat, aux.getNext());
        aux.setNext(nuevo);
        tamanio++;
    
        
    }

    public Email getDato(int pos) throws Exception {

        NodeList aux = inicio;
        int cont = 0;

        if (pos >= tamanio) {

            throw new Exception("Error");
        }
        if (aux == null) {
            throw new Exception("Error");
        }

        while (cont < pos && aux != null) {
            cont++;
            aux = aux.getNext();
        }
        return aux.getDato();
    }

    public void borrar(int pos) throws Exception {

        NodeList aux = inicio;

        int cont = 0;

        if (pos >= tamanio) {
            throw new Exception("Error");
        }

        if (pos == 0) {
            inicio = inicio.getNext();
        }

        while (cont < (pos - 1) && aux != null) {
            cont++;
            aux = aux.getNext();
        }

        if (aux == null) {
            throw new Exception("Error");
        }

        aux.setNext((aux.getNext().getNext()));
    }

    public Lista concatenar(Lista lista1, Lista lista2) {
        
        if(lista1.inicio == null){
            lista1 = lista2;
            lista1.setTamanio(lista2.getTamanio());
            return lista1;
        }
        else{
           NodeList aux = lista1.getInicio();
           while (aux.getNext() != null) {
                aux = aux.getNext();
            }
            aux.setNext(lista2.getInicio());
            lista1.setTamanio(lista1.getTamanio() + lista2.getTamanio());
            return lista1;  
        }       
    }

    public void mostrarLista(Lista lista) {
        NodeList aux = lista.getInicio();
        while (aux != null) {
            System.out.print(aux.getDato() + "\t");
            aux = aux.getNext();
        }
        System.out.println();
    }

    public Lista fnInvierte(Lista lista) {

        int i = 0, tamanio, cont = 0;
        tamanio = lista.getTamanio();
        NodeList aux1 = lista.getInicio();
        NodeList aux2 = lista.getInicio();

        do {
            while (i < tamanio - 1) {
                aux1 = aux1.getNext();
                i++;
            }
            Email t = aux1.getDato();
            aux1.setDato(aux2.getDato());
            aux2.setDato(t);
            aux2 = aux2.getNext();
            aux1 = lista.getInicio();
            tamanio -= 1;
            i = 0;
            cont++;
        } while (cont < tamanio);

        return lista;
    }

    public Lista merger(Lista lista1, Lista lista2) {

        NodeList aux = lista1.getInicio();

        while (aux.getNext() != null) {
            aux = aux.getNext();
        }

        aux.setNext(lista2.getInicio());

        return lista1;
    }

    
}
