/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import controller.ApplicationController;
/**
 *
 * @author Alvaro
 */
public abstract class ApplicationView {
    
    ApplicationController c;
    
    public abstract void mostrarInicio();
    
    public abstract void mostrarMenu();
    
    public abstract void mostrarFinal();
    
    public void setC(ApplicationController c) {
        this.c = c;
    }
    
}
