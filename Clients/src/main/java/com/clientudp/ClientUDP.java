package com.clientudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author owzi
 */
public class ClientUDP {
     public static void main(String[] args) {
        try {
            DatagramSocket dtSocket = new DatagramSocket();
            InetAddress addr = InetAddress.getByName("127.0.0.1");
            byte[] buffer = "Cliente 1".getBytes();
            DatagramPacket pacote = new DatagramPacket(buffer, buffer.length, addr, 8889);
            System.out.println("IP do Cliente: " + pacote.getAddress().getHostAddress());
            System.out.println("Porta do Cliente: " + dtSocket.getLocalPort());
            dtSocket.send(pacote);
            pacote = new DatagramPacket(new byte[512], 512);
            dtSocket.receive(pacote);
            String msgServidor = new String(pacote.getData());
            System.out.println("Mensagem do Servidor: " + msgServidor);
            System.out.println("IP do Servidor: " + pacote.getAddress().getHostAddress());
            System.out.println("Porta do Servidor: " + pacote.getPort());
            dtSocket.close();
        } catch (IOException ex) {
            System.out.println("Não foi possível montar a conexão no cliente.");
            ex.printStackTrace();
        }
    }
}
