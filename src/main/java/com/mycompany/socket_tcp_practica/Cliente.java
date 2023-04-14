/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.socket_tcp_practica;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class Cliente {
     
    /**
     * @param args the command line arguments
     */
   
    
   
    
    
    public static void main(String[] args) {
           
         
        // TODO code application logic here
          String host = "127.0.0.1";
          int puerto=5000;
          
           DataInputStream input; 
           DataOutputStream output; 
           Scanner scanner = new Scanner(System.in); 
           
        try {
            // TODO code application logic here   
           
             Socket sc= new Socket(host, puerto);
             input = new DataInputStream(sc.getInputStream()); 
             output = new DataOutputStream(sc.getOutputStream()); 
             while(true){
             System.out.println(sc +" ingresa mensaje : ");   
             String entrada = scanner.nextLine();  
             output.writeUTF(entrada);
             
             String mensaje = input.readUTF();  
             System.out.println("mensaje :"+mensaje);   
             
             }
             
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
