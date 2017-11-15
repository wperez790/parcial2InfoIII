package parcial2.infoiii.model;

import parcial2.infoiii.Context;

public class NodeTree {

    private int height;
    private Lista dat;
    private NodeTree left;
    private NodeTree right;

    /*Constructor con Email*/
    public NodeTree(Email dat) throws Exception {
        this.height = 0;
        this.dat = new Lista();
        this.dat.insertar(dat);
        this.left = null;
        this.right = null;
    }

    /**/
 /*Constructor con ContenedorMail*/
    public NodeTree(ContenedorMail dat) throws Exception {
        this.height = 0;
        this.dat = new Lista();
        this.dat.insertarContenedor(dat);
        this.left = null;
        this.right = null;
    }

    /**/
 /*Constructor con Nodo*/
    public NodeTree(NodeTree node) {
        this.height = 0;
        this.dat = node.getDat();
        this.left = node.getLeft();
        this.right = node.getRight();
    }

    /**/
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Lista getDat() {
        return dat;
    }

    public void setDat(Lista dat) {
        this.dat = dat;
    }

    public NodeTree getLeft() {
        return left;
    }

    public void setLeft(NodeTree left) {
        this.left = left;
    }

    public NodeTree getRight() {
        return right;
    }

    public void setRight(NodeTree right) {
        this.right = right;
    }

    public int balance(NodeTree aux) {
        if (aux != null) {
            return (height(aux.right) - height(aux.left));
        }
        return 0;
    }

    public int height(NodeTree aux) {

        if (aux == null) {
            return -1;
        } else {
            return 1 + Math.max(height(aux.left), height(aux.right));
        }
    }

    public NodeTree rightRotate(NodeTree k2) {

        NodeTree k1 = new NodeTree(k2.left);
        k2.left = k1.right;
        k1.right = k2;

        k1.height = height(k1);
        k2.height = height(k2);

        return k1;
    }

    public NodeTree leftRotate(NodeTree k2) {

        NodeTree k1 = new NodeTree(k2.right);
        k2.right = k1.left;
        k1.left = k2;

        k1.height = height(k1);
        k2.height = height(k2);

        return k1;
    }

    public NodeTree delete(long id) {
        /*
        int comp = dat.compareTo(d);
        if(comp < 0){
        if(der != null)
        der = der.eliminar(d);
        else
        throw new Exception("No se encontro el dato");
        }else if(comp > 0){
        if(izq != null)
        izq = izq.eliminar(d);
        else
        throw new Exception("No se encontro el dato");
        }else{
        if(der == null)
        return izq;
        der.insertar(izq);
        return der;
        }
        return this;   */
        return null;
    }

    public NodeTree insertByFrom(NodeTree aux, Email m) throws Exception {

        if (aux == null) {
            return new NodeTree(m);
        }

        if (aux.dat.getInicio().getDato().getFrom().compareTo(m.getFrom()) > 0) {
            aux.left = insertByFrom(aux.left, m);
        } else if (aux.dat.getInicio().getDato().getFrom().compareTo(m.getFrom()) < 0) {
            aux.right = insertByFrom(aux.right, m);
        } else {
            aux.dat.insertar(m);
        }

        aux.height = height(aux);

        int balance = balance(aux);

        //Rotación simple izquierda (RSI)
        if (balance > 1 && balance(aux.right) > 0) {
            return leftRotate(aux);
        }

        //Rotación simple derecha (RSD)
        if (balance < -1 && balance(aux.left) < 0) {
            return rightRotate(aux);
        }

        //Rotación doble izquierda (RDI)
        if (balance < -1 && balance(aux.left) > 0) {
            aux.left = leftRotate(aux.left);
            return rightRotate(aux);
        }

        //Rotación doble derecha (RDD)
        if (balance > 1 && balance(aux.left) < 0) {
            aux.right = rightRotate(aux.right);
            return leftRotate(aux);
        }

        return aux; //Sin replicados
    }

    public NodeTree insertByDate(NodeTree aux, Email m) throws Exception {

        if (aux == null) {
            return new NodeTree(m);
        }

        if (aux.dat.getInicio().getDato().getDate().compareTo(m.getDate()) > 0) {
            aux.left = insertByDate(aux.left, m);
        } else if (aux.dat.getInicio().getDato().getDate().compareTo(m.getDate()) < 0) {
            aux.right = insertByDate(aux.right, m);
        } else {
            aux.dat.insertar(m);
        }

        aux.height = height(aux);

        int balance = balance(aux);

        //Rotación simple izquierda (RSI)
        if (balance > 1 && balance(aux.right) > 0) {
            return leftRotate(aux);
        }

        //Rotación simple derecha (RSD)
        if (balance < -1 && balance(aux.left) < 0) {
            return rightRotate(aux);
        }

        //Rotación doble izquierda (RDI)
        if (balance < -1 && balance(aux.left) > 0) {
            aux.left = leftRotate(aux.left);
            return rightRotate(aux);
        }

        //Rotación doble derecha (RDD)
        if (balance > 1 && balance(aux.left) < 0) {
            aux.right = rightRotate(aux.right);
            return leftRotate(aux);
        }

        return aux; //Sin replicados
    }

    public NodeTree insertByWord(NodeTree aux, ContenedorMail cm) throws Exception {

        if (aux == null) {
            Context.hashAvlTree.setTam(Context.hashAvlTree.getTam() + 1);
            return new NodeTree(cm);
        }

        if (aux.dat.getInicioLP().getDato().getKey().compareTo(cm.getKey()) > 0) {
            aux.left = insertByWord(aux.left, cm);
        } else if (aux.dat.getInicioLP().getDato().getKey().compareTo(cm.getKey()) < 0) {
            aux.right = insertByWord(aux.right, cm);
        } else {
            aux.dat.insertarContenedor(cm);
        }

        aux.height = height(aux);

        int balance = balance(aux);

        //Rotación simple izquierda (RSI)
        if (balance > 1 && balance(aux.right) > 0) {
            return leftRotate(aux);
        }

        //Rotación simple derecha (RSD)
        if (balance < -1 && balance(aux.left) < 0) {
            return rightRotate(aux);
        }

        //Rotación doble izquierda (RDI)
        if (balance < -1 && balance(aux.left) > 0) {
            aux.left = leftRotate(aux.left);
            return rightRotate(aux);
        }

        //Rotación doble derecha (RDD)
        if (balance > 1 && balance(aux.left) < 0) {
            aux.right = rightRotate(aux.right);
            return leftRotate(aux);
        }

        return aux; //Sin replicados
    }

    public void getSorted() {

        if (left != null) {
            left.getSorted();
        }
        Context.list = Context.list.concatenar(Context.list, dat);
        if (right != null) {
            right.getSorted();
        }
    }

    public void getSortedByDate(String desde, String hasta) {
        String dateLeft = "";
        String dateRight = "";
        NodeTree aux = this;
        if (aux.left != null) {
            dateLeft = aux.dat.getInicio().getDato().getDate();
            if (desde.compareTo(dateLeft) <= 0) {
                aux.left.getSortedByDate(desde, hasta);
            }
        }
        if(hasta.compareTo(this.dat.getInicio().getDato().getDate())>=0)
        Context.list = Context.list.concatenar(Context.list, dat);
        Lista l1= Context.list;
        if (aux.right != null) {
            dateRight = aux.dat.getInicio().getDato().getDate();
            if (hasta.compareTo(dateRight) >= 0) {
                aux.right.getSortedByDate(desde, hasta);
            }
        }

  
    }


    public void getSortedByDateTo(String hasta) {
        NodeTree aux = getMin();
        Context.avlTreeDate.getRoot().getSortedByDate(aux.getDat().getInicio().getDato().getDate(), hasta);

    }

    public void getSortedByDateFrom(String desde) {
        NodeTree aux = getMax();

        Context.avlTreeDate.getRoot().getSortedByDate(desde, aux.getDat().getInicio().getDato().getDate());
    }

    public Lista getByFrom(String from) throws Exception {
        NodeTree aux = this;
        //Ubico la lista con los emails del remitente deseado
        while (aux.dat.getInicio().getDato().getFrom().compareTo(from) != 0) {
            if (aux.dat.getInicio().getDato().getFrom().compareTo(from) > 0) {
                aux = aux.left;
            } else if (aux.dat.getInicio().getDato().getFrom().compareTo(from) < 0) {
                aux = aux.right;
            }
            if (aux == null) {
                throw new Exception();
            }
        }

        return aux.dat;   //Devuelvo la lista con los emails del remitente deseado

    }

    public Lista getByQuery(String[] query) throws Exception {
        NodeTree aux2 = this;
        while (aux2.dat.getInicioLP().getDato().getKey().compareTo(query[0]) != 0) {
            if (aux2.dat.getInicioLP().getDato().getKey().compareTo(query[0]) > 0) {
                aux2 = aux2.left;
            } else if (aux2.dat.getInicioLP().getDato().getKey().compareTo(query[0]) < 0) {
                aux2 = aux2.right;
            }
            if (aux2 == null) {
                throw new Exception();
            }
        }
        Lista list = new Lista();
        NodeListPos aux = aux2.dat.getInicioLP();

        while (aux != null) {
            if (aux.getDato().getSubject() == true) {
                String[] splited = aux.getDato().getEmail().getSubject().split("\\s+");
                boolean ok = true;
                for (int i = 0; i < query.length && ok == true; i++) //Comparar arreglo query[] con key + lo que sigue
                {
                    if (query[i].compareTo(splited[aux.getDato().getPos() + i]) != 0) {
                        ok = false;
                    }
                }
                if (ok == true) {
                    list.insertar(aux.getDato().getEmail());
                }
            } else {
                String[] splited = aux.getDato().getEmail().getContent().split("\\s+");
                boolean ok = true;
                for (int i = 0; i < query.length && ok == true; i++) {
                    if (query[i].compareTo(splited[aux.getDato().getPos() + i]) != 0) {
                        ok = false;
                    }
                }
                if (ok == true) {
                    list.insertar(aux.getDato().getEmail());
                }

            }
            aux = aux.getNext();
        }
        return list;
    }

    private NodeTree getMin() {
        NodeTree aux = this;
        while (aux.left != null) {
            aux = aux.left;
        }
        return aux;
    }

    private NodeTree getMax() {
        NodeTree aux = this;
        while (aux.right != null) {
            aux = aux.right;
        }
        return aux;
    }

    public NodeTree deleteByDate(String date) throws Exception {
        if (date.compareTo(dat.getInicio().getDato().getDate()) > 0) {
            if (right != null) {
                right = right.deleteByDate(date); //me muevo por la rama derecha para buscar los mayores al root
            } else {
                throw new Exception("No se encontro el dato");
            }
        } else if (date.compareTo(dat.getInicio().getDato().getDate()) < 0) {
            if (left != null) {
                left = left.deleteByDate(date);   //me muevo por la rama izquierda para buscar los menores al root
            } else {
                throw new Exception("No se encontro el dato");
            }
        } else {
            if (right == null) {
                return left;
            }
            right.insertByDate(left, Context.email);
            return right;
        }
        return this;
    }

    public NodeTree deleteByFrom(String from) throws Exception {
        if (from.compareTo(dat.getInicio().getDato().getFrom()) > 0) {
            if (right != null) {
                right = right.deleteByFrom(from); //me muevo por la rama derecha para buscar los mayores al root
            } else {
                throw new Exception("No se encontro el dato");
            }
        } else if (from.compareTo(dat.getInicio().getDato().getFrom()) < 0) {
            if (left != null) {
                left = left.deleteByFrom(from);   //me muevo por la rama izquierda para buscar los menores al root
            } 
        } else if(from.compareTo(dat.getInicio().getDato().getFrom()) == 0) {
            /*Si son iguales los From me muevo a través de la lista y si la lista tiene un elemento hago el intercambio de nodos*/
            NodeList aux = this.dat.getInicio();    
            if (aux.getNext() == null) { //Pregunta si tiene un solo elemento e intercambio de ser cierto.
                if (right == null) {
                    return left;
                }
                right.insertByFrom(left, Context.email);
                return right;
            } else {                    //Si no tiene un solo elemento debo recorrerla hasta encontrar el e-mail
               this.dat.delete(Context.id);
            }
        }
        else {
                throw new Exception("No se encontro el dato");
            }
        return this;
    }

    /*   private NodeTree insertar(NodeTree aux) throws Exception {
    
    if (aux == null) {
    return aux;
    }
    
    if (aux.dat.getId() < this.dat.getId()) {
    aux.left = insertar(aux.left);
    } else if (aux.dat.getId() > this.dat.getId()) {
    aux.right = insertar(aux.right);
    } else {
    throw new Exception("Dato duplicado");
    }
    
    aux.height = height(aux);
    
    int balance = balance(aux);
    
    //Rotación simple izquierda (RSI)
    if (balance > 1 && balance(aux.right) > 0) {
    return leftRotate(aux);
    }
    
    //Rotación simple derecha (RSD)
    if (balance < -1 && balance(aux.left) < 0) {
    return rightRotate(aux);
    }
    
    //Rotación doble izquierda (RDI)
    if (balance < -1 && balance(aux.left) > 0) {
    aux.left = leftRotate(aux.left);
    return rightRotate(aux);
    }
    
    //Rotación doble derecha (RDD)
    if (balance > 1 && balance(aux.left) < 0) {
    aux.right = rightRotate(aux.right);
    return leftRotate(aux);
    }
    
    return aux; //Sin replicados
    
    }*/


}

/*public void inOrder() {
        
        if (left != null) {
            left.inOrder();
        }
        System.out.print(dat.toString() + " ");
        if (right != null) {
            right.inOrder();
        }*/
