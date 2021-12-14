/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketmultihilo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class AtencionCliente extends Thread {

    private Socket socketCliente;
    private GestorListin gestor;

    public AtencionCliente(Socket socketCliente, GestorListin gestor) {
        this.socketCliente = socketCliente;
        this.gestor = gestor;
    }

    @Override
    public void run() {
        try {
            // obtener los flujos de entrada y salida sobre caracteres.
            BufferedReader br = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
            PrintWriter pw = new PrintWriter(socketCliente.getOutputStream(), true);

            String nombre;
            String telefono;

            do {

                nombre = br.readLine();

                // Analizo el comando del usuario:
                String[] comandos = nombre.trim().split(" ");

                switch (comandos[0]) {
                    //Para este caso el comando sería i Ana (insertar persona Ana)
                    case "i":

                        telefono = br.readLine();
                        if ((gestor.insertar(comandos[1], telefono)) == true) {
                            pw.print("Se ha insertado bien");

                        } else {
                            pw.print("No se ha podido insertar");
                        }

                        break;
                    //Para este caso el comando sería b Ana (buscar persona Ana)
                    case "b":

                        Persona p2 = gestor.buscar(comandos[1]);
                        pw.print(p2);

                        break;
                    //Para este caso el comando sería e Ana (eliminar persona Ana)
                    case "e":
                        if (gestor.eliminar(comandos[1]) == true) {
                            pw.print("El usuario ha sido eliminado");
                        } else {
                            pw.print("No se ha podido elimianr");
                        }

                        break;
                    default:
                        pw.println("Comando erróneo.");
                }

            } while (!nombre.equals("fin"));

            System.out.println("Proceso terminando...");
        } catch (IOException ex) {
        } finally {
            try {
                socketCliente.close();
            } catch (IOException ex) {
            }
        }
    }
}

