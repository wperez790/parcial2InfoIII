package parcial2.infoiii.model;

public class Node<T extends Comparable> {

    private int height;
    private T dat;
    private Node<T> left;
    private Node<T> right;

    public Node(T dat){
        this.height = 0;
        this.dat = dat;
        this.left = null;
        this.right = null;
    }
    public Node(Node<T> node){
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

    public T getDat() {
        return dat;
    }

    public void setDat(T dat) {
        this.dat = dat;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int balance(Node<T> aux){
        if(aux != null){
            return (height(aux.right) - height(aux.left));
        }
        return 0;
    }

    public int height(Node<T> aux){

        if(aux == null){
            return -1;
        }
        else{
            return 1 + Math.max(height(aux.left),height(aux.right));
        }
    }

    public Node<T> rightRotate(Node<T> k2){

        Node<T> k1 = new Node<T>(k2.left);
        k2.left = k1.right;
        k1.right = k2;

        k1.height = height(k1);
        k2.height = height(k2);

        return k1;
    }

    public Node<T> leftRotate(Node<T> k2){

        Node<T> k1 = new Node<T>(k2.right);
        k2.right = k1.left;
        k1.left = k2;

        k1.height = height(k1);
        k2.height = height(k2);

        return k1;
    }

    public Node<T> insert (Node<T> aux, T dat){

        if(aux == null){
            return new Node<T>(dat);
        }

        if(aux.dat.compareTo(dat) > 0){
            aux.left = insert(aux.left,dat);
        }
        else{
            aux.right = insert(aux.right,dat);
        }

        aux.height = height(aux);

        int balance = balance(aux);

        //Rotación simple izquierda (RSI)

        if(balance > 1 && balance(aux.right) > 0){
            return leftRotate(aux);
        }

        //Rotación simple derecha (RSD)

        if(balance < -1 && balance(aux.left) < 0){
            return rightRotate(aux);
        }

        //Rotación doble izquierda (RDI)

        if(balance < -1 && balance(aux.left) > 0 ){
            aux.left = leftRotate(aux.left);
            return rightRotate(aux);
        }

        //Rotación doble derecha (RDD)

        if(balance > 1 && balance(aux.left) < 0 ){
            aux.right = rightRotate(aux.right);
            return leftRotate(aux);
        }

        return aux; //Sin replicados
    }

    public void inOrder(){

        if(left != null){
            left.inOrder();
        }
        System.out.print(dat.toString() + " ");
        if(right != null){
            right.inOrder();
        }
    }

    public void preOrder(){

        System.out.print(dat.toString() + " ");

        if(left != null)
            left.preOrder();
        if(right != null)
            right.preOrder();
    }

    public void postOrder(){

        if(left != null)
            left.postOrder();
        if(right != null)
            right.postOrder();
        System.out.print(dat.toString() + " ");
    }
}
