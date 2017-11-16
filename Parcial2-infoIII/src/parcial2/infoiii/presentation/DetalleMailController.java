/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial2.infoiii.presentation;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import parcial2.infoiii.Context;

/**
 * FXML Controller class
 *
 * @author walt
 */
public class DetalleMailController implements Initializable {

//AUX
    private static Stage stage = new Stage();
    @FXML
    private JFXTextArea textAreaContenido;
    private Label labelAsunto;
    @FXML
    private Label labelRemitente;
    @FXML
    private Label labelDestinatario;
    @FXML
    private Label labelFecha;
    @FXML
    private JFXButton btnClose;
    @FXML
    private JFXTextArea textAreaAsunto;
///

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Inicializo lo que debe contener cada parte del e-mail con la información del email del context.
        textAreaAsunto.setText(Context.email.getSubject());
        labelDestinatario.setText(Context.email.getTo());
        labelRemitente.setText(Context.email.getFrom());
        labelFecha.setText(Context.email.getDate());
        textAreaContenido.setText(Context.email.getContent());
    }

    public void init() {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("/parcial2/infoiii/presentation/DetalleMail.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Email");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    /*Cierra la pestaña/stage abierta/o*/
    @FXML
    private void btnCloseAction(ActionEvent event) {
        stage.close();
    }

}
