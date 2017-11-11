package parcial2.infoiii;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;
import parcial2.infoiii.Context;
import parcial2.infoiii.business.MailManager;
import parcial2.infoiii.model.Email;

/**
 *
 * @author alumno
 */
public class Test {

    static private MailManager mm;
    static private ArrayList<Email> mails;
    private Email[] tmp1, tmp2;
    private long stopTime;
    private long startTime;

    // @BeforeAll
    void load() {
        mails = loadMails();
    }

    // @BeforeEach
    void setUp() {
        mm = new MailManager();
        for (Email m : mails) {
            try {
                mm.addMail(m);
            } catch (Exception ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    // @AfterEach
    void showBenchmark() {
        float time = (stopTime - startTime);
        time /= 1000000;
        System.out.println("Tardó: " + time + "ms");
    }

    // @Test
    void pruebaAgregado() throws Exception {
        startTime = System.nanoTime();
        mm = new MailManager();
        for (Email m : mails) {
            mm.addMail(m);
        }
        stopTime = System.nanoTime();
    }

    // @Test
    void pruebaMostrarPorFecha() throws Exception {
        startTime = System.nanoTime();
        tmp1 = mm.getSortedByDate();
        stopTime = System.nanoTime();

        if (6517 != tmp1.length) {
            System.out.println("No devolvió todos los mails esperados");
        }

        if (tmp1.length == 6517) {
            if ("2017-10-27 17:50".compareTo(tmp1[0].getDate()) != 0
                    && "2010-02-01 14:46".compareTo(tmp1[0].getDate()) != 0) {
                System.out.println("No está el mail mas nuevo");
            }
        }
        if (tmp1.length > 0) {
            if ("2017-10-27 17:50".compareTo(tmp1[6516].getDate()) != 0
                    && "2010-02-01 14:46".compareTo(tmp1[6516].getDate()) != 0) {
                System.out.println("No está el mail mas viejo");
            }
        }
    }

    //  @Test
    void pruebaMostrarPorRemitente() throws Exception {
        startTime = System.nanoTime();
        tmp1 = mm.getSortedByFrom();
        stopTime = System.nanoTime();

        if (6517 != tmp1.length) {
            System.out.println("No devolvió todos los mails esperados");
        }
        if (tmp1.length == 6517) {
            if ("yomatiascalde---@gmail.com".compareTo(tmp1[6516].getFrom()) != 0) {
                System.out.println("No está el ultimo remitente");
            }
        }
        if (tmp1.length > 0) {
            if ("---@criterionet.com".compareTo(tmp1[0].getFrom()) != 0
                    && "14puer---@gmail.com".compareTo(tmp1[0].getFrom()) != 0) {
                System.out.println("No está el primer remitente");
            }
        }
    }

    //  @Test
    void pruebaMostrarPorRangoFecha() throws Exception {
        startTime = System.nanoTime();
        tmp1 = mm.getSortedByDate("2011-07-25 17:10", "2013-09-24 00:10");
        stopTime = System.nanoTime();

        if (tmp1.length < 5) {
            System.out.println("No devolvió todos los mails esperados");
        }

        if ("2011-07-25 17:21".compareTo(tmp1[0].getFrom()) != 0
                && "2013-09-24 00:09".compareTo(tmp1[0].getFrom()) != 0) {
            System.out.println("No está el primer mail del rango");
        }

        if ("2013-09-24 00:09".compareTo(tmp1[tmp1.length - 1].getFrom()) != 0
                && "2011-07-25 17:21".compareTo(tmp1[tmp1.length - 1].getFrom()) != 0) {
            System.out.println("No está el ultimo mail del rango");
        }
    }

    //  @Test
    void pruebaBuscarPorRemitente() {
        try{
        startTime = System.nanoTime();
        tmp1 = mm.getByFrom("alam---@gmail.com");
        stopTime = System.nanoTime();
        if (30 != tmp1.length) {
            System.out.println("Mal la cantidad de mails de alam---@gmail.com");
        }
        tmp1 = mm.getByFrom("ramonreta---@gmail.com");
        if (38 != tmp1.length) {
            System.out.println("Mal la cantidad de mails de ramonreta---@gmail.com");
        }
        tmp1 = mm.getByFrom("lru---@inti.gob.ar");
        if (49 != tmp1.length) {
            System.out.println("Mal la cantidad de mails de lru---@inti.gob.ar");
        }
        tmp1 = mm.getByFrom("franco---@gmail.com");
        if (65 != tmp1.length) {
            System.out.println("Mal la cantidad de mails de franco---@gmail.com");
        }
        tmp1 = mm.getByFrom("sebas---@gmail.com");
        if (355 != tmp1.length) {
            System.out.println("Mal la cantidad de mails de sebas---@gmail.com");
        }
        }catch(Exception e){
            
        }

    }

    //  @Test
    void pruebaByQuery() throws Exception {
        ArrayList<Pair<String, Integer>> palabras = new ArrayList<Pair<String, Integer>>();
        palabras.add(new Pair<>("Chau", 19));
        palabras.add(new Pair<>("compilador", 7));
        palabras.add(new Pair<>("java", 90));
        palabras.add(new Pair<>("linux", 1553));
        palabras.add(new Pair<>("debian", 493));
        palabras.add(new Pair<>("ubuntu", 1380));
        palabras.add(new Pair<>("kde", 43));
        palabras.add(new Pair<>("Hola grupo como estan", 3));

        startTime = System.nanoTime();
        tmp1 = mm.getByQuery("Hola");
        stopTime = System.nanoTime();

        System.out.println("Hola: " + tmp1.length); // 1794
        if (1794 != tmp1.length) {
            System.out.println("Cantidad distinta de resultados para Hola");
        }

        for (Pair<String, Integer> p : palabras) {
            tmp1 = mm.getByQuery(p.getKey());
            System.out.println(p.getKey() + ": " + tmp1.length);
            if (p.getValue().intValue() != tmp1.length) {
                System.out.println("Cantidad distinta de resultados para " + p.getKey());
            }
        }
    }

    //  @Test
    void pruebaBorrar() throws Exception {
        int old;
        tmp1 = mm.getByQuery("Hola");

        startTime = System.nanoTime();
        if (1794 != tmp1.length) {
            System.out.println("Cantidad distinta de resultados para Hola");
        }
        old = tmp1.length;
        
        for (int i = 0; i < 300; i++) {
            mm.deleteMail(tmp1[i].getId());
        }
        stopTime = System.nanoTime();
        tmp1 = mm.getByQuery("Hola");
        System.out.println("Borrados de Hola: " + tmp1.length); // 1794
        if (old - 300 != tmp1.length) {
            System.out.println("No se borraron todos los mails con Hola");
        }
    }

    public ArrayList<Email> loadMails() {
        String aux = null;
        String line = null;
        String[] campos = null;
        Email mail = null;
        ArrayList<Email> ret = new ArrayList<>();
        String direccion = Context.op;

        try {
            FileReader in = new FileReader(direccion);
            BufferedReader buf = new BufferedReader(in);

            while ((line = buf.readLine()) != null) {
                // proceso estructura del archivo
                campos = line.split(":", 2);
                //System.out.println(line);

                if (campos.length > 0) {
                    switch (campos[0]) {
                        case "-.-.-":
                            if (mail != null) {
                                ret.add(mail);
                            }
                            mail = new Email();
                            mail.setContent("");
                            break;
                        case "date":
                            mail.setDate(campos[1].trim());
                            break;
                        case "from":
                            mail.setFrom(campos[1].trim());
                            break;
                        case "to":
                            mail.setTo(campos[1].trim());
                            break;
                        case "subject":
                            mail.setSubject(campos[1].trim());
                            break;
                        default:

                            mail.setContent(mail.getContent() + line + "\n");
                            break;
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }
}
