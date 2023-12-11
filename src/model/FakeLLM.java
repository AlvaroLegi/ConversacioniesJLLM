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
import java.util.List;

/**
 *
 * @author Alvaro
 */
public class FakeLLM implements ILLM {

    private final String[] frases = {"Me alegro", "Yo soy de Murcia, y tu?", "Estoy de acuerdo", "Y que opinas de la tortilla sin cebolla?"};
    private final String[] saludos = {"Hey, como va todo?", "Hola que tal", "Saludos compa"};

    public FakeLLM() {
    }

    @Override
    public String hablar(String input) {
        if (input.equals("hola")) {
            return saludos[1];
        } else {
            return frases[1];
        }
    }

    @Override
    public String getIdentifier() {
        return "Fake";
    }

    

}
