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
import javafx.fxml.Initializable;
import parcial2.infoiii.Context;
import parcial2.infoiii.business.MailManager;
import parcial2.infoiii.business.MailManagerTest;

/**
 * FXML Controller class
 *
 * @author walt
 */
public class PanelAgregarController implements Initializable {

    @FXML
    private JFXButton btn2;
    @FXML
    private JFXButton btn201;
    @FXML
    private JFXButton btn100;
    @FXML
    private JFXButton btn1000;
    @FXML
    private JFXButton btn3001;
    //AUX
    MailManagerTest mmt = new MailManagerTest();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
  
    }    

    @FXML
    private void btn2Action(ActionEvent event) throws Exception {
        Context.op = "mails-2.txt";
        mmt.addMail();
        
            
    }

    @FXML
    private void btn20Action(ActionEvent event) throws Exception {
        Context.op = "mails-20.txt";
        mmt.addMail();
        
    }

    @FXML
    private void btn100Action(ActionEvent event) throws Exception {
        Context.op = "mails-100.txt";
        mmt.addMail();
        
    }

    @FXML
    private void btn1000Action(ActionEvent event) throws Exception {
        Context.op = "mails-1000.txt";
        mmt.addMail();
    }

    @FXML
    private void btn3001Action(ActionEvent event) throws Exception {
        Context.op = "mails-3001.txt";
        mmt.addMail();
    }
    
}
