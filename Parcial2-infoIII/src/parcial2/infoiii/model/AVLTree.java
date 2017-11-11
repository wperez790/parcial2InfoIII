package parcial2.infoiii.model;

public class AVLTree<T extends Comparable> {

    private NodeTree root;

    public AVLTree() {
        this.root = null;
    }

    public void insertByDate(Email m) throws Exception {
        if (root == null) {
            root = new NodeTree(m);
        } else {
            root = root.insertByDate(root, m);
        }
    }

    public void insertByFrom(Email m) throws Exception {
        if (root == null) {
            root = new NodeTree(m);
        } else {
            root = root.insertByFrom(root, m);
        }
    }

    public void insertByWord(ContenedorMail cm) throws Exception {
        if (root == null) {
            root = new NodeTree(cm);
        } else {
            root = root.insertByWord(root, cm);
        }
    }

    public void getSorted() throws Exception {
        if (root != null) {
            root.getSorted();
            
        } else {
            throw new Exception("Vacio");
        }
    }

    public void getSortedByDate(String desde, String hasta) throws Exception {
        if (root != null) {
            root.getSortedByDate(desde, hasta);
        } else {
            throw new Exception("Árbol vacio") ;
                    /*        if (root != null && root.getDat().getInicio().getDato().getDate().compareTo(desde) != 0) {
        //lista  //nodoIni //Email    //fecha
        root.getSortedByDate(desde, hasta, list);
        return list;
        } else if (root != null) {
        root.getSortedByDateTo(hasta, list);
        return list;
        } else {
        return null;
        }*/
    
        }
    }

    public Lista getByFrom(String from) throws Exception {
        if (root != null) {
            return root.getByFrom(from);
        } else {
            return null;
        }

    }

    public Lista getByQuery(String[] query) throws Exception {

        return root.getByQuery(query);

    }

    /*public void inOrder (){
        if(root != null)
            root.inOrder();
    }*/
}
