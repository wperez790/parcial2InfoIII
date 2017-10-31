package parcial2.infoiii.model;



/**
 * Clase con los datos de un email. Puede tener mas propiedades o metodos
 */
public class Email <T extends Comparable>{

    private long id;
    private String from;
    private String to;
    private String date;
    private String subject;
    private String content;
}
