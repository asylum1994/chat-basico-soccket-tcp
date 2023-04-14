/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.socket_tcp_practica;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class Servidor {
    ServerSocket server ; 
    int port ; 
    
    DataInputStream input; 
    DataOutputStream output;
    
    Socket sc; 
    
    Map<Integer,Socket> listaClientes = new HashMap<Integer,Socket>(); 
  
      MensajeEventListener eventsMensaje = new MensajeEventListener() {
        @Override
        public void onClienteMensajeChange(MensajeEvent readerEvObj) {
            //System.out.println("llego mensaje : "+readerEvObj.mensaje);
           
                try {
                    for (Socket value : listaClientes.values()) {
                    output = new DataOutputStream(value.getOutputStream());
                    output.writeUTF(readerEvObj.mensaje);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                }
              
            
        }
      };
    
     ConexionEventListener events = new ConexionEventListener() {
        @Override
        public void onClienteConexionChange(ConexionEvent readerEvObj) {
            System.out.println("se conecto el cliente : "+readerEvObj.sc);
            listaClientes.put( readerEvObj.id , readerEvObj.sc );
            System.out.println("lista de conectados : "+listaClientes);
            HiloCliente hc = new HiloCliente(readerEvObj.sc);
            hc.addEventListener(eventsMensaje);
            hc.start();
        }

     
    };
    
    
    public Servidor(int port) {
        this.port = port;
    }
    
    public void StartServer(){
        try { 
            this.server = new ServerSocket(port);
            System.out.println("el servidor ha iniciado..");
            
            HiloConexiones hc = new HiloConexiones(server); 
            hc.addEventListener(events);
            hc.start();
               
            System.out.println("__________________________________________________________________"); 
             
           
             
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
