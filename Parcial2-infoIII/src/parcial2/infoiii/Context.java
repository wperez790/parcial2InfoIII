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
import parcial2.infoiii.model.HashMap;
/**
 *
 * @author walt
 */
public class Context {

    public static Stage primaryStage;
    public static SplitPane splitPane;
    public static AVLTree avlTreeFrom;
    public static AVLTree avlTreeDate;
    public static HashMap hashAvlTree;
    
    public static AVLTree initAVLTree(){
        return new AVLTree();
    }
    
    public static HashMap initHashMap(){
        return new HashMap(10);
    }

    static void abrirMenu() {
        Context.abrirContenedorPrincipal();
        MenuController menu = new MenuController();
        menu.init();
    }

    private static void abrirContenedorPrincipal() {

        ContenedorPrincipalController contenedor = new ContenedorPrincipalController();
        contenedor.init();

    }

}
