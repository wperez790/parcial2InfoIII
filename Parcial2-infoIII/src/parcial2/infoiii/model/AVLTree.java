package parcial2.infoiii.model;

public class AVLTree <T extends Comparable> {

    private NodeTree root;

    public AVLTree(){
        this.root = null;
    }

    public void insertByDate(Email m) throws Exception{
        if(root == null){
            root = new NodeTree(m);
        }
        else{
            root = root.insertByDate(root,m);
        }
    }
    public void insertByFrom(Email m) throws Exception{
        if(root == null){
            root = new NodeTree(m);
        }
        else{
            root = root.insertByFrom(root,m);
        }
    }
    
    public void insertBySubject(Email m) throws Exception{
        if(root == null){
            root = new NodeTree(m);
        }
        else{
            root = root.insertByFrom(root,m);
        }
    }
    
    public void getSorted(){
        if(root != null){
            root.getSorted();
        }
    }
    
    public void getSortedByDate(String desde, String hasta){
        if(root != null){
            root.getSortedByDate(desde,hasta);
        }
    }

    /*public void inOrder (){
        if(root != null)
            root.inOrder();
    }*/

}
