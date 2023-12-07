/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alvaro
 */
public class ApplicationModel {

    private Conversacion conversacion;
    private IRepository repository;
    private ArrayList<Conversacion> conversaciones;
    private ILLM llm;
    
    public void nuevaConversacion(){
        if(this.conversacion==null){
            this.conversacion=new Conversacion(this.llm.getIdentifier());
        }
        
        String input;
        do{
            //Lógica del chatbot para hablar
            input="";
            
        }while(input != "\salir");
    }
    
    public ArrayList listarConversaciones(){
        ArrayList<Conversacion> conversacionesCopia = new ArrayList<Conversacion>();
        
        for(Conversacion conv : conversaciones){
            conversacionesCopia.add(conv);
        }
        
        return conversacionesCopia;
    }

    public ApplicationModel(Conversacion conversacion, IRepository repository, ArrayList<Conversacion> conversaciones, ILLM llm) {
        this.conversacion = conversacion;
        //this.repository = repository;
        this.conversaciones = new ArrayList<Conversacion>();
        //this.llm = llm;
    }

    
    
    
    
    
}
