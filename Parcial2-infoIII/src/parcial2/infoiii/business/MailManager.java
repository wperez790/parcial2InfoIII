package parcial2.infoiii.business;

import java.util.Date;
import parcial2.infoiii.Context;
import parcial2.infoiii.model.Email;
import parcial2.infoiii.model.Lista;
import parcial2.infoiii.model.NodeList;

public class MailManager{
    /**
     * Agrega un mail al gestor
     *
     * @param m mail a agregar
     */
    public void addMail(Email m) throws Exception{
        
        Context.avlTreeFrom.insertByFrom(m);
        Context.avlTreeDate.insertByDate(m);
        Context.hashAvlTree.splitString(m.getSubject(),m,true);
        Context.hashAvlTree.splitString(m.getContent(),m,false);
        
    }

    /**
     * Elimina un mail del gestor
     *
     * @param id identificador del mail a borrar
     */
    public void deleteMail(long id){

    }

    /**
     * Devuelve una lista de mails ordenados por fecha
     *
     * @return lista de mails ordenados
     */
    public Email[] getSortedByDate(){
                
        Context.avlTreeDate.getSorted(Context.list);
        Email email[] = new Email[Context.list.getTamanio()];
        NodeList aux = Context.list.getInicio();
        int i = 0;
        while (aux.getNext() != null) {
            email[i] = aux.getDato();
            aux = aux.getNext();
            i++;
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
    public Email[] getSortedByDate(String desde, String hasta){
        
        Context.avlTreeDate.getSortedByDate(desde,hasta,Context.list);
        Email email[] = new Email[Context.list.getTamanio()];
        NodeList aux = Context.list.getInicio();
        int i = 0;
        while (aux.getNext() != null) {
            email[i] = aux.getDato();
            aux = aux.getNext();
            i++;
        }         
        return email;
    }

    /**
     * Devuelve una lista de mails ordenados por Remitente
     *
     * @return lista de mails ordenados
     */
    public Email[] getSortedByFrom(){
        
        Context.avlTreeFrom.getSorted(Context.list);
        Email email[] = new Email[Context.list.getTamanio()];
        NodeList aux = Context.list.getInicio();
        int i = 0;
        while (aux.getNext() != null) {
            email[i] = aux.getDato();
            aux = aux.getNext();
            i++;
        }         
        return email;
    }
    /**
     * Devuelve una lista de mails de un determinado remitente
     *
     * @param from String con direccion del remitente
     * @return lista de mails del remitente
     */
    public Email[] getByFrom(String from){
                
        Context.avlTreeFrom.getByFrom(from,Context.list);        
        Email email[] = new Email[Context.list.getTamanio()];
        NodeList aux = Context.list.getInicio();
        int i = 0;
        while (aux.getNext() != null) {
            email[i] = aux.getDato();
            aux = aux.getNext();
            i++;
        }         
        return email;
    }
    /**
     * Devuelve una lista de mails que contengan las palabras de 'query'
     * en su asunto o en su contenido
     *
     * @param query String con palabra/s a buscar
     * @return lista de mails que contienen dicha/s palabra/s
     */
    public Email[] getByQuery(String query) throws Exception{
        
        Context.list = Context.hashAvlTree.getByQuery(query);
        Email email[] = new Email[Context.list.getTamanio()];
        NodeList aux = Context.list.getInicio();
        int i = 0;
        while (aux.getNext() != null) {
            email[i] = aux.getDato();
            aux = aux.getNext();
            i++;
        }         
        return email;
    }
     public String splitDate(String notSplited){
         String[] splited = notSplited.split("/");
         String aux = null;
         for(int i = splited.length-1; i<=0 ; i--)
             aux+=splited[i]+"-";
         aux+=" 00:00:00";
         return aux;
     }
}
