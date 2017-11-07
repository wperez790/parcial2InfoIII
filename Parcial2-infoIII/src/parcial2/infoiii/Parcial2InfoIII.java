/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial2.infoiii;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import parcial2.infoiii.model.AVLTree;
import parcial2.infoiii.model.Lista;

/**
 *
 * @author walt
 */
public class Parcial2InfoIII extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Context.avlTreeDate = new AVLTree();//Context.initAVLTree();
        Context.avlTreeFrom = Context.initAVLTree();
        Context.hashAvlTree = Context.initHashMap();
        Context.list = new Lista();
        Context.abrirContenedorPrincipal();
        Context.abrirMenu();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
