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
import Interfaz.Pprincipal;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.search.FlagTerm;

public class EnviarCorreo extends Thread {

    public void EnviarMail(Address usuario) {
        final String username = "fadsitec@gmail.com";
        final String password = "FFFfff123";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("FADSI"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(usuario.toString()));
            message.setSubject("FADSI");
            message.setText("Su orden esta siendo procesada,por favor espere!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public void Correo() {
        long start = System.currentTimeMillis();
        //EnviarCorreo a=new EnviarCorreo();//enviarCorreo
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");
        try {
            Session session = Session.getInstance(props, null);
            Store store = session.getStore();
            store.connect("imap.gmail.com", "fadsitec@gmail.com", "FFFfff123");
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
                System.out.println("Sent Date : "
                        + messages[i].getSentDate());
                System.out.println("Content:" + bp.getContent());

                Address usuario = messages[i].getFrom()[0];
                System.out.println(usuario);
                EnviarMail(usuario);
                System.out.println(i);
                if (i < 1) {
                    i++;
                    inbox.getMessage(i).getContent();//lee el mensaje y lo marca como leido
                    i--;
                } else {
                    inbox.getMessage(i).getContent();//lee el mensaje y lo marca como leido
                }

                int cuenta = 0;
                char inicia = ':';
                char fin = '\n';
                boolean flag = true;
                boolean flag1 = false;
                boolean flag2 = false;
                String Cliente = "";
                String Recibe = "";
                String Entrega = "";
                String Mensaje = String.valueOf(bp.getContent());
                char[] Mensaje1 = Mensaje.toCharArray();
                while (cuenta < Mensaje1.length) {
                    if (flag) {
                        if (Mensaje1[cuenta] == inicia) {
                            cuenta+=1;
                            while (Mensaje1[cuenta] != fin) {
                                Cliente += Mensaje1[cuenta];
                                cuenta++;
                            }
                            flag = false;
                            flag1=true;
                        }
                    }
                    if (flag1) {
                        if (Mensaje1[cuenta] == inicia) {
                            cuenta+=1;
                            while (Mensaje1[cuenta] != fin) {
                                Recibe += Mensaje1[cuenta];
                                cuenta++;
                            }
                            flag2=true;
                            flag1=false;
                            
                        }
                    }
                    if (flag2) {
                        if (Mensaje1[cuenta] == inicia) {
                            cuenta+=+1;
                            while (Mensaje1[cuenta] != fin) {
                                Entrega += Mensaje1[cuenta];
                                cuenta++;
                            }
                            break;
                        }
                    }
                    cuenta++;
                }
                Pprincipal Admi = new Pprincipal();
                Pedidos pedi = new Pedidos(Cliente,Recibe,Entrega);
                Admi.EntraPedidos.add(pedi);
                

                //inbox.close(false)
                //inbox.setFlags(new Message[]{messages[i]}, new Flags(Flags.Flag.SEEN), true);
            }

            inbox.close(true);
            store.close();

        } catch (Exception mex) {
            mex.printStackTrace();
        }
        long end = System.currentTimeMillis();
        long rest = end - start;
        System.out.println("segundos" + rest / 1000);
    }
}
