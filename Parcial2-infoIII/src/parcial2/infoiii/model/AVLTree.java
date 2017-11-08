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

    public Lista getSorted(Lista list) {
        if (root != null) {
            root.getSorted(list);
            return list;
        } else {
            return null;
        }
    }

    public Lista getSortedByDate(String desde, String hasta, Lista list) {
        if (root != null && root.getDat().getInicio().getDato().getDate().compareTo(desde) != 0) {
            root.getSortedByDate(desde, hasta, list);
            return list;
        } else if (root != null) {
            root.getSortedByDateTo(hasta, list);
            return list;
        } else {
            return null;
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
