package com.mygdx.game;

/**
 * Tutorial: http://pirate.shu.edu/~wachsmut/Teaching/CSAS2214/Virtual/Lectures/chat-client-server.html
 */
import java.net.*;
import java.io.*;

public class ChatClient{
    static Socket clientSocket;
    public void run() {
        try {
            BufferedReader inFromUser =
                new BufferedReader(
                        new InputStreamReader(System.in));

        //System.out.println("Iniciando socket.");
        //System.out.flush();

            clientSocket = new Socket("localhost", 4343);

        //System.out.println("Iniciando server listener.");
        //System.out.flush();
            //Thread t = new Thread(new MyServerListener());
            //t.start();

            DataOutputStream outToServer =
                new DataOutputStream(
                        clientSocket.getOutputStream());

            System.out.println("Conectado.");
            System.out.flush();

            //while (true) {
            //System.out.println("Ingrese una cadena a enviar: ");
            //System.out.flush();

                String mensaje = "test";
                outToServer.writeBytes("login-"+MyGdxGame.str_user+"-"+MyGdxGame.str_password + '\n');
                outToServer.flush();
                if (mensaje.equals("EXIT")) {
                    //break;
                }
            //}
            clientSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class MyServerListener implements Runnable {
    @Override
    public void run() {
        BufferedReader inFromServer  = null;
        try {
            inFromServer = new BufferedReader(
                    new InputStreamReader(
                            ChatClient.clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                //System.out.println("Esperando mensaje del server.");
                //System.out.flush();

                String mensaje_del_server = inFromServer.readLine();
                System.out.println("Recibido: " + mensaje_del_server);
                System.out.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}