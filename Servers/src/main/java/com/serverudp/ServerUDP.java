package com.serverudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author owzi
 */
public class ServerUDP {
    
    public static void main(String[] args) throws IOException {

        try {

            DatagramSocket dtSocket = new DatagramSocket(8889);

            DatagramPacket pacote = new DatagramPacket(new byte[512], 512);

            dtSocket.receive(pacote);

            String msgCliente = new String(pacote.getData());

            System.out.println("Nome do Cliente: " + msgCliente);

            System.out.println("IP do Cliente: " + pacote.getAddress().getHostAddress());

            System.out.println("Porta do Cliente: " + pacote.getPort());

            byte[] buffer = ("Olá cliente " + msgCliente).getBytes();

            pacote = new DatagramPacket(buffer, buffer.length, pacote.getAddress(), pacote.getPort());

            dtSocket.send(pacote);

            dtSocket.close();

        } catch (IOException ex) {

            System.out.println("Não foi possível montar a conexão no servidor.");

            ex.printStackTrace();

        }
    }
    
}
