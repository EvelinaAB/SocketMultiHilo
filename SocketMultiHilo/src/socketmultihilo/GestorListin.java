/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketmultihilo;

import java.util.ArrayList;

public class GestorListin {
    private ArrayList<Persona> listin;

    public GestorListin(ArrayList<Persona> listin) {
        this.listin = listin;
    }
    
    public synchronized boolean insertar(String nombre, String teléfono) {
        
        return false;
    }
    
    public synchronized Persona buscar(String nombre){

        return null;
    }
    

    public synchronized boolean eliminar(String nombre){
        
        return false;
    }
}
