package parcial2.infoiii.business;

import java.util.Date;
import parcial2.infoiii.Context;
import parcial2.infoiii.model.AVLTree;
import parcial2.infoiii.model.Email;
import parcial2.infoiii.model.Lista;
import parcial2.infoiii.model.NodeList;

public class MailManager {

    /**
     * Agrega un mail al gestor
     *
     * @param m mail a agregar
     */
    public void addMail(Email m) throws Exception {
        Context.avlTreeID.insertByID(m);                            //Inserta mails en un AVL ordenado por ID
        Context.avlTreeFrom.insertByFrom(m);                        //Inserta mails en un AVL ordenado por Remitente
        Context.avlTreeDate.insertByDate(m);                        //Inserta mails en un AVL ordenado por Fecha
        Context.hashAvlTree.splitString(m.getSubject(), m, true);   //Separa las palabras del subject y las agrega en la Tabla Hash de AVLs
        Context.hashAvlTree.splitString(m.getContent(), m, false);  //Separa las palabras del content y las agrega en la Tabla Hash de AVLs
    }

    /**
     * Elimina un mail del gestor
     *
     * @param id identificador del mail a borrar
     */
    public void deleteMail(long id) throws Exception {
        Email e= Context.avlTreeID.delete(id);
        Context.avlTreeDate.deleteByDate(e.getDate());
        Context.avlTreeFrom.deleteByFrom(e.getFrom());
       // Context.hashAvlTree.delete(e.getId(),e);
    }

    /**
     * Devuelve una lista de mails ordenados por fecha
     *
     * @return lista de mails ordenados
     */
    public Email[] getSortedByDate() throws Exception {

        Context.avlTreeDate.getSorted();
        Email email[] = new Email[Context.list.getTamanio()];
        NodeList aux = Context.list.getInicio();
        int i = 0;
        /*      while (aux != null) {
        email[i] = aux.getDato();
        aux = aux.getNext();
        i++;
        }*/
        for (i = 0; i < Context.list.getTamanio(); i++) {
            email[i] = aux.getDato();
            aux = aux.getNext();
        }
        return email;
    }

    /**
     * Devuelve una lista de mails oredenados por fecha que estan en el rango
     * desde - hasta
     *
     * @param desde Fecha desde donde buscar
     * @param hasta Fecha hasta donde buscar
     * @return lista de mails ordenados
     */
    public Email[] getSortedByDate(String desde, String hasta) throws Exception {
        if(desde==null)
            Context.avlTreeDate.getSortedByDateTo(hasta);
        else if(hasta == null)
            Context.avlTreeDate.getSortedByDateFrom(desde);
        else{
            Context.avlTreeDate.getSortedByDate(desde, hasta);
        }
        Email email[] = new Email[Context.list.getTamanio()];
        NodeList aux = Context.list.getInicio();
        int i = 0;
        /*        while (aux != null) {
        email[i] = aux.getDato();
        aux = aux.getNext();
        i++;
        }*/
        for (i = 0; i < Context.list.getTamanio(); i++) {
            email[i] = aux.getDato();
            aux = aux.getNext();
        }
        return email;
    }

    /**
     * Devuelve una lista de mails ordenados por Remitente
     *
     * @return lista de mails ordenados
     */
    public Email[] getSortedByFrom() throws Exception {
        Context.avlTreeFrom.getSorted();
        Email email[] = new Email[Context.list.getTamanio()];
        Lista aux2 = Context.list;
        NodeList aux = Context.list.getInicio();
        int i = 0;
        /*        while (aux != null) {
        email[i] = aux.getDato();
        aux = aux.getNext();
        i++;
        }*/
        for (i = 0; i < Context.list.getTamanio(); i++) {
            email[i] = aux.getDato();
            aux = aux.getNext();
        }

        return email;
    }

    /**
     * Devuelve una lista de mails de un determinado remitente
     *
     * @param from String con direccion del remitente
     * @return lista de mails del remitente
     */
    public Email[] getByFrom(String from) throws Exception {

        Context.list = Context.avlTreeFrom.getByFrom(from);
        Email email[] = new Email[Context.list.getTamanio()];
        NodeList aux = Context.list.getInicio();
        int i = 0;
        /*       while (aux != null) {
        email[i] = aux.getDato();
        aux = aux.getNext();
        i++;
        }*/
        for (i = 0; i < Context.list.getTamanio(); i++) {
            email[i] = aux.getDato();
            aux = aux.getNext();
        }
        return email;
    }

    /**
     * Devuelve una lista de mails que contengan las palabras de 'query' en su
     * asunto o en su contenido
     *
     * @param query String con palabra/s a buscar
     * @return lista de mails que contienen dicha/s palabra/s
     */
    public Email[] getByQuery(String query) throws Exception {

        Context.list = Context.hashAvlTree.getByQuery(query);
        Email email[] = new Email[Context.list.getTamanio()];
        NodeList aux = Context.list.getInicio();
        int i = 0;
        /*      while (aux != null) {
        email[i] = aux.getDato();
        aux = aux.getNext();
        i++;
        }*/

        for (i = 0; i < Context.list.getTamanio(); i++) {
            email[i] = aux.getDato();
            aux = aux.getNext();
        }
        return email;
    }

    public String splitDate(String notSplited, boolean night) {
        String[] splited = notSplited.split("/");
        String aux = "";
        /*aux += splited[2]+"-";
        if(Integer.parseInt(splited[0])<10)    //DatePicker al mes lo pone sin 0, esto corrije el problema
        aux += "0"+splited[0]+"-";
        else
        aux += splited[0]+"-";
        aux += splited[1];*/
        for (int i = splited.length - 1; i > 0; i--) {
            aux += splited[i] + "-";
        }
        aux += splited[0] + " ";
        if (night == false) {
            aux += "00:00";
        } else {
            aux += "23:59";
        }
        return aux;
    }

}
