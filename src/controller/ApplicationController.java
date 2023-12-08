/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.ArrayList;
import java.util.List;
import view.ApplicationView;
import model.ApplicationModel;
import model.Conversacion;

/**
 *
 * @author Alvaro
 */
public class ApplicationController {
    ApplicationView v;
    ApplicationModel m;

    public void init(){ //acabar de hacer esto
        v.mostrarInicio();
        v.mostrarMenu();
        v.mostrarFinal();
        
    }
    
    public ArrayList<Conversacion> getListaConversacionesCargadas(){
        return m.getListaConversacionesCargadas();
    }
    
    public ApplicationController(ApplicationView v, ApplicationModel m) {
        this.v = v;
        this.m = m;
        v.setC(this);
    }

    public void nuevaConversacion() {
        m.nuevaConversacion();
    }

    public void eliminarConversacion(Conversacion conversacionAEliminar){
        m.eliminarConversacion(conversacionAEliminar);
    }

    public boolean importarConversaciones() {
        return m.importarConversaciones();
    }
    
    
}
