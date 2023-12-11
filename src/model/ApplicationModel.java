/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import static com.coti.tools.Esdia.readString_ne;
import java.io.File;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Alvaro
 */
public class ApplicationModel {

    private IRepository repository;
    private ArrayList<Conversacion> conversaciones;
    private ILLM llm;

    public ApplicationModel(IRepository repository, ArrayList<Conversacion> conversaciones, ILLM llm) {
        this.repository = repository;
        this.conversaciones = conversaciones;
        this.llm = llm;
    }

    public void nuevaConversacion() {

        Conversacion conversacion = new Conversacion(this.llm.getIdentifier());
        String input = "hola"; //El valor inicial se fija asi para forzar un saludo como primer mensaje
        String output;

        //Lógica del chatbot para hablar
        //mensaje inicial del bot
        do {
            //Output
            output = llm.hablar(input);
            System.out.println(output);
            conversacion.addMensaje(conversacion.getNombreChat(), output);
            //Input
            input = readString_ne(">> ");
            if (!input.equals("\\salir")) {
                conversacion.addMensaje("Yo", input);
            }

        } while (!input.equals("\\salir"));

        conversacion.setFechaFinSegs(Instant.now().getEpochSecond());

        this.conversaciones.add(conversacion);
    }

    public ArrayList<Conversacion> getListaConversacionesCargadas() {
        ArrayList<Conversacion> conversacionesCopia = new ArrayList<Conversacion>();

        for (Conversacion conv : conversaciones) {
            conversacionesCopia.add(conv);
        }

        return conversacionesCopia;
    }

    public void eliminarConversacion(Conversacion conversacionAEliminar) {
        this.conversaciones.remove(conversacionAEliminar);
    }

    public boolean importarConversaciones() {
        conversaciones = (ArrayList<Conversacion>) repository.importarConversaciones();

        if (conversaciones == null) {
            return false;
        } else {
            return true;
        }
    }

    public void exportarConversaciones() {
        repository.exportarConversaciones(this.conversaciones);
    }

}
