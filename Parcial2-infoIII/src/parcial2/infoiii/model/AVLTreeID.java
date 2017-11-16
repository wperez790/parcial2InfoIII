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
public class AVLTreeID {

    private NodeTreeID root;

    public NodeTreeID getRoot() {
        return root;
    }

    public AVLTreeID() {
        this.root = null;
    }

    public void insertByID(Email m) throws Exception {
        if (root == null) {
            root = new NodeTreeID(m);
        } else {
            root = root.insertByID(root, m);
        }
    }

    public Email delete(long id) throws Exception {
        if (root == null) {
            throw new Exception("Árbol Vacio");
        } else {
            root = root.delete(id);
        }
        return Context.email;
    }

}
