package parcial2.infoiii.model;

public class AVLTree <T extends Comparable> {

    private Node root;

    public AVLTree(){
        this.root = null;
    }

    public void insertByDate(Email dat) throws Exception{
        if(root == null){
            root = new Node(dat);
        }
        else{
            root = root.insertByDate(root,dat);
        }
    }
    public void insertByFrom(Email dat) throws Exception{
        if(root == null){
            root = new Node(dat);
        }
        else{
            root = root.insertByFrom(root,dat);
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
