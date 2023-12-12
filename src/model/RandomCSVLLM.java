/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 *
 * @author Alvaro
 */
public class RandomCSVLLM implements ILLM {

    public RandomCSVLLM() {
    }

    @Override
    public String hablar(String input) {
        return "";
    }

    @Override
    public String getIdentifier() {
        return "RandomCSV";
    }

    public static void exportarDelimitado(Path ruta, ArrayList<Message> mensajes) {
        ArrayList<String> lineas = new ArrayList<>();
        for (Message mensaje : mensajes) {
            lineas.add(mensaje.getInstanceAsDelimitedString("\t"));
        }
        try {
            Files.write(ruta, lineas, StandardCharsets.UTF_8);
            System.out.println("Datos exportados exitosamente a: " + ruta.toFile().getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Ocurrió un error al intentar exportar las personas: " + e.getMessage());
        }
    }
}
