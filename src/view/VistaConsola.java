/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package view;

import controller.ApplicationController;
import com.coti.tools.Esdia;

/**
 *
 * @author Alvaro
 */
public class VistaConsola extends ApplicationView {

    
    
    @Override
    public void mostrarInicio() {
        
    }

    @Override
    public void mostrarMenu() {
        int input;
        do{
            System.out.println("===============================================");
            System.out.println("              ConversacionesJLLM               ");
            System.out.println("===============================================");
            System.out.println("1) Nueva conversacion");
            System.out.println("2) Lista de conversaciones");
            System.out.println("3) Eliminar conversacion");
            System.out.println("4) Importar/Exportar conversacion");
            System.out.println("");
            System.out.println("0) Salir");
            System.out.println("===============================================");
            input = Esdia.readInt("Tu eleccion >> ", 0, 4);
            
            switch(input){
                case 1: agregarConversacion(); break;
                case 2: listarConversaciones(); break;
                case 3: eliminarConversacion(); break;
                case 4: mostrarSubmenu(); break;
                default: break;
                    
                
            }
        } while (input>0);
    }
    public void agregarConversacion(){
        
    }
    
    public void listarConversaciones(){
        
    }
    public void eliminarConversacion(){
        
    }
    
    //Submenu para importar y exportar conversaciones
    public void mostrarSubmenu(){
        
    }
    
    @Override
    public void mostrarFinal() {
        
    }
    
    public VistaConsola(ApplicationController c) {
        super(c);
    }
    

}
