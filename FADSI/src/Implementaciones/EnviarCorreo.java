/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementaciones;

/**
 *
 * @author Ricardo Araya
 */
import java.util.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.search.FlagTerm;

public class EnviarCorreo extends Thread {

String miCorreo="fadsitec@gmail.com";
        String miContraseña="FFFfff123";
        String servidorSMTP = "smtp.gmail.com";
        String puertoEnvio = "465";
        String mailReceptor;
        String asunto="FADSI";
        String cuerpo="HOLA";
        //metodo que recibe y envia el email
        public void EnviaEmail(String mailReceptor) {
            
            Properties props = new Properties();//propiedades a agragar
            props.put("mail.smtp.user", this.miCorreo);//correo origen
            props.put("mail.smtp.host", servidorSMTP);//tipo de servidor
            props.put("mail.smtp.port", puertoEnvio);//puesto de salida
            props.put("mail.smtp.starttls.enable", "true");//inicializar el servidor
            props.put("mail.smtp.auth", "true");//autentificacion
            props.put("mail.smtp.socketFactory.port", puertoEnvio);//activar el puerto
            props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.socketFactory.fallback", "false");
            SecurityManager security = System.getSecurityManager();
            try {
                Authenticator auth = new autentificadorSMTP();//autentificar el correo
                Session session = Session.getInstance(props, auth);//se inica una session
                // session.setDebug(true);
                MimeMessage msg = new MimeMessage(session);//se crea un objeto donde ira la estructura del correo
                msg.setText(this.cuerpo);//seteo el cuertpo del mensaje
                msg.setSubject(this.asunto);//setea asusto (opcional)
                msg.setFrom(new InternetAddress(this.miCorreo));//agrega la la propiedad del correo origen
                msg.addRecipient(Message.RecipientType.TO, new InternetAddress(this.mailReceptor));//agrega el destinatario
                Transport.send(msg);//envia el mensaje
                System.out.println("\"Email enviado\"");
                
            } catch (Exception mex) {//en caso de que ocurra un error se crea una excepcion
                System.out.println("\"Email no enviado\"");
                
            }//fin try-catch
        }//fin metodo enviaEmail
        private class autentificadorSMTP extends javax.mail.Authenticator {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(miCorreo, miContraseña);//autentifica tanto el correo como la contraseña
            }
        }

    public void Correo() {
        long start = System.currentTimeMillis();
        //EnviarCorreo a=new EnviarCorreo();//enviarCorreo
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");
        props.put("mail.imaps.ssl.trust", "*");
        try {
            Session session = Session.getInstance(props, null);
            Store store = session.getStore();
            System.out.println("ERROR VALIDACION");
            store.connect("imap.gmail.com", "fadsitec@gmail.com", "FFFfff123");
            System.out.println("VALIDACION");
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_WRITE);

            // search for all "unseen" messages
            Flags seen = new Flags(Flags.Flag.SEEN);
            FlagTerm unseenFlagTerm = new FlagTerm(seen, false);
            Message messages[] = inbox.search(unseenFlagTerm);

            if (messages.length == 0) {
                System.out.println("No hay mensajes nuevos");
            }

            for (int i = 0; i < messages.length; i++) {
                // stop after listing ten messages
                if (i > 10) {
                    System.exit(0);
                    inbox.close(true);
                    store.close();
                }

                Multipart mp = (Multipart) messages[i].getContent();
                BodyPart bp = mp.getBodyPart(0);
                System.out.println("Message " + (i + 1));
                System.out.println("From : " + messages[i].getFrom()[0]);
                System.out.println("Subject : " + messages[i].getSubject());
                System.out.println("Sent Date : " + messages[i].getSentDate());
                System.out.println("Content:" + bp.getContent());
                Address usuario = messages[i].getFrom()[0];
                System.out.println(usuario);
                //EnviarMail(usuario);
                System.out.println(i);
                if (i < 1) {
                    i++;
                    inbox.getMessage(i).getContent();//lee el mensaje y lo marca como leido
                    i--;
                } else {
                    inbox.getMessage(i).getContent();//lee el mensaje y lo marca como leido
                }
                //inbox.close(false)
                //inbox.setFlags(new Message[]{messages[i]}, new Flags(Flags.Flag.SEEN), true);

            }

            inbox.close(true);
            store.close();

            /**
             * Message msg = inbox.getMessage(inbox.getMessageCount());
             * Address[] in = msg.getFrom(); for (Address address : in) {
             * System.out.println("FROM:" + address.toString()); } Multipart mp
             * = (Multipart) msg.getContent(); BodyPart bp = mp.getBodyPart(0);
             * System.out.println("SENT DATE:" + msg.getSentDate());
             * System.out.println("SUBJECT:" + msg.getSubject());
             * System.out.println("CONTENT:" + bp.getContent());
             * //System.out.println("CONTENT:" + msg.getNewMessageCount());*
             */
        } catch (Exception mex) {
            mex.printStackTrace();
        }
        long end = System.currentTimeMillis();
        long rest = end - start;
        System.out.println("segundos" + rest / 1000);
    }
}
