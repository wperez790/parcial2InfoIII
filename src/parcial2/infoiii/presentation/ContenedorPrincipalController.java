/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial2.infoiii.presentation;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.stage.Stage;
import parcial2.infoiii.Context;
import static parcial2.infoiii.Context.primaryStage;

/**
 * FXML Controller class
 *
 * @author walt
 */
public class ContenedorPrincipalController implements Initializable {

    @FXML
    private SplitPane splitPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Context.splitPane = splitPane;
    }

    public void init() {
        try {
            Context.primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/parcial2/infoiii/presentation/ContenedorPrincipal.fxml"));
            Scene scene = new Scene(root);
            Context.primaryStage.setScene(scene);
            primaryStage.setTitle("Parcial 2 - Info III - Azcona-Perez ");
            Context.primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}
