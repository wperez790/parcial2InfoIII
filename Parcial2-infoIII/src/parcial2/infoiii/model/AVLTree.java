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
        else{
            System.out.println("Árbol vacío");
        }
    }
    
    public void getSortedByDate(String desde, String hasta){
        if(root != null && root.getDat().getInicio().getDato().getDate().compareTo(desde) != 0){
            root.getSortedByDate(desde,hasta);
        }
        else if (root != null){
            root.getSortedByDateTo(hasta);
        }
        else{
            System.out.println("Árbol vacío");
        }
    }
    
    public void getByFrom(String from){
        if(root != null){
            root.getByFrom(from);
        }
    }

    /*public void inOrder (){
        if(root != null)
            root.inOrder();
    }*/

}
