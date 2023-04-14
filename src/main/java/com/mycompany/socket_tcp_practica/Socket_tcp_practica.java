/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.socket_tcp_practica;

/**
 *
 * @author USUARIO
 */
public class Socket_tcp_practica {

    public static void main(String[] args) {
        Servidor server = new Servidor(5000); 
        server.StartServer();
    }
}
