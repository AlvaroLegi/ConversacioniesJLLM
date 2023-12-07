/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.coti.tools.Esdia;
import java.util.ArrayList;

/**
 *
 * @author Alvaro
 */
public class Conversacion {
    private String nombreChat;
    private ArrayList<Message> mensajes;
    private int fechaInicioSegs;
    private int fechaFinSegs;

    public Conversacion(String nombreChat) {
        this.nombreChat = nombreChat;
        
    }

    public String estadoConversacion() {
        
        
        
        return fechaInicioSegs + "|" + mensajes.size() + "|" + mensajes.get(0).sacar20Chars() ;
    }
    
    public void mostrarConversacion(){
        if(mensajes.isEmpty()){
            System.out.println("La conversacion esta vacia");
            
        }
        else{
            for(Message mensaje : mensajes){
                System.out.printf(mensaje.toString());
            }
        }
        
        
        
    }
    
    
    
    
}
