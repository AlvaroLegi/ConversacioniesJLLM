/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package view;

import controller.ApplicationController;
import com.coti.tools.Esdia;
import static com.coti.tools.Esdia.readInt;
import static com.coti.tools.Esdia.readString_ne;
import com.coti.tools.Rutas;
import static com.coti.tools.Rutas.pathToFileInFolderOnDesktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import model.Conversacion;

/**
 *
 * @author Alvaro
 */
public class VistaConsola extends ApplicationView {

    public VistaConsola() {
    }

    @Override
    public void mostrarInicio() throws Exception {
        Path pathDir = Rutas.pathToFolderOnDesktop("jMML");
        File dirRef = pathDir.toFile();

        Path pathFile = Rutas.pathToFileInFolderOnDesktop("jMML", "jMML.bin");
        File fileRef = pathFile.toFile();

        if (!(fileRef.isFile() && fileRef.exists())) {
            System.out.println("No se encontro jMML.bin en jMML");
        } else {
            cargarEstadoApp();
            System.out.println("Se han cargado " + c.getListaConversacionesCargadas().size() +" conversaciones");
            System.out.println("");
        }
        
    }

    @Override
    public void mostrarMenu() throws Exception {
        int imput;
        do {
            System.out.println("===============================================");
            System.out.println("              ConversacionesJLLM               ");
            System.out.println("===============================================");
            System.out.println("1) Nueva conversacion");
            System.out.println("2) Lista de conversaciones");
            System.out.println("3) Eliminar conversacion");
            System.out.println("4) Importar/Exportar conversacion");
            System.out.println("");
            System.out.println("0) Salir");
            System.out.println("===============================================");
            imput = Esdia.readInt("Tu eleccion >> ", 0, 4);

            switch (imput) {
                case 1:
                    nuevaConversacion();
                    break;
                case 2:
                    listarConversaciones();
                    break;
                case 3:
                    eliminarConversacion();
                    break;
                case 4:
                    mostrarSubmenu();
                    break;
                default:
                    break;

            }
        } while (imput > 0);
    }

    public void nuevaConversacion() {
        c.nuevaConversacion();
    }

    public void listarConversaciones() {

        ArrayList<Conversacion> conversaciones = c.getListaConversacionesCargadas();

        mostrarConversaciones(conversaciones);

        //Menu adicional para mostrar una conversacion individual
        if (!conversaciones.isEmpty()) {
            System.out.println("Desea ver una conversacion? (0 para salir)");
            int input = readInt("Tu eleccion >>", 0, conversaciones.size());

            if (input > 0) {
                conversaciones.get(input - 1).mostrarConversacion();
            }
        }
    }

    public void eliminarConversacion() {
        ArrayList<Conversacion> conversaciones = c.getListaConversacionesCargadas();
        mostrarConversaciones(conversaciones);
        if(conversaciones.isEmpty()){
            return;
        }
        //Menu adicional para eliminar una conversacion individual
        System.out.println("Desea eliminar una conversacion? (0 para salir)");
        int input = readInt("Tu eleccion >>", 0, conversaciones.size());

        if (input > 0) {
            c.eliminarConversacion(conversaciones.get(input - 1));
        }
    }

    //Metodo usado para listarConversaciones y eliminarConversaciones
    //muestra un resumen de cada conversacion
    public void mostrarConversaciones(ArrayList<Conversacion> conversaciones) {

        if (conversaciones.isEmpty()) {
            System.out.println("No hay conversaciones cargadas");
            System.out.println("");
        } else {
            System.out.println("Listado de conversaciones");
            for (Conversacion conversacion : conversaciones) {
                System.out.println((conversaciones.indexOf(conversacion) + 1) + ". " + conversacion.estadoConversacion());
            }
            System.out.println("===============================================");
        }

    }

    //Submenu para importar y exportar conversaciones
    public void mostrarSubmenu() throws Exception {
        System.out.println("Menu para importar/exportar conversaciones");
        System.out.println("1) Importar conversaciones");
        System.out.println("2) Exportar conversaciones");
        System.out.println("");
        System.out.println("0) Salir");
        System.out.println("");
        int input = readInt("Tu eleccion >> ", 0, 2);
        switch (input) {
            case 1:
                importarConversaciones();
                break;
            case 2:
                exportarConversaciones();
                break;
            case 0:
                break;
        }
    }

    @Override
    public void mostrarFinal() throws Exception {
        try{
            guardarEstadoApp();
        } catch (Exception e){
            System.out.println("No se han podido importar los datos a jMML.bin, las conversaciones no serán guardadas");
        }
        System.out.println("Hasta pronto.");

    }

    private void importarConversaciones() throws Exception {
        boolean resultado;
        resultado = c.importarConversaciones();

        if (!resultado) {
            System.err.println("Se ha producido un error importando las conversaciones");
        } else {
            System.out.println("Conversaciones importadas correctamente");
        }
    }

    private void exportarConversaciones() throws Exception {
        ArrayList<Conversacion> conversaciones = c.getListaConversacionesCargadas();
        if (conversaciones.isEmpty()) {
            System.out.println("No hay conversaciones cargadas para exportar");
        } else {
            c.exportarConversasciones();
        }
    }

    private void guardarEstadoApp() throws Exception {

        Path pathFile = Rutas.pathToFileInFolderOnDesktop("jMML", "jMML.bin");
        File fileRef = pathFile.toFile();
        String ruta = fileRef.getAbsolutePath();
        
        

        ArrayList<Conversacion> conversaciones = c.getListaConversacionesCargadas();
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileRef))) {
            oos.writeObject(conversaciones);
            System.out.println("Lista guardada con exito.");
        } catch (Exception e) {
            throw new Exception("ERROR: " + e.getMessage(), e);
        }
    }

    private void cargarEstadoApp() throws Exception {
        Path pathFile = Rutas.pathToFileInFolderOnDesktop("jMML", "jMML.bin");
        File fileRef = pathFile.toFile();
        String ruta = fileRef.getAbsolutePath();
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileRef))) {
            ArrayList<Conversacion> conversaciones = (ArrayList<Conversacion>) ois.readObject();
            c.setListaConversacionesCargadas(conversaciones);
        } catch (Exception e) {
            throw new Exception("ERROR: " + e.getMessage(), e);
        }

    }

}
