package parcial2.infoiii.business;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import parcial2.infoiii.Context;
import parcial2.infoiii.model.Email;

public class MailManagerTest {

    private MailManager mm = new MailManager();

    public void setUp() {
        mm = new MailManager();
    }

    public void addMail() throws Exception {
        int i = 0;
        ArrayList<Email> mails = loadMails();
        for (Email m : mails) {
            mm.addMail(m);
            if (i++ % 100 == 0) {
                System.out.println(i);
            }
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
                            mail.setId(Context.id++);
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
