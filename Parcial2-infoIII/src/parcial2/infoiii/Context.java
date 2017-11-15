/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial2.infoiii;

import parcial2.infoiii.model.AVLTree;
import javafx.scene.control.SplitPane;
import javafx.stage.Stage;
import parcial2.infoiii.presentation.ContenedorPrincipalController;
import parcial2.infoiii.presentation.MenuController;
import parcial2.infoiii.model.AVLTree;
import parcial2.infoiii.model.AVLTreeID;
import parcial2.infoiii.model.Email;
import parcial2.infoiii.model.HashMap;
import parcial2.infoiii.model.Lista;
import parcial2.infoiii.presentation.DetalleMailController;

/**
 *
 * @author walt
 */
public class Context<T extends Comparable> {

    public static Stage primaryStage;
    public static SplitPane splitPane;
    public static AVLTree avlTreeFrom;
    public static AVLTree avlTreeDate;
    public static AVLTreeID avlTreeID;
    public static HashMap hashAvlTree;
    public static Lista list;
    public static String op;
    public static Email email;
    public static long id;

    /*Inicializa el AVL Tree ID*/
    public static AVLTreeID initAVLTreeID() {
        return new AVLTreeID();
    }

    /*Inicializa el AVL Tree*/
    public static AVLTree initAVLTree() {
        return new AVLTree();
    }

    /*Inicializa la tabla Hash*/
    public static HashMap initHashMap() {
        return new HashMap(17498);
    }

    /*Abre el Menu*/
    public static void abrirMenu() {
        MenuController menu = new MenuController();
        menu.init();
    }

    /*Abre el contenedor Pricipal*/
    static void abrirContenedorPrincipal() {

        ContenedorPrincipalController contenedor = new ContenedorPrincipalController();
        contenedor.init();

    }

    /*Abre el Email indicado*/
    public static void abrirEmail() {
        DetalleMailController detalle = new DetalleMailController();
        detalle.init();
    }

}
