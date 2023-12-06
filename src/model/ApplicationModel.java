/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Alvaro
 */
public class ApplicationModel {

    private Conversacion conversacion;
    
    public void nuevaConversacion(String nombreChat){
        if(this.conversacion==null){
            this.conversacion=new Conversacion(nombreChat);
        }
        
        String input;
        do{
            //Lógica del chatbot para hablar
            input="";
            
        }while(input != "\salir");
    }
    
    
    
    
    
}
