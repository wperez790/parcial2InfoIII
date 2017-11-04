/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial2.infoiii.presentation;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import parcial2.infoiii.Context;
import parcial2.infoiii.business.MailManager;
import parcial2.infoiii.model.Email;

/**
 * FXML Controller class
 *
 * @author walt
 */
public class PanelBuscarController implements Initializable {

    @FXML
    private SplitPane splitPaneBuscar;
    @FXML
    private JFXTextField textFieldPalabra;
    @FXML
    private JFXDatePicker datePickerDesde;
    @FXML
    private JFXDatePicker datePickerHasta;
    @FXML
    private JFXDatePicker datePickerFecha;
    @FXML
    private JFXTextField textFieldRemitente;
    @FXML
    private JFXButton btnBuscar;
    @FXML
    private AnchorPane anchorPaneElementos;
    @FXML
    private JFXButton btnVer;
    @FXML
    private JFXButton btnBack;
   
    //AUXILIARES
    MailManager mailManagerBO;
    //
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void btnVerAction(ActionEvent event) {
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

    @FXML
    private void btnBuscarAction(ActionEvent event) throws Exception {
        Email[] e1;
        Email[] e2;
        if(!textFieldRemitente.getText().isEmpty())
            e1= mailManagerBO.getByFrom(textFieldRemitente.getText());
        if(!textFieldPalabra.getText().isEmpty())
            e2 = mailManagerBO.getByQuery(textFieldPalabra.getText());
       
        
    }

  
    
}
