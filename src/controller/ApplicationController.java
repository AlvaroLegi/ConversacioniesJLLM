/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import view.ApplicationView;
import model.ApplicationModel;

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
    
    
    
    
    
    
    
    
    
    
    
    
    public ApplicationController(ApplicationView v, ApplicationModel m) {
        this.v = v;
        this.m = m;
        this.v.super.setC(this);
    }
    
    
}
