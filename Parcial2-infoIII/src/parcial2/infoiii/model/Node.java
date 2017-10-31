package parcial2.infoiii.model;

public class Node {

    private int height;
    private Lista dat;
    private Node left;
    private Node right;

    public Node(Email dat) throws Exception{
        this.height = 0;
        this.dat.insertar(dat);
        this.left = null;
        this.right = null;
    }
    public Node(Node node){
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

    public int balance(Node aux){
        if(aux != null){
            return (height(aux.right) - height(aux.left));
        }
        return 0;
    }

    public int height(Node aux){

        if(aux == null){
            return -1;
        }
        else{
            return 1 + Math.max(height(aux.left),height(aux.right));
        }
    }

    public Node rightRotate(Node k2){

        Node k1 = new Node(k2.left);
        k2.left = k1.right;
        k1.right = k2;

        k1.height = height(k1);
        k2.height = height(k2);

        return k1;
    }

    public Node leftRotate(Node k2){

        Node k1 = new Node(k2.right);
        k2.right = k1.left;
        k1.left = k2;

        k1.height = height(k1);
        k2.height = height(k2);

        return k1;
    }

    public Node insertByFrom (Node aux, Email dat) throws Exception{

        if(aux == null){
            return new Node(dat);
        }

        if(aux.dat.getInicio().getDato().getFrom().compareTo(dat.getFrom()) > 0){
            aux.left = insertByFrom(aux.left,dat);
        }
        else{
            aux.right = insertByFrom(aux.right,dat);
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
     public Node insertByDate (Node aux, Email dat) throws Exception{

        if(aux == null){
            return new Node(dat);
        }

        if(aux.dat.getInicio().getDato().getFrom().compareTo(dat.getFrom()) > 0){
            aux.left = insertByFrom(aux.left,dat);
        }
        else{
            aux.right = insertByFrom(aux.right,dat);
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
