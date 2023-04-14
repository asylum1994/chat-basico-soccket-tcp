/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.socket_tcp_practica;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class HiloConexiones extends Thread{
    Socket sc; 
    ServerSocket server ; 
    DataOutputStream output; 
    
    private static ArrayList listeners;
    int id = 0; 
    public HiloConexiones(ServerSocket server) {
        this.server = server;
        listeners = new ArrayList(); 
    }
    
    public void addEventListener(ConexionEventListener listener) {
        listeners.add(listener);
    }
    
      
    private void triggerClienteConexionEvent(Socket sc,int id) {
 
        ListIterator li = listeners.listIterator();
        while (li.hasNext()) {
            ConexionEventListener listener = (ConexionEventListener) li.next();
            ConexionEvent readerEvObj = new ConexionEvent(this, this,sc,id);
            (listener).onClienteConexionChange(readerEvObj);
        }
    }  
      
    @Override
    public void run(){
        try { 
            while(true){
            sc = this.server.accept();
            id++; 
            this.triggerClienteConexionEvent(sc,id);
            
            }
        } catch (IOException ex) {
            Logger.getLogger(HiloConexiones.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
