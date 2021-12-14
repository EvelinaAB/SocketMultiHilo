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
        Persona p = new Persona(nombre, teléfono);
        if (listin.add(p)) {
            return true;
        }

        return false;
    }

    public synchronized Persona buscar(String nombre) {
        for (Persona o : listin) {
            if (o.nombre == nombre) {
                return o;
            }
        }
        return null;
    }

    public synchronized boolean eliminar(String nombre) {
         Persona p2=this.buscar(nombre);
         if(listin.remove(p2)){
             return true;
         }
        return false;
    }
}
