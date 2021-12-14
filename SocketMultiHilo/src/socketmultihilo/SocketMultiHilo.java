/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketmultihilo;

import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class SocketMultiHilo {

    public static ArrayList<Persona> listin = new ArrayList<>();

    public static void main(String[] args) {
        final int puerto = 3030;
        rellenarBBDD();
        GestorListin gestor = new GestorListin(listin);

        try {
            ServerSocket socket = new ServerSocket(puerto);
            System.out.println("Servidor listo...");

            while (true) {

                Socket socketCliente = socket.accept();

                System.out.println("Conectado " + socketCliente.getInetAddress() + ":"
                        + socketCliente.getPort());
                // Crear un proceso para atender al cliente...
                AtencionCliente cliente = new AtencionCliente(socketCliente, gestor);
                cliente.start();
            }
        } catch (IOException ex) {
        }

    }

    private static void rellenarBBDD() {
        listin.add(new Persona("Pedro", "1321321"));
        listin.add(new Persona("Ana", "2321321"));
        listin.add(new Persona("Juan", "3321321"));
        listin.add(new Persona("Luis", "4321321"));
        listin.add(new Persona("Antonio", "5321321"));
        listin.add(new Persona("Luisa", "6321321"));
    }
}

