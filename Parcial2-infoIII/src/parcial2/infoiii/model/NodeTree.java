package parcial2.infoiii.model;

import parcial2.infoiii.Context;

public class NodeTree {

    private int height;
    private Lista dat;
    private NodeTree left;
    private NodeTree right;

    public NodeTree(Email dat) throws Exception {
        this.height = 0;
        this.dat = new Lista();
        this.dat.insertar(dat);
        this.left = null;
        this.right = null;
    }

    public NodeTree(ContenedorMail dat) throws Exception {
        this.height = 0;
        this.dat = new Lista();
        this.dat.insertarContenedor(dat);
        this.left = null;
        this.right = null;
    }

    public NodeTree(NodeTree node) {
        this.height = 0;
        this.dat = node.getDat();
        this.left = node.getLeft();
        this.right = node.getRight();
    }

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

    public NodeTree insertByFrom(NodeTree aux, Email m) throws Exception {

        if (aux == null) {
            return new NodeTree(m);
        }

        if (aux.dat.getInicio().getDato().getFrom().compareTo(m.getFrom()) > 0) {
            aux.left = insertByFrom(aux.left, m);
        } else if (aux.dat.getInicio().getDato().getFrom().compareTo(m.getFrom()) < 0) {
            aux.right = insertByFrom(aux.right, m);
        } else {
            this.dat.insertar(m);
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
            this.dat.insertar(m);
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
            return new NodeTree(cm);
        }

        if (aux.dat.getInicioLP().getDato().getKey().compareTo(cm.getKey()) > 0) {
            aux.left = insertByWord(aux.left, cm);
        } else if (aux.dat.getInicioLP().getDato().getKey().compareTo(cm.getKey()) < 0) {
            aux.right = insertByWord(aux.right, cm);
        } else {
            this.dat.insertarContenedor(cm);
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

    public void getSorted(Lista list) {

        if (left != null) {
            left.getSorted(list);
        }
        list.concatenar(list, dat);
        if (right != null) {
            right.getSorted(list);
        }
    }

    public void getSortedByDate(String desde, String hasta, Lista list) {

        //Ubico la fecha inicial (desde)
        if (left != null && dat.getInicio().getDato().getDate().compareTo(desde) > 0) {
            left.getSortedByDate(desde, hasta, list);
        }
        if (right != null && dat.getInicio().getDato().getDate().compareTo(desde) < 0) {
            right.getSortedByDate(desde, hasta, list);
        }
        if (hasta == null) {
            this.getSorted(list);   //Si no se ingresa una fecha límite (hasta)
        } else {
            this.getSortedByDateTo(hasta, list); //Muestro las listas hasta la fecha final (hasta)
        }
    }

    public void getSortedByDateTo(String hasta, Lista list) {

        if (left != null || dat.getInicio().getDato().getDate().compareTo(hasta) == 0) {
            left.getSortedByDateTo(hasta, list);
        }
        list.concatenar(list, dat);          //Concateno las listas desde-hasta
        if (right != null || dat.getInicio().getDato().getDate().compareTo(hasta) == 0) {
            right.getSortedByDateTo(hasta, list);
        }
    }

    public Lista getByFrom(String from) throws Exception {
        NodeTree aux = this;
        //Ubico la lista con los emails del remitente deseado
        while (aux.dat.getInicio().getDato().getFrom().compareTo(from) != 0) {
            if (left != null && dat.getInicio().getDato().getFrom().compareTo(from) > 0) {
                aux = left;
            }
            if (right != null && dat.getInicio().getDato().getFrom().compareTo(from) < 0) {
                aux = right;
            }
        }
        if (aux == null) {
            throw new Exception();
        }

        return aux.dat;   //Devuelvo la lista con los emails del remitente deseado

    }

    public Lista getByQuery(String[] query) throws Exception {
        NodeTree aux2 = this;
        while (aux2.dat.getInicioLP().getDato().getKey().compareTo(query[0]) != 0) {
            if (aux2.dat.getInicioLP().getDato().getKey().compareTo(query[0]) > 0) {
                aux2 = left;
            }
            if (aux2.dat.getInicioLP().getDato().getKey().compareTo(query[0]) < 0) {
                aux2 = right;
            } else if (aux2 == null) {
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

    }

    /*public void inOrder() {
        
        if (left != null) {
            left.inOrder();
        }
        System.out.print(dat.toString() + " ");
        if (right != null) {
            right.inOrder();
        }*/
