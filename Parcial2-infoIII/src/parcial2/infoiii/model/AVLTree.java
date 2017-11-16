package parcial2.infoiii.model;

public class AVLTree<T extends Comparable> {

    private NodeTree root;

    public NodeTree getRoot() {
        return root;
    }

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
            throw new Exception("Árbol vacio");

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

    public void getSortedByDateTo(String hasta) throws Exception {
        if (root != null) {
            root.getSortedByDateTo(hasta);
        } else {
            throw new Exception();
        }
    }

    public void getSortedByDateFrom(String desde) throws Exception {
        if (root != null) {
            root.getSortedByDateFrom(desde);
        } else {
            throw new Exception();
        }
    }

    public void deleteByDate(String date) throws Exception {
        if (root == null) {
            throw new Exception("Árbol Vacio");
        } else {
            root = root.deleteByDate(date);
        }
    }

    public void deleteByFrom(String from) throws Exception {
        if (root == null) {
            throw new Exception("Árbol Vacio");
        } else {
            root = root.deleteByFrom(from);
        }
    }
}
