/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial2.infoiii.presentation;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import parcial2.infoiii.Context;

/**
 * FXML Controller class
 *
 * @author walt
 */
public class MenuController implements Initializable {


    @FXML
    private JFXButton btnEliminar;
    @FXML
    private JFXButton btnBuscar;
    @FXML
    private JFXButton btnOrdenar;
    @FXML
    private JFXButton btnAgregar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void init() {

        try {

            Parent root = FXMLLoader.load(getClass().getResource("/parcial2/infoiii/presentation/Menu.fxml"));
            Context.splitPane.getItems().set(0, root);
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    @FXML
    private void btnAgregarAction(ActionEvent event) {
    }

    @FXML
    private void btnEliminarAction(ActionEvent event) {
    }

    @FXML
    private void btnBuscarAction(ActionEvent event) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("/parcial2/infoiii/presentation/PanelBuscar.fxml"));
            Context.splitPane.getItems().set(0, root);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @FXML
    private void btnOrdenarAction(ActionEvent event) {
    }


}
