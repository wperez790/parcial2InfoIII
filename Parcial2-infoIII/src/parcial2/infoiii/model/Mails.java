/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial2.infoiii.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author walt
 */
public class Mails {
    
    private StringProperty from;
    private StringProperty to;
    private StringProperty date;
    private ObjectProperty<Email> email;
    
    public Mails(){
        this(null,null,null,null);
    }
    
    public Mails(String from, String to, String date, Email email ){
        this.from = new SimpleStringProperty(from);
        this.to = new SimpleStringProperty(to);
        this.date = new SimpleStringProperty(date);
        this.email = new SimpleObjectProperty<Email>(email);
    }

    public StringProperty getFrom() {
        return from;
    }

    public void setFrom(StringProperty from) {
        this.from = from;
    }

    public StringProperty getTo() {
        return to;
    }

    public void setTo(StringProperty to) {
        this.to = to;
    }

    public StringProperty getDate() {
        return date;
    }

    public void setDate(StringProperty date) {
        this.date = date;
    }

    public ObjectProperty<Email> getEmail() {
        return email;
    }

    public void setEmail(ObjectProperty<Email> email) {
        this.email = email;
    }
    
}
