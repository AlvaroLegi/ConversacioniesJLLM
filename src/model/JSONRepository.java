/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


import com.fasterxml.jackson.core.JsonProcessingException;
import static com.fasterxml.jackson.databind.cfg.CoercionInputShape.String;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import com.coti.tools.Rutas;
import static com.coti.tools.Rutas.fileToFolderOnDesktop;
import static com.coti.tools.Rutas.pathToFileInFolderOnDesktop;
import static com.coti.tools.Rutas.pathToFolderOnDesktop;

/**
 *
 * @author Alvaro
 */
public class JSONRepository implements IRepository {

    @Override
    public ArrayList<Conversacion> importarConversaciones() {
        String nombreFichero = "input.json";
        
        Path pathRef = pathToFileInFolderOnDesktop("jLLM", nombreFichero);
        File fileRef = pathRef.toFile();
        
        try {
            Gson gson = new Gson();
            // Lee todo el archivo en un String
            String json = new String(Files.readAllBytes(fileRef.toPath()), StandardCharsets.UTF_8);
            // Obtiene el tipo de la lista
            Type tipoDeLista = new TypeToken<ArrayList<Conversacion>>() {}.getType();
            return gson.fromJson(json, tipoDeLista);
            
        } catch (IOException ex) {
            // TODO veremos como cambiar esto cuando tratemos excepciones
            // de momento retornaremos null si hay algún problema
            System.err.println("Error:" + ex.getMessage());
            return null;
        }
    }

    
    @Override
    public void exportarConversaciones(ArrayList<Conversacion> conversaciones) {

        String nombreFichero = "output.json";
        
        Path pathRef = pathToFileInFolderOnDesktop("jLLM", nombreFichero);
        File fileRef = pathRef.toFile();

        try {
            Gson gson = new Gson();
            String json = gson.toJson(conversaciones);
            Files.write(fileRef.toPath(), json.getBytes(StandardCharsets.UTF_8));
            
        } catch (IOException ex) {
            System.err.println("Error:" + ex.getMessage());
        }
        
    }
    
    
}
