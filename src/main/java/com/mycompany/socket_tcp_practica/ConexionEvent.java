/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.socket_tcp_practica;

import java.net.Socket;
import java.util.EventObject;

/**
 *
 * @author USUARIO
 */
public class ConexionEvent extends EventObject {
    
    HiloConexiones hiloConexiones ; 
    Socket sc ; 
    Integer id; 
   
 
   
    public ConexionEvent(Object source, HiloConexiones hiloConexiones, Socket sc, int id) {
        super(source);
        hiloConexiones = hiloConexiones;
        this.sc = sc; 
        this.id=id;
    }

   

  
    
    
    
  
    
    
}
