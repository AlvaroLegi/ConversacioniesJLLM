/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

import java.util.List;
/**
 *
 * @author Alvaro
 */
public interface IRepository {
    public List importarConversaciones();
    public void exportarConversaciones(List<Conversacion> conversaciones);
    
}
