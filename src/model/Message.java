/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.lang.Object;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Set;

/**
 *
 * @author Alvaro
 */
public class Message {

    private String sender;
    private long epochSeconds;
    private Frase frase;

    public Message(String sender, String contenido) {
        this.sender = sender;
        this.epochSeconds = Instant.now().getEpochSecond();
        this.frase = new Frase(contenido);
    }

    //Método que devuelve los primeros 20 Char del contenido del mensaje o el mensaje entero en caso de tener menos de 20 caracteres
    //usa el metodo substring
    public String sacar20Chars() {
        String resultado;

        if (frase.getContenido().length() >= 20) {
            resultado = frase.getContenido().substring(0, 20);
        } else {
            resultado = frase.getContenido().substring(0, frase.getContenido().length());
        }

        return resultado;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setEpochSeconds(long epochSeconds) {
        this.epochSeconds = epochSeconds;
    }

    public void setContenido(String contenido) {
        frase.setContenido(contenido);
    }

    @Override
    public String toString() {
        return sender + "[" + getFechaFromEpoch(epochSeconds,"dd/MMM/yyyy: hh:mm:ss") + "]: " + frase.getContenido();
    }

    public String getInstanceAsDelimitedString(String delimiter) {
        return String.format(Locale.ENGLISH, "%s" + delimiter + "%s" + delimiter + "%d", sender, frase.getContenido(), epochSeconds);
    }

    public static String getFechaFromEpoch(long epochSeconds, String pattern) {
        LocalDateTime dateTime = LocalDateTime.ofEpochSecond(epochSeconds, 0, ZoneOffset.UTC);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, Locale.ENGLISH);
        
        return dateTime.format(formatter);
    }
}
