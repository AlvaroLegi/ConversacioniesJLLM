/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Locale;

/**
 *
 * @author Alvaro
 */
public class Conversacion implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nombreChat;
    private ArrayList<Message> mensajes;
    private long fechaInicioSegs;
    private long fechaFinSegs;

    public Conversacion(String nombreChat) {
        this.fechaInicioSegs = Instant.now().getEpochSecond();
        this.mensajes = new ArrayList<Message>();
        this.nombreChat = nombreChat;
    }

    public String estadoConversacion() {
        return fechaInicioSegs + " | " + mensajes.size() + " | " + mensajes.get(0).sacar20Chars();
    }

    public void mostrarConversacion() {
        if (mensajes.isEmpty()) {
            System.out.println("La conversacion esta vacia");
        } 
        else {
            System.out.println("Conversacion del " + fechaInicioSegs);
            for (Message mensaje : mensajes) {
                System.out.println(mensaje.toString());
            }
        }
    }

    public void addMensaje(String sender, String contenido) {
        Message mensaje = new Message(sender, contenido);
        this.mensajes.add(mensaje);

    }

    public void setFechaInicioSegs(long fechaInicioSegs) {
        this.fechaInicioSegs = fechaInicioSegs;
    }

    public void setFechaFinSegs(long fechaFinSegs) {
        this.fechaFinSegs = fechaFinSegs;
    }

    public String getNombreChat() {
        return nombreChat;
    }

}
