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
        
         
            do {
                nombre = br.readLine();

                // Analizo el comando del usuario:
                String[] comandos = nombre.trim().split(" ");

                switch (comandos[0]) {
                    case "i":
                        
                        

                        break;
                    case "b":

                     
                        break;

                    case "e":

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
