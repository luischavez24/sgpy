/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.Hitos.Service;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author Axel
 */
public class EmailSend {
    public void sendMail(String email,String password,String emailFrom,String asunto,String mensaje){
        try
        {
            // Propiedades de la conexión
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.put("mail.smtp.EnableSSL.enable","true");
            props.setProperty("mail.smtp.auth", "true");

            // Preparamos la sesion
            Session session;
            session=Session.getDefaultInstance(props);
            // Construimos el mensaje
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(emailFrom));
            message.setSubject(asunto);
            message.setText(mensaje);

            // Lo enviamos.
            Transport t = session.getTransport("smtp");
            t.connect(email, password);
            t.sendMessage(message, message.getAllRecipients());
            // Cierre.
            t.close();
            
            JOptionPane.showMessageDialog(null, "Mensaje Enviado con exito");
        }
        catch (MessagingException e)
        {
            System.out.println(e.toString());
        }
    }
}
