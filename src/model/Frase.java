/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Alvaro
 */
public class Frase {
    private String tipoFrase;
    private String contenido;

    public Frase(String contenido) {
        this.contenido = contenido;
    }

    
    
    
    
    
    public String getTipoFrase() {
        return tipoFrase;
    }

    public void setTipoFrase(String tipoFrase) {
        this.tipoFrase = tipoFrase;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
    
}
