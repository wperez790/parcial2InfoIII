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
import parcial2.infoiii.Context;
import parcial2.infoiii.business.MailManager;
import parcial2.infoiii.model.Email;

/**
 * FXML Controller class
 *
 * @author walt
 */
public class PanelOrdenarController implements Initializable {

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
    //AUXILIARES
    MailManager mailManagerBO;
    @FXML
    private JFXButton btnVer;
    @FXML
    private JFXButton btnBack;
    //
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnBuscarAction(ActionEvent event) {
        Email[] e1;
        Email[] e2;
        Email[] e3;
        if(!textFieldRemitente.getText().isEmpty())
            e1= mailManagerBO.getSortedByFrom();
        /*Si Desde y Hasta estan completados*/
        if(datePickerDesde.getEditor().getText() !=null && datePickerHasta.getEditor().getText()!=null)
            e2 = mailManagerBO.getSortedByDate(desde, hasta);
        /*Si solo Desde esta completado*/
        if(datePickerDesde.getEditor().getText() !=null && datePickerHasta.getEditor().getText()==null)
            e3 = mailManagerBO.getSortedByDate(desde, hasta);
        /**/
        /*Si solo Hasta esta completado*/
        if(datePickerDesde.getEditor().getText() ==null && datePickerHasta.getEditor().getText()!=null)
            e3 = mailManagerBO.getSortedByDate(desde, hasta);
        /**/
        /*Si Fecha en particular esta completado*/
        if(datePickerFecha.getEditor().getText() !=null)
            e2 = mailManagerBO.getSortedByDate(fecha);
        /**/
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
    
}
