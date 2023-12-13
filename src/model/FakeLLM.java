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
import java.util.Random;

/**
 *
 * @author Alvaro
 */
public class FakeLLM implements ILLM {

    private final String[] respuestas = {"Me alegro", "Yo soy de Murcia, y tu?", "Estoy de acuerdo", "Y que opinas de la tortilla sin cebolla?", "jajaj si", "No coincido contigo", "Me parece bien"};
    private final String[] saludos = {"Hey, como va todo?", "Hola que tal", "Saludos compa"};
    private final String[] refranes = {"Más vale tarde que nunca", "En boca cerrada no entran moscas", "No hay mal que por bien no venga", "Más vale prevenir que lamentar", "A quien madruga, Dios le ayuda"};

    public FakeLLM() {
    }

    @Override
    public String hablar(String input) {
        Random randNum = new Random();
        if (isRefran(input)) {
            return refranes[randNum.nextInt(refranes.length)];
        } else if (isSaludo(input)) {
            return saludos[randNum.nextInt(saludos.length)];
        }

        //Por defecto
        return respuestas[randNum.nextInt(respuestas.length)];
    }

    @Override
    public String getIdentifier() {
        return "Fake";
    }

//Metodos boolean para comprobar el tipo de mensaje del usuario
    public boolean isSaludo(String input) {
        final String[] checks = {"hola", "buenos dias", "que tal", "saludos", "como estas", "hey", "como va", "buenas noches", "buenas tardes"};
        return comprobarPalabraEnArray(input, checks);
    }

    public boolean isRefran(String input) {
        final String[] checks = {"refran", "dicho", "proverbio", "dicho"};
        return comprobarPalabraEnArray(input, checks);
    }
    
//Metodo para comprobar si un String input contiene un substring de un array
//Se usa para buscar palabras clave en un mensaje introducido por el usuario
//Devuelve true en caso afirmativo y false en caso negativo
    private boolean comprobarPalabraEnArray(String input, String[] checks) {
        for (String str : checks) {
            if (input.toLowerCase().contains(str)) {
                return true;
            }
        }
        return false;
    }

}
