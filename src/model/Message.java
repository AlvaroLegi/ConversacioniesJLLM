/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Alvaro
 */
public class Message {
    private String sender;
    private long epochSeconds;
    private String contenido;

    public Message(String sender, long epochSeconds, String contenido) {
        this.sender = sender;
        this.epochSeconds = epochSeconds;
        this.contenido = contenido;
    }
    
    //Método que devuelve los primeros 20 Char del contenido del mensaje o el mensaje entero en caso de tener menos de 20 caracteres
    public String sacar20Chars(){
        String resultado;
        
        if (this.contenido.length() >= 20){
            resultado = this.contenido.substring(0, 20);
        }
        
        else{
            resultado = this.contenido.substring(0, this.contenido.length());
        }
        
        return resultado;
    }
    
    
    
    
    
    

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public long getEpochSeconds() {
        return epochSeconds;
    }

    public void setEpochSeconds(long epochSeconds) {
        this.epochSeconds = epochSeconds;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    @Override
    public String toString() {
        return "Message{" + "-" + sender + ": " + contenido +" | "+ epochSeconds + '}';
    }
    
    
    
}
