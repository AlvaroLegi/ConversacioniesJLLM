/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package view;

import controller.ApplicationController;
import com.coti.tools.Esdia;
import static com.coti.tools.Esdia.readInt;
import static com.coti.tools.Esdia.readString_ne;
import java.util.ArrayList;
import model.Conversacion;

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
        int imput;
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
            imput = Esdia.readInt("Tu eleccion >> ", 0, 4);
            
            switch(imput){
                case 1: nuevaConversacion(); break;
                case 2: listarConversaciones(); break;
                case 3: eliminarConversacion(); break;
                case 4: mostrarSubmenu(); break;
                default: break;
                    
                
            }
        } while (imput>0);
    }
    public void nuevaConversacion(){
        c.nuevaConversacion();
    }
    
    public void listarConversaciones(){
        
        ArrayList<Conversacion> conversaciones = c.getListaConversacionesCargadas();
        mostrarConversaciones(conversaciones);
        
        //Menu adicional para mostrar una conversacion individual
        System.out.println("Desea ver una conversacion? (0 para salir)");
        int input = readInt("Tu eleccion >>", 0, conversaciones.size());
        
        if(input>0 ){
            conversaciones.get(input).mostrarConversacion();
        }
    }
    public void eliminarConversacion(){
        
        
        ArrayList<Conversacion> conversaciones = c.getListaConversacionesCargadas();
        mostrarConversaciones(conversaciones);
        
        //Menu adicional para eliminar una conversacion individual
        System.out.println("Desea eliminar una conversacion? (0 para salir)");
        int input = readInt("Tu eleccion >>", 0, conversaciones.size());
        
        if(input>0 ){
            c.eliminarConversacion(conversaciones.get(input));
        }
        
        
    }
    
    //Metodo usado para listarConversaciones y eliminarConversaciones
    //muestra un resumen de cada conversacion
    public void mostrarConversaciones(ArrayList<Conversacion> conversaciones){
        
        if (conversaciones.isEmpty()){
            System.out.println("No hay conversaciones cargadas");
            System.out.println("");
        }
        
        else{
            System.out.println("Listado de conversaciones");
            for(Conversacion conversacion : conversaciones){
                System.out.printf(conversaciones.indexOf(conversacion) + ". " + conversacion.estadoConversacion());
            }
            System.out.println("===============================================");
        }
        
    }
    
    //Submenu para importar y exportar conversaciones
    public void mostrarSubmenu(){
        System.out.println("Menu para importar/exportar conversaciones");
        System.out.println("1) Importar conversaciones");
        System.out.println("2) Exportar conversaciones");
        System.out.println("");
        System.out.println("0) Salir");
        System.out.println("");
        int input = readInt("Tu eleccion >> ",0,2);
        switch(input){
            case 1: importarConversaciones(); break;
            case 2: exportarConversaciones(); break;
            case 0: break;
        }
    }
    
    @Override
    public void mostrarFinal() {
        
    }

    private void importarConversaciones() {
        boolean resultado;
        resultado = c.importarConversaciones();
        
        if(!resultado){
            System.err.println("Se ha producido un error importando las conversaciones");
        }
        else{
            System.out.println("Conversaciones importadas correctamente");
        }
    }

    private void exportarConversaciones() {
        ArrayList<Conversacion> conversaciones = c.getListaConversacionesCargadas() ;
        
        
        
    }
    
    

}
