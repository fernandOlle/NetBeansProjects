package com.servertcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author owzi
 */
public class ServerTCP {

    static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8888);

        while (true) {
            Socket socket = serverSocket.accept();

            new Thread() {
                @Override
                public void run() {
                    try {
                        final DataInputStream in = new DataInputStream(socket.getInputStream());
                        final DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                        String msgCliente = in.readUTF();
                        System.out.println("Nome do Cliente: " + msgCliente);
                        System.out.println("IP do Cliente: " + socket.getInetAddress().getHostAddress());
                        sleep(getRandomNumber(50, 5000));
                        System.out.println("Porta do Cliente: " + socket.getPort());
                        String msgServidor = "Olá cliente " + msgCliente;
                        out.writeUTF(msgServidor);
                        in.close();
                        out.close();
                        socket.close();
                    } catch (IOException ex) {
                        System.out.println("Não foi possível montar a conexão no servidor.");
                        Logger.getLogger(ServerTCP.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ServerTCP.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }.start();
        }

    }

}
