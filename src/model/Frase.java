/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.io.Serializable;

/**
 *
 * @author Alvaro
 */
public class Frase implements Serializable {

    private static final long serialVersionUID = 1L;

    private int numChars;
    private String contenido;
    private String tipoFrase;

    public Frase() {
    }

    public Frase(String tipoFrase, int numChars, String contenido) {
        this.tipoFrase = tipoFrase;
        this.numChars = numChars;
        this.contenido = contenido;
    }

    public Frase(String contenido) {
        this.contenido = contenido;
    }

    public static Frase leerFraseDeStringDelimitado(String delimitedString, String delimiter) {

        String[] chunks = delimitedString.split(delimiter);

        try {
            //EXC
            if (chunks.length != 3) {
                return null;
            }
            String tipoFrase = chunks[0];
            int numChars = Integer.parseInt(chunks[1]);
            String contenido = chunks[2];

            if (numChars == contenido.length()) {
                return new Frase(tipoFrase, numChars, contenido);
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }

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

    public int getNumChars() {
        return numChars;
    }

    public void setNumChars(int numChars) {
        this.numChars = numChars;
    }

}
