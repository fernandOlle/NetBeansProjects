package com.exemplos;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author owzi
 */
public class Quarto {

    /* DataInputStream */
    
    public static void main(String[] args) {
        DataInputStream dis = null;
        try {
            File arquivo = new File("/home/owzi/testePC2/ola.txt");
            dis = new DataInputStream(new FileInputStream(arquivo));
            String msg = dis.readUTF();
            double val1 = dis.readDouble();
            int val2 = dis.readInt();
            dis.close();
            System.out.printf("Mensagem [%s] val1[%f] val2[%d] \n", msg, val1, val2);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
