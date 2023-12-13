/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Locale;
import com.coti.tools.Esdia;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 *
 * @author Alvaro
 */
public class Conversacion implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String nombreChat;
    private long fechaInicioSegs;
    private long fechaFinSegs;
    private ArrayList<Message> mensajes;

    public Conversacion(String nombreChat, ArrayList<Message> mensajes, long fechaInicioSegs, long fechaFinSegs) {
        this.nombreChat = nombreChat;
        this.mensajes = mensajes;
        this.fechaInicioSegs = fechaInicioSegs;
        this.fechaFinSegs = fechaFinSegs;
    }

    public Conversacion(String nombreChat) {
        this.fechaInicioSegs = Instant.now().getEpochSecond();
        this.mensajes = new ArrayList<Message>();
        this.nombreChat = nombreChat;
    }

    public Conversacion() {
    }

    public String estadoConversacion() {
        return fechaInicioSegs + " | " + mensajes.size() + " | " + mensajes.get(0).sacar20Chars();
    }

    public void mostrarConversacion() {
        if (mensajes.isEmpty()) {
            System.out.println("La conversacion esta vacia");
        } else {
            System.out.println("Conversacion del " + Message.getFechaFromEpoch(fechaInicioSegs, "dd:MMM:yyyy: hh:mm:ss"));
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

    public ArrayList<Message> getMensajes() {
        return mensajes;
    }

    public void setMensajes(ArrayList<Message> mensajes) {
        this.mensajes = mensajes;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getFechaInicioSegs() {
        return fechaInicioSegs;
    }

    public long getFechaFinSegs() {
        return fechaFinSegs;
    }

    public void setNombreChat(String nombreChat) {
        this.nombreChat = nombreChat;
    }

}
