package com.mygdx.game;

//* Tutorial: http://pirate.shu.edu/~wachsmut/Teaching/CSAS2214/Virtual/Lectures/chat-client-server.html

import java.net.*;
import java.io.*;

public class ChatServer
{/*

  private Socket          socket   = null;
    private ServerSocket    server   = null;
    private DataInputStream streamIn =  null;

    public ChatServer(int port)
    {  try
    {  System.out.println("Binding to port " + port + ", please wait  ...");
        server = new ServerSocket(port);
        System.out.println("Server started: " + server);
        System.out.println("Waiting for a client ...");
        socket = server.accept();
        System.out.println("Client accepted: " + socket);
        open();
        boolean done = false;
        while (!done)
        {  try
        {  String line = streamIn.readUTF();
            System.out.println(line);
            done = line.equals(".bye");
        }
        catch(IOException ioe)
        {  done = true;
        }
        }
        close();
    }
    catch(IOException ioe)
    {  System.out.println(ioe);
    }
    }
    public void open() throws IOException
    {  streamIn = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
    }
    public void close() throws IOException
    {  if (socket != null)    socket.close();
        if (streamIn != null)  streamIn.close();
    }
    public static void main(String args[])
    {
        ChatServer server = new ChatServer(4343);
    }*/

    Socket skCliente;
    ServerSocket skServidor;
    String datareceived, substring1, substring2;
    final int PUERTO = 5555;// Puerto que utilizara el servidor utilizar este
    // mismo en el cliente
    String IP_client;
    Mensaje_data mdata = null;
    ObjectOutputStream oos = null;
    String TimeStamp;

   ChatServer() {

        try {
            System.out.println("************ SERVER ****************");
            // creamos server socket
            skServidor = new ServerSocket(PUERTO);
            System.out.println("Escuchando el puerto " + PUERTO);
            System.out.println("En Espera....");

            TimeStamp = new java.util.Date().toString();

            try {
                // Creamos socket para manejar conexion con cliente
                skCliente = skServidor.accept(); // esperamos al cliente
                // una vez q se conecto obtenemos la ip
                IP_client = skCliente.getInetAddress().toString();
                System.out.println("[" + TimeStamp + "] Conectado al cliente "
                        + "IP:" + IP_client);

                while (true) {
                    // Manejamos flujo de Entrada
                    ObjectInputStream ois = new ObjectInputStream(
                            skCliente.getInputStream());
                    // Cremos un Objeto con lo recibido del cliente
                    Object aux = ois.readObject();// leemos objeto

                    // si el objeto es una instancia de Mensaje_data
                    if (aux instanceof Mensaje_data) {
                        // casteamos el objeto
                        mdata = (Mensaje_data) aux;

                        // Analizamos el mensaje recibido
                        // si no es el mensaje FINAL
                        if (!mdata.last_msg) {

                            // Es un mensaje de Accion
                            if (mdata.Action != -1) {
                                // exec accion
                                Exec(mdata.Action);
                                System.out.println("[" + TimeStamp + "] "
                                        + "Ejecutar Accion " + mdata.Action
                                        + " [" + IP_client + "]");
                            } else {
                                // No es un mensaje de accion entonces es de
                                // texto
                                System.out.println("[" + TimeStamp + "] "
                                        + "Mensaje de [" + IP_client + "]--> "
                                        + mdata.texto);
                            }
                        } else {// cerramos socket
                            skCliente.close();
                            ois.close();
                            System.out
                                    .println("["
                                            + TimeStamp
                                            + "] Last_msg detected Conexion cerrada, gracias vuelva pronto");
                            break;
                        }
                    } else {
                        // Si no es del tipo esperado, se marca error
                        System.err.println("Mensaje no esperado ");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("[" + TimeStamp + "] Error ");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("[" + TimeStamp + "] Error ");
        }
    }

    // en base al codigo de accion recibido realizaremos una accion
    public void Exec(int action_num) {
        String ACTNUM = null;
        String ACT1 = "vlc";// abrir VLC
        String ACT2 = "/opt/google/chrome/google-chrome %U";// Chrome
        String ACT3 = "gnome-terminal";// terminal
        String ACT4 = "";

        try {
            switch (action_num) {
                case 1: {
                    ACTNUM = ACT1;
                    break;
                }
                case 2: {
                    ACTNUM = ACT2;
                    break;
                }
                case 3: {
                    ACTNUM = ACT3;
                    break;
                }
                case 4: {
                    ACTNUM =ACT4;
                    break;
                }
                default:{
                    System.out.println("EXEC Error invalid parameter:"+ACTNUM);
                    ACTNUM=null;

                    break;
                }
            }
            //Realizamos la accion
            Process p = Runtime.getRuntime().exec (ACTNUM);
        }
        catch (Exception e)
        {
			  /* Se lanza una excepción si no se encuentra en ejecutable o el fichero no es ejecutable. */
            System.out.println("EXEC Error "+e);
        }
    }
    public static void main(String[] args)
    {
        new ChatServer();
    }
}