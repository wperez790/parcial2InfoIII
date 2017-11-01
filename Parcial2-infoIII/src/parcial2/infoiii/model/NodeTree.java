package parcial2.infoiii.model;

public class NodeTree {
    
    private int height;
    private Lista dat;
    private NodeTree left;
    private NodeTree right;
    
    public NodeTree(Email dat) throws Exception {
        this.height = 0;
        this.dat.insertar(dat);
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
    
    public NodeTree insertBySubject(NodeTree aux, Email m) throws Exception {
        
        if (aux == null) {
            return new NodeTree(m);
        }
        
        if (aux.dat.getInicio().getDato().getSubject().compareTo(m.getSubject()) > 0) {
            aux.left = insertByFrom(aux.left, m);
        } else if (aux.dat.getInicio().getDato().getSubject().compareTo(m.getSubject()) < 0) {
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
    
    public void getSorted(){
        
        if (left != null) {
            left.getSorted();
        }
        dat.mostrarLista(dat);
        if (right != null) {
            right.getSorted();
        }
    }
    
    public void getSortedByDate(String desde, String hasta){
        if(left != null && left.getDat().getInicio().getDato().getDate().compareTo(desde) > 0){
            left.getSortedByDate(desde, hasta);
        }
        if(right != null && left.getDat().getInicio().getDato().getDate().compareTo(desde) < 0){
            right.getSortedByDate(desde, hasta);
        }
        this.getSortedByDateTo(hasta);
    }
    
    public void getSortedByDateTo(String hasta){
        
        if (left != null || left.getDat().getInicio().getDato().getDate().compareTo(hasta) == 0) {
            left.getSortedByDateTo(hasta);
        }
        dat.mostrarLista(dat);
        if (right != null || right.getDat().getInicio().getDato().getDate().compareTo(hasta) == 0) {
            right.getSortedByDateTo(hasta);
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
    }
