/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial2.infoiii;

import javafx.scene.control.SplitPane;
import javafx.stage.Stage;
import parcial2.infoiii.presentation.ContenedorPrincipalController;
import parcial2.infoiii.presentation.MenuController;

/**
 *
 * @author walt
 */
public class Context {

    public static Stage primaryStage;
    public static SplitPane splitPane;

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
