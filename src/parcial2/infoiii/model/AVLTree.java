package parcial2.infoiii.model;

public class AVLTree <T extends Comparable> {

    private Node<T> root;

    public AVLTree(){
        this.root = null;
    }

    public void insert(T dat){
        if(root == null){
            root = new Node<T>(dat);
        }
        else{
            root = root.insert(root,dat);
        }
    }

    public void inOrder (){
        if(root != null)
            root.inOrder();
    }

    public void preOrder (){
        if(root != null)
            root.preOrder();
    }

    public void postOrder (){
        if(root != null)
            root.postOrder();
    }

}
