/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package conversacionesjllm;

import com.coti.tools.Esdia;
import controller.ApplicationController;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import model.ApplicationModel;
import model.Conversacion;
import model.FakeLLM;
import model.ILLM;
import model.IRepository;
import model.JSONRepository;
import model.RandomCSVLLM;
import model.XMLRepository;
import view.ApplicationView;
import view.VistaConsola;
import view.VistaConsolaTTS;

/**
 *
 * @author Alvaro
 */
public class ConversacionesJLLM {
    
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        IRepository repository;
        ILLM llm;
        ApplicationView v;

        if (args.length == 3) {
            repository = getRepository(args[0]);
            llm = getLLM(args[1]);
            v = getView(args[2]);
        } else {
            //Default
            repository = new XMLRepository();
            llm = new RandomCSVLLM();
            v = new VistaConsola();
        }

        //Carga estado aplicacion
        ArrayList<Conversacion> conversaciones = new ArrayList<Conversacion>();

        //Constructor MVC
        ApplicationModel m = new ApplicationModel(repository, conversaciones, llm);
        ApplicationController c = new ApplicationController(v, m);
        v.setC(c);

        c.init();

    }

    private static IRepository getRepository(String arg) {
        if (arg.equalsIgnoreCase("json")) {
            return new JSONRepository();
        } else if (arg.equalsIgnoreCase("json")) {
            return new XMLRepository();
        } else {
            return new JSONRepository();
        }

    }

    private static ILLM getLLM(String arg) throws Exception {
        if (arg.equalsIgnoreCase("fake")) {
            return new FakeLLM();
        } else if (arg.equalsIgnoreCase("csv")) {
            File f = new File("fichero.csv");
            if (f.exists() && f.isFile()) {
                return new RandomCSVLLM();
            } else {
                System.err.println("No se encontro fichero.csv en los archivos del programa, el LLM utilizado sera FakeLLM");
                return new FakeLLM();
            }
        } else {
            return new FakeLLM();
        }
    }

    private static ApplicationView getView(String arg) {

        if (arg.equalsIgnoreCase("fake")) {
            return new VistaConsola();
        } else if (arg.equalsIgnoreCase("csv")) {
            return new VistaConsolaTTS();
        } else {
            return new VistaConsola();
        }
    }

}
