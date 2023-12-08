/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import static com.coti.tools.Rutas.pathToFileInFolderOnDesktop;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
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
public class XMLRepository implements IRepository{

    @Override
    public ArrayList<Conversacion> importarConversaciones() {
        String nombreFichero = "input.xml";
        
        Path pathRef = pathToFileInFolderOnDesktop("jLLM", nombreFichero);
        File fileRef = pathRef.toFile();
       
        if (fileRef.isFile() && fileRef.exists()) {
            try {
                XmlMapper xmlMapper = new XmlMapper();
                String xml = new String(Files.readAllBytes(fileRef.toPath()), StandardCharsets.UTF_8);
                // Utiliza TypeFactory para obtener el tipo de lista correcto
                return xmlMapper.readValue(xml, xmlMapper.getTypeFactory().constructCollectionType(ArrayList.class, Conversacion.class));
            } catch (IOException ex) {
                System.err.println("Error:" + ex.getMessage());
                return null;
            }
        }
        else{
            return null;
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
            Files.write(fileRef.toPath(), xml.getBytes(StandardCharsets.UTF_8));
        } 
        catch (JsonProcessingException ex) {
            System.err.println("Error:" + ex.getMessage());
        } 
        catch (IOException ex) {
            // Lo mismo aquí
            System.err.println("Error:" + ex.getMessage());
        }
    }

}
