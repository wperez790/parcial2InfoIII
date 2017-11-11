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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import parcial2.infoiii.Context;
import parcial2.infoiii.business.MailManager;
import parcial2.infoiii.model.AVLTree;
import parcial2.infoiii.model.Email;
import parcial2.infoiii.model.Lista;
import parcial2.infoiii.model.Mails;

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
    MailManager mailManagerBO = new MailManager();
    ObservableList<Mails> mailsData = FXCollections.observableArrayList();
    //
    @FXML
    private TableView<Mails> tableMailsSearch;
    @FXML
    private TableColumn<Mails, String> fromColumn;
    @FXML
    private TableColumn<Mails, String> toColumn;
    @FXML
    private TableColumn<Mails, String> dateColumn;
    @FXML
    private TableColumn<Mails, String> idColumn;

    //
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fromColumn.setCellValueFactory(cellData -> cellData.getValue().getFrom());
        toColumn.setCellValueFactory(cellData -> cellData.getValue().getTo());
        dateColumn.setCellValueFactory(cellData -> cellData.getValue().getDate());
        /*        idColumn.setCellValueFactory(cellData -> cellData.getValue().getId());*/

    }

    @FXML
    private void btnVerAction(ActionEvent event) {
        
        Context.email = tableMailsSearch.getSelectionModel().getSelectedItem().getEmail().getValue();
        Context.abrirEmail();
      
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
        Email e1[] = null;    //Manejo por Remitente
        Email e2[] = null;   //Manejo por Palabras
        Email e3[] = null;  //Manejo por Fechas
        Context.list = new Lista();
        String desde= datePickerDesde.getEditor().getText();
        String hasta = datePickerHasta.getEditor().getText();
        String fecha= datePickerFecha.getEditor().getText();
        mailsData.clear();
        tableMailsSearch.setItems(mailsData);        //Seteo la tabla en blanco al presionar el boton nuevamente
        
        if (!textFieldRemitente.getText().isEmpty()) { //Si el campo Remitente no esta vacio realizo la busqueda
            e1 = mailManagerBO.getByFrom(textFieldRemitente.getText());
            for (int i = 0; i < e1.length; i++) {
                mailsData.add(new Mails(e1[i].getFrom(), e1[i].getTo(), e1[i].getDate(), e1[i]));   //Agrego datos que necesito al objeto ObservableList de la tabla
            }
        }
        if (!textFieldPalabra.getText().isEmpty()) {   //Si el campo Palabra no esta vacio Realizo la busqueda
            e2 = mailManagerBO.getByQuery(textFieldPalabra.getText());
            for (int i = 0; i < e2.length; i++) {
                mailsData.add(new Mails(e2[i].getFrom(), e2[i].getTo(), e2[i].getDate(), e2[i]));
            }
        }
        /*Si Desde y Hasta estan completados*/
        if(!desde.isEmpty() && !hasta.isEmpty())
        {
             e3 = mailManagerBO.getSortedByDate(mailManagerBO.splitDate(desde,false), mailManagerBO.splitDate(hasta,true));
             
             for (int i = 0; i < e3.length; i++) {
                mailsData.add(new Mails(e3[i].getFrom(), e3[i].getTo(), e3[i].getDate(), e3[i]));
            }
            
        }
        /**/
        /*Si solo Desde esta completado*/
        else if(!desde.isEmpty() && hasta.isEmpty()){
             e3 = mailManagerBO.getSortedByDate(mailManagerBO.splitDate(desde,false), null);
             
             for (int i = 0; i < e3.length; i++) {
                mailsData.add(new Mails(e3[i].getFrom(), e3[i].getTo(), e3[i].getDate(), e3[i]));
            }
        }
        /**/
        /*Si solo Hasta esta completado*/
        else if(desde.isEmpty() && !hasta.isEmpty()){
            e3 = mailManagerBO.getSortedByDate(null , mailManagerBO.splitDate(hasta,true));
            
            for (int i = 0; i < e3.length; i++) {
                mailsData.add(new Mails(e3[i].getFrom(), e3[i].getTo(), e3[i].getDate(), e3[i]));
            }
        }
        /**/
        /*Si Fecha esta completado*/
        else if(!datePickerFecha.getEditor().getText().isEmpty()){
            e3 = mailManagerBO.getSortedByDate(mailManagerBO.splitDate(fecha,false),mailManagerBO.splitDate(fecha, true));
              for (int i = 0; i < e3.length; i++) {
                mailsData.add(new Mails(e3[i].getFrom(), e3[i].getTo(), e3[i].getDate(), e3[i]));
            }
            
        }
        /**/
        tableMailsSearch.setItems(mailsData);

        /*        for(int i = 0; i<e1.length; i++){
        
        }*/
    }

}
