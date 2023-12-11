/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package conversacionesjllm;

import com.coti.tools.Esdia;
import controller.ApplicationController;
import java.util.ArrayList;
import java.util.Arrays;
import model.ApplicationModel;
import model.Conversacion;
import model.FakeLLM;
import model.ILLM;
import model.IRepository;
import model.JSONRepository;
import view.ApplicationView;
import view.VistaConsola;

/**
 *
 * @author Alvaro
 */
public class ConversacionesJLLM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        IRepository repository;
        ILLM llm;
        ApplicationView v;

        //temp
        repository = new JSONRepository();
        v = new VistaConsola();

        if (args.length == 3) {
            //repository = getRepository(args[0]);
            //llm = getLLM(args[1]);
            //v = getView(args[2]);
        } else {
            //Default
            repository = new JSONRepository();
            llm = new FakeLLM();
            v = new VistaConsola();
        }

        //Carga estado aplicacion
        llm = new FakeLLM();
        ArrayList<Conversacion> conversaciones = new ArrayList<Conversacion>();

        ApplicationModel m = new ApplicationModel(repository, conversaciones, llm);
        ApplicationController c = new ApplicationController(v, m);
        v.setC(c);

        c.init();

    }

}
