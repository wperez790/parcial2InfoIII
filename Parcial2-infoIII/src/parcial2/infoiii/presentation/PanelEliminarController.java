/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial2.infoiii.presentation;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import parcial2.infoiii.Context;
import parcial2.infoiii.business.MailManager;

/**
 * FXML Controller class
 *
 * @author walt
 */
public class PanelEliminarController implements Initializable {

    @FXML
    private JFXTextField textFieldID;
    @FXML
    private JFXButton btnEliminar;
    @FXML
    private JFXButton btnBack;

    //AUX
    MailManager mailManagerBO = new MailManager();

    //
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    /*Elimina el e-mail por el ID introducido*/
    @FXML
    private void btnEliminarAction(ActionEvent event) throws Exception {

        long id = Long.parseLong(textFieldID.getText());
        Context.id = id;
        mailManagerBO.deleteMail(id);
    }

    @FXML
    private void btnBackAction(ActionEvent event) {

        try {

            Parent root = FXMLLoader.load(getClass().getResource("/parcial2/infoiii/presentation/Menu.fxml"));
            Context.splitPane.getItems().set(0, root);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}
