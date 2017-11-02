package parcial2.infoiii.business;

import java.util.Date;
import parcial2.infoiii.Context;
import parcial2.infoiii.model.Email;
import parcial2.infoiii.model.Lista;

public class MailManager{
    /**
     * Agrega un mail al gestor
     *
     * @param m mail a agregar
     */
    public void addMail(Email m) throws Exception{
        
        Context.avlTreeFrom.insertByFrom(m);
        Context.avlTreeDate.insertByDate(m);
        Context.hashAvlTree.put(m.getSubject(),m);
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
    public void getSortedByDate(){
        Context.avlTreeDate.getSorted();
    }

    /**
     * Devuelve una lista de mails oredenados por fecha que estan en el rango
     * desde - hasta
     *
     * @param desde Fecha desde donde buscar
     * @param hasta Fecha hasta donde buscar
     * @return lista de mails ordenados
     */
    public void getSortedByDate(String desde, String hasta){
        Context.avlTreeDate.getSortedByDate(desde,hasta);
    }

    /**
     * Devuelve una lista de mails ordenados por Remitente
     *
     * @return lista de mails ordenados
     */
    public void getSortedByFrom(){
        Context.avlTreeFrom.getSorted();
    }
    /**
     * Devuelve una lista de mails de un determinado remitente
     *
     * @param from String con direccion del remitente
     * @return lista de mails del remitente
     */
    public void getByFrom(String from){
        Context.avlTreeFrom.getByFrom(from);
    }
    /**
     * Devuelve una lista de mails que contengan las palabras de 'query'
     * en su asunto o en su contenido
     *
     * @param query String con palabra/s a buscar
     * @return lista de mails que contienen dicha/s palabra/s
     */
    public Email[] getByQuery(String query){
        return new Email[0];
    }
}
