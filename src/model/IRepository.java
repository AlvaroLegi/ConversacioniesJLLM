/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alvaro
 */
public interface IRepository {

    public ArrayList<Conversacion> importarConversaciones() throws Exception;

    public void exportarConversaciones(ArrayList<Conversacion> conversaciones) throws Exception;

}
