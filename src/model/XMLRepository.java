/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import static com.coti.tools.Rutas.pathToFileInFolderOnDesktop;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Conversacion;

/**
 *
 * @author Alvaro
 */
public class XMLRepository implements IRepository {

    @Override
    public ArrayList<Conversacion> importarConversaciones() {
        String nombreFichero = "input.xml";
        ArrayList<Conversacion> conversaciones = new ArrayList<>();
        Path pathRef = pathToFileInFolderOnDesktop("jLLM", nombreFichero);
        File fileRef = pathRef.toFile();
        //ObjectMapper objectMapper = new ObjectMapper();
        if (!fileRef.isFile() && fileRef.exists()) {
            return null;
        }
        try {
            XmlMapper xmlMapper = new XmlMapper();
            String xml = new String(Files.readAllBytes(fileRef.toPath()),StandardCharsets.UTF_8);
            
            conversaciones = xmlMapper.readValue(xml, xmlMapper.getTypeFactory().constructCollectionType(ArrayList.class, Conversacion.class));
        } catch (Exception e) {
            System.err.println("Error importando input.xml");
            throw new Exception("ERROR: " + e.getMessage(),e);
        } finally {
            return conversaciones;

        }
    }

    @Override
    public void exportarConversaciones(ArrayList<Conversacion> conversaciones) {

        String nombreFichero = "output.xml";

        Path pathRef = pathToFileInFolderOnDesktop("jLLM", nombreFichero);
        File fileRef = pathRef.toFile();

        try {
            
            XmlMapper xmlMapper = new XmlMapper();
            String xml = xmlMapper.writeValueAsString(conversaciones);
            Files.write(fileRef.toPath(),xml.getBytes(StandardCharsets.UTF_8));
            System.out.println("Conversaciones exportadas correctamente");
        
        } catch (Exception e) {
            //System.err.println("Error:" + e.getMessage());
            throw new Exception("ERROR: " + e.getMessage(), e);
        } finally {
            return;
        }
    }

}
