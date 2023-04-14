/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.socket_tcp_practica;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class HiloCliente extends Thread{
    Socket sc ; 
    DataInputStream input; 
    
    private static ArrayList listeners;
    
    public HiloCliente(Socket sc) {   
            this.sc = sc;
            listeners = new ArrayList();
    }
     public void addEventListener(MensajeEventListener listener) {
        listeners.add(listener);
    }
     
     private void triggerClienteMensajesEvent(Socket sc,String mensaje) {
 
        ListIterator li = listeners.listIterator();
        while (li.hasNext()) {
            MensajeEventListener listener = (MensajeEventListener) li.next();
            MensajeEvent readerEvObj = new MensajeEvent(this,this,mensaje);
            (listener).onClienteMensajeChange(readerEvObj);
        }
    }  
    
    @Override    
    public void run(){
        
            //Aqui creas los buffers de entrada salida y aqui los finalizas cuando dejes de usarlos.
            //y cada hilo ejecutara su run() para cada cliente que se conecte.
           
                try { 
                    while(true){
                    this.input = new DataInputStream(this.sc.getInputStream()); 
                       String mensaje = this.input.readUTF();
                       this.triggerClienteMensajesEvent(sc, mensaje);
                       System.out.println("cliente "+sc.getPort()+": "+mensaje);
                       System.out.println("_______________________________________________________________________");
                       
                      
                    }
                } catch (IOException ex) {
                    Logger.getLogger(HiloCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            
       
    }
        
}
