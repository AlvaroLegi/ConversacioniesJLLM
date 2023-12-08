/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.File;
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
    
    public ArrayList<Conversacion> getListaConversacionesCargadas(){
        ArrayList<Conversacion> conversacionesCopia = new ArrayList<Conversacion>();
        
        for(Conversacion conv : conversaciones){
            conversacionesCopia.add(conv);
        }
        
        return conversacionesCopia;
    }
    
    public void eliminarConversacion(Conversacion conversacionAEliminar){
        this.conversaciones.remove(conversacionAEliminar);
    }
    
    public ApplicationModel(Conversacion conversacion, IRepository repository, ArrayList<Conversacion> conversaciones, ILLM llm) {
        this.conversacion = null;
        //this.repository = repository;
        this.conversaciones = new ArrayList<Conversacion>();
        //this.llm = llm;
    }

    public boolean importarConversaciones() {
        conversaciones = (ArrayList<Conversacion>) repository.importarConversaciones();
        
        if(conversaciones == null){
            return false;
        }
        else{
            return true;
        }
    }

    public void exportarConversaciones() {
        repository.exportarConversaciones(this.conversaciones);
    }

    
    
    
    
    
}
