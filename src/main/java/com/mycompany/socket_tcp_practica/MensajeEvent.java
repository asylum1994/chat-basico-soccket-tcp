/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.socket_tcp_practica;

import java.util.EventObject;

/**
 *
 * @author USUARIO
 */
public class MensajeEvent extends EventObject {
    HiloCliente hiloCliente ; 
    String mensaje; 
    public MensajeEvent(Object source,HiloCliente hiloCliente,String mensaje) {
        super(source);
        this.hiloCliente=hiloCliente; 
        this.mensaje=mensaje; 
    }
    
}
