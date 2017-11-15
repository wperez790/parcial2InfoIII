/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial2.infoiii.model;

import parcial2.infoiii.Context;

/**
 *
 * @author walt
 */
public class NodeTreeID {

    private int height;
    private Email dat;
    private NodeTreeID left;
    private NodeTreeID right;

    public NodeTreeID(Email dat) {
        this.height = 0;
        this.dat = dat;
        this.left = null;
        this.right = null;
    }

    public NodeTreeID(NodeTreeID node) {
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

    public Email getDat() {
        return dat;
    }

    public void setDat(Email dat) {
        this.dat = dat;
    }

    public NodeTreeID getLeft() {
        return left;
    }

    public void setLeft(NodeTreeID left) {
        this.left = left;
    }

    public NodeTreeID getRight() {
        return right;
    }

    public void setRight(NodeTreeID right) {
        this.right = right;
    }
    //////////////////////////////// 

    public int balance(NodeTreeID aux) {
        if (aux != null) {
            return (height(aux.right) - height(aux.left));
        }
        return 0;
    }

    public int height(NodeTreeID aux) {

        if (aux == null) {
            return -1;
        } else {
            return 1 + Math.max(height(aux.left), height(aux.right));
        }
    }

    public NodeTreeID rightRotate(NodeTreeID k2) {

        NodeTreeID k1 = new NodeTreeID(k2.left);
        k2.left = k1.right;
        k1.right = k2;

        k1.height = height(k1);
        k2.height = height(k2);

        return k1;
    }

    public NodeTreeID leftRotate(NodeTreeID k2) {

        NodeTreeID k1 = new NodeTreeID(k2.right);
        k2.right = k1.left;
        k1.left = k2;

        k1.height = height(k1);
        k2.height = height(k2);

        return k1;
    }

    public NodeTreeID delete(long d) throws Exception {
        if (d > dat.getId()) {
            if (right != null) {
                right = right.delete(d); //me muevo por la rama derecha para buscar los mayores al root
            } else {
                throw new Exception("No se encontro el dato");
            }
        } else if (d< dat.getId()) {
            if (left != null) {
                left = left.delete(d);   //me muevo por la rama izquierda para buscar los menores al root
            } else {
                throw new Exception("No se encontro el dato");
            }
        } else {
            if (right == null) {
                Context.email = this.dat;
                return left;
            }
            Context.email = this.dat;
            /*Context.id = this.dat.getId();*/
            right.insertar(left);
            return right;
        }
        return this;
    }

    private NodeTreeID insertar(NodeTreeID aux) throws Exception {
        
        
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
        

    }

    NodeTreeID insertByID(NodeTreeID aux, Email m) throws Exception {
       
        if (aux == null) {
            return new NodeTreeID(m);
        }

        if (aux.dat.getId()  > m.getId()) {
            aux.left = insertByID(aux.left, m);
        } else if (aux.dat.getId() < m.getId()) {
            aux.right = insertByID(aux.right, m);
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
    }
    

}
