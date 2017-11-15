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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import parcial2.infoiii.Context;
import parcial2.infoiii.business.MailManager;
import parcial2.infoiii.model.Email;
import parcial2.infoiii.model.Lista;
import parcial2.infoiii.model.Mails;

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
    private JFXTextField textFieldRemitente;
    @FXML
    private JFXButton btnBuscar;
    @FXML
    private JFXButton btnVer;
    @FXML
    private JFXButton btnBack;
    @FXML
    private TableView<Mails> tableOrdenar;

    //AUXILIARES
    MailManager mailManagerBO = new MailManager();
    ObservableList<Mails> mailsData = FXCollections.observableArrayList();
    //
    @FXML
    private TableColumn<Mails, String> fromColumn;
    @FXML
    private TableColumn<Mails, String> toColumn;
    @FXML
    private TableColumn<Mails, String> dateColumn;
    @FXML
    private TableColumn<Mails, String> idColumn;
    @FXML
    private JFXButton btnRemitente;
    @FXML
    private JFXButton btnOrdenarFecha;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fromColumn.setCellValueFactory(cellData -> cellData.getValue().getFrom());
        toColumn.setCellValueFactory(cellData -> cellData.getValue().getTo());
        dateColumn.setCellValueFactory(cellData -> cellData.getValue().getDate());
        idColumn.setCellValueFactory(cellData -> cellData.getValue().getId());
    }

    @FXML
    private void btnBuscarAction(ActionEvent event) throws Exception {
        Email[] e1;
        Email[] e2;
        Email[] e3;
        String desde = datePickerDesde.getEditor().getText();
        String hasta = datePickerHasta.getEditor().getText();
        String fecha = datePickerFecha.getEditor().getText();
        mailsData.clear();
        tableOrdenar.setItems(mailsData);        //Seteo la tabla en blanco al presionar el boton nuevamente
        /*Si Desde y Hasta estan completados*/
        if (!desde.isEmpty() && !hasta.isEmpty()) {
            e3 = mailManagerBO.getSortedByDate(mailManagerBO.splitDate(desde, false), mailManagerBO.splitDate(hasta, true));

            for (int i = 0; i < e3.length; i++) {
                mailsData.add(new Mails(e3[i].getFrom(), e3[i].getTo(), e3[i].getDate(), e3[i], e3[i].getId()));
            }

        } /**/ /*Si solo Desde esta completado*/ else if (!desde.isEmpty() && hasta.isEmpty()) {
            e3 = mailManagerBO.getSortedByDate(mailManagerBO.splitDate(desde, false), null);

            for (int i = 0; i < e3.length; i++) {
                mailsData.add(new Mails(e3[i].getFrom(), e3[i].getTo(), e3[i].getDate(), e3[i], e3[i].getId()));
            }
        } /**/ /*Si solo Hasta esta completado*/ else if (desde.isEmpty() && !hasta.isEmpty()) {
            e3 = mailManagerBO.getSortedByDate(null, mailManagerBO.splitDate(hasta, true));

            for (int i = 0; i < e3.length; i++) {
                mailsData.add(new Mails(e3[i].getFrom(), e3[i].getTo(), e3[i].getDate(), e3[i], e3[i].getId()));
            }
        } /**/ /*Si Fecha esta completado*/ else if (!datePickerFecha.getEditor().getText().isEmpty()) {
            e3 = mailManagerBO.getSortedByDate(mailManagerBO.splitDate(fecha, false), mailManagerBO.splitDate(fecha, true));
            for (int i = 0; i < e3.length; i++) {
                mailsData.add(new Mails(e3[i].getFrom(), e3[i].getTo(), e3[i].getDate(), e3[i], e3[i].getId()));
            }

        }
        /**/
        tableOrdenar.setItems(mailsData);
    }

    /*Al presionarse el boton abre el mail que corresponde*/
    @FXML
    private void btnVerAction(ActionEvent event) {

        Context.email = tableOrdenar.getSelectionModel().getSelectedItem().getEmail().getValue();
        Context.abrirEmail();
    }

    /*Vuelve atras al menu principal cargando el fxml en el contenedor Principal*/
    @FXML
    private void btnBackAction(ActionEvent event) {

        try {

            Parent root = FXMLLoader.load(getClass().getResource("/parcial2/infoiii/presentation/Menu.fxml"));
            Context.splitPane.getItems().set(0, root);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    /*Ordena por Remitente, carga en la tabla una observable list obtenida en el ordenamiento*/
    @FXML
    private void btnRemitenteAction(ActionEvent event) throws Exception {

        Email[] e1 = null;
        Context.list = new Lista();
        mailsData.clear();
        tableOrdenar.setItems(mailsData);
        e1 = mailManagerBO.getSortedByFrom();
        for (int i = 0; i < e1.length; i++) {  //Cargo en la observable list(necesaria para mostrar datos) los campos que necesito
            mailsData.add(new Mails(e1[i].getFrom(), e1[i].getTo(), e1[i].getDate(), e1[i], e1[i].getId()));
        }
        tableOrdenar.setItems(mailsData);
    }

    /*Ordena por Fecha, carga en la tabla una observable list obtenida en el ordenamiento*/
    @FXML
    private void btnOrdenarFechaAction(ActionEvent event) throws Exception {
        Email[] e1 = null;
        Context.list = new Lista();
        mailsData.clear();
        tableOrdenar.setItems(mailsData);
        e1 = mailManagerBO.getSortedByDate();
        for (int i = 0; i < e1.length; i++) { //Cargo en la observable list(necesaria para mostrar datos) los campos que necesito
            mailsData.add(new Mails(e1[i].getFrom(), e1[i].getTo(), e1[i].getDate(), e1[i],e1[i].getId()));
        }
        tableOrdenar.setItems(mailsData);
    }

}
