/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unmsm.sistemas.sgpy.Hitos.Service;

import java.util.Calendar;
import javax.swing.SwingWorker;

/**
 *
 * @author Axel
 */
public class EmailServiceObserver extends SwingWorker<Void, Void> {
    private boolean activada;
    private static EmailServiceObserver email_observer;
    
    private EmailServiceObserver(){
        
    }
    
    public static EmailServiceObserver getInstance(){
        if(email_observer==null){
            email_observer=new EmailServiceObserver();
        }
        return email_observer;
    }
    
    public void ActivarAlerta(){
        activada=true;
    }
    
    void enviarAlerta(){
         EmailSend es=new EmailSend();
         //example@gmail.com es el correo al que se envia el mail , se modificara cuando unamos las tablas
         es.sendMail("empresabd2@gmail.com","proyecto123",edu.unmsm.sistemas.sgpy.Principal.DatosConexionPrincipal.CORREO_PROFE,"Alerta de hito","Debe ponerse las pilas o jalara el curso :(");
         //duerme 24 horas
         //Thread.sleep(86400000);
    }
    
    public void DesactivarAlerta(){
        activada=false;
    }

    @Override
    protected Void doInBackground() throws Exception {
          while(activada && (!isDone())){
              enviarAlerta();
              Thread.sleep(86400000);
          }
          
          if(isCancelled()){
              DesactivarAlerta();
          }
          
          return null;
    }
}
