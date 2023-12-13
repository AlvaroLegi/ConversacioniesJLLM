/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.coti.tools.Rutas;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Alvaro
 */
public class RandomCSVLLM implements ILLM {

    private static ArrayList<Frase> frases;

    public RandomCSVLLM() throws Exception {
        try {
            importarFraseArrayDelimitado(Paths.get("input.csv"), ",");
        } catch (Exception e) {
            System.err.println("Se ha producido un error cargando las frases de input.csv");
            throw new Exception("ERROR: " + e.getMessage(), e);
        }
    }

    @Override
    public String hablar(String input) {

        Random randNum = new Random();

        return frases.get(randNum.nextInt(frases.size())).getContenido();
    }

    @Override
    public String getIdentifier() {
        return "RandomCSV";
    }

    public void importarFraseArrayDelimitado(Path ruta, String delimitador) throws Exception {
        ArrayList<Frase> frases = new ArrayList<>();
        try {
            List<String> lineas = Files.readAllLines(ruta);
            for (String linea : lineas) {
                Frase frase = Frase.leerFraseDeStringDelimitado(linea, delimitador);
                if (frase != null) {
                    frases.add(frase);
                }
            }
        } catch (IOException e) {
            System.err.println("Se ha producido un error importando las frases del CSV");
            throw new Exception("ERROR: " + e.getMessage(), e);
        }
        this.frases = frases;
    }

}
