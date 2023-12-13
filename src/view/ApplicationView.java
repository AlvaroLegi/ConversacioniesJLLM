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

    public abstract void mostrarInicio() throws Exception;

    public abstract void mostrarMenu() throws Exception;

    public abstract void mostrarFinal() throws Exception;

    public void setC(ApplicationController c) {
        this.c = c;
    }

}
